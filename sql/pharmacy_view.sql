drop view if exists v_payment_transactions;
drop view if exists v_transaction_summary;
drop view if exists v_payment_methods_breakdown;
drop view if exists v_daily_transaction_report;
drop view if exists v_transaction_with_payment_details;


-- Create a comprehensive view for payments and transactions
CREATE OR REPLACE VIEW v_payment_transactions AS
SELECT
  -- Transaction Information
  pt.id AS transaction_id,
  pt.prescription_id,
  pt.patient_id,
  pt.station_id,
  pt.status AS transaction_status,
  pt.total_amount AS transaction_total,
  pt.created_at AS transaction_created_at,
  pt.metadata AS transaction_metadata,

  -- Payment Information
  p.id AS payment_id,
  p.payment_method,
  p.amount AS payment_amount,
  p.payment_meta,

  -- Calculated Fields
  COALESCE(p.amount, 0) AS amount_paid,
  (pt.total_amount - COALESCE(p.amount, 0)) AS amount_remaining,
  CASE
    WHEN COALESCE(p.amount, 0) >= pt.total_amount THEN 'PAID'
    WHEN COALESCE(p.amount, 0) > 0 THEN 'PARTIAL'
    ELSE 'UNPAID'
  END AS payment_status,

  -- Count of payments per transaction
  COUNT(p.id) OVER (PARTITION BY pt.id) AS payment_count,

  -- Sum of all payments per transaction
  SUM(COALESCE(p.amount, 0)) OVER (PARTITION BY pt.id) AS total_paid,

  -- Row number for ordering payments
  ROW_NUMBER() OVER (PARTITION BY pt.id ORDER BY p.id ASC) AS payment_sequence
FROM
  pos_transactions pt
LEFT JOIN
  payments p ON pt.id = p.pos_transaction_id
ORDER BY
  pt.created_at DESC,
  p.id ASC;

-- Create a summary view showing transaction totals and payment breakdown

CREATE OR REPLACE VIEW v_transaction_summary AS
SELECT
  pt.id AS transaction_id,
  pt.prescription_id,
  pt.patient_id,
  pat.first_name AS patient_first_name,
  pat.last_name AS patient_last_name,
  (pat.first_name || ' ' || pat.last_name) AS patient_full_name,
  pat.mrn AS patient_mrn,
  pres.prescriber_name,
  pres.drug_name,
  pt.station_id,
  pt.status,
  pt.total_amount,
  pt.created_at,
  COUNT(DISTINCT p.id) AS total_payments,
  SUM(COALESCE(p.amount, 0)) AS total_paid,
  (pt.total_amount - COALESCE(SUM(p.amount), 0)) AS balance_due,
  ROUND((COALESCE(SUM(p.amount), 0) / NULLIF(pt.total_amount, 0) * 100)::NUMERIC, 2) AS payment_percentage,
  CASE
    WHEN pt.status = 'refunded' THEN 'REFUNDED'
    WHEN COALESCE(SUM(p.amount), 0) >= pt.total_amount THEN 'PAID'
    WHEN COALESCE(SUM(p.amount), 0) > 0 THEN 'PARTIAL'
    ELSE 'UNPAID'
  END AS payment_status,
  STRING_AGG(DISTINCT p.payment_method, ', ' ORDER BY p.payment_method) AS payment_methods_used
FROM
  pos_transactions pt
LEFT JOIN
  payments p ON pt.id = p.pos_transaction_id
LEFT JOIN
  patients pat ON pt.patient_id = pat.id
LEFT JOIN
  v_prescription_summary pres ON pt.prescription_id = pres.prescription_id
GROUP BY
  pt.id,
  pt.prescription_id,
  pt.patient_id,
  pat.first_name,
  pat.last_name,
  pat.mrn,
  pres.prescriber_name,
  pres.drug_name,
  pt.station_id,
  pt.status,
  pt.total_amount,
  pt.created_at
ORDER BY
  pt.created_at DESC;

-- Create a detailed payment methods view
CREATE OR REPLACE VIEW v_payment_methods_breakdown AS
SELECT
  pt.id AS transaction_id,
  pt.status AS transaction_status,
  pt.total_amount,
  p.payment_method,
  COUNT(p.id) AS payment_count,
  SUM(p.amount) AS method_total,
  ROUND((SUM(p.amount) / NULLIF(pt.total_amount, 0) * 100)::NUMERIC, 2) AS percentage_of_total,
  (ARRAY_AGG(p.id ORDER BY p.id ASC) FILTER (WHERE p.id IS NOT NULL))[1] AS first_payment_id,
  (ARRAY_AGG(p.id ORDER BY p.id DESC) FILTER (WHERE p.id IS NOT NULL))[1] AS last_payment_id,
  MIN((p.payment_meta->>'timestamp')::TIMESTAMPTZ) AS first_payment_time,
  MAX((p.payment_meta->>'timestamp')::TIMESTAMPTZ) AS last_payment_time
FROM
  pos_transactions pt
LEFT JOIN
  payments p ON pt.id = p.pos_transaction_id
WHERE
  p.id IS NOT NULL
GROUP BY
  pt.id,
  pt.status,
  pt.total_amount,
  p.payment_method
ORDER BY
  pt.id DESC,
  method_total DESC;

-- Create a view for unpaid and partial payment transactions requiring follow-up
CREATE OR REPLACE VIEW v_outstanding_payments AS
SELECT
  pt.id AS transaction_id,
  pt.prescription_id,
  pt.patient_id,
  pt.station_id,
  pt.status,
  pt.total_amount,
  COALESCE(SUM(p.amount), 0) AS total_paid,
  (pt.total_amount - COALESCE(SUM(p.amount), 0)) AS amount_due,
  ROUND(((pt.total_amount - COALESCE(SUM(p.amount), 0)) / NULLIF(pt.total_amount, 0) * 100)::NUMERIC, 2) AS percentage_due,
  pt.created_at,
  CURRENT_DATE - pt.created_at::DATE AS days_outstanding,
  CASE
    WHEN CURRENT_DATE - pt.created_at::DATE > 90 THEN 'OVERDUE_90_DAYS'
    WHEN CURRENT_DATE - pt.created_at::DATE > 60 THEN 'OVERDUE_60_DAYS'
    WHEN CURRENT_DATE - pt.created_at::DATE > 30 THEN 'OVERDUE_30_DAYS'
    WHEN CURRENT_DATE - pt.created_at::DATE > 7 THEN 'OVERDUE_7_DAYS'
    ELSE 'CURRENT'
  END AS aging_bucket,
  STRING_AGG(DISTINCT p.payment_method, ', ' ORDER BY p.payment_method) AS payments_received,
  COUNT(DISTINCT p.id) AS payment_count
FROM
  pos_transactions pt
LEFT JOIN
  payments p ON pt.id = p.pos_transaction_id
WHERE
  pt.status != 'refunded'
GROUP BY
  pt.id,
  pt.prescription_id,
  pt.patient_id,
  pt.station_id,
  pt.status,
  pt.total_amount,
  pt.created_at
HAVING
  (pt.total_amount - COALESCE(SUM(p.amount), 0)) > 0
ORDER BY
  days_outstanding DESC,
  amount_due DESC;

-- Create a daily transaction report view
CREATE OR REPLACE VIEW v_daily_transaction_report AS
SELECT
  pt.station_id,
  DATE(pt.created_at) AS transaction_date,
  pt.status,
  COUNT(DISTINCT pt.id) AS transaction_count,
  SUM(pt.total_amount) AS total_transaction_amount,
  COUNT(DISTINCT p.id) AS total_payments,
  SUM(p.amount) AS total_paid_amount,
  SUM(pt.total_amount) - SUM(COALESCE(p.amount, 0)) AS total_due_amount,
  ROUND((SUM(COALESCE(p.amount, 0)) / NULLIF(SUM(pt.total_amount), 0) * 100)::NUMERIC, 2) AS payment_percentage,
  COUNT(DISTINCT CASE WHEN pt.status = 'completed' THEN pt.id END) AS completed_transactions,
  COUNT(DISTINCT CASE WHEN pt.status = 'pending' THEN pt.id END) AS pending_transactions,
  COUNT(DISTINCT CASE WHEN pt.status = 'refunded' THEN pt.id END) AS refunded_transactions
FROM
  pos_transactions pt
LEFT JOIN
  payments p ON pt.id = p.pos_transaction_id
GROUP BY
  pt.station_id,
  DATE(pt.created_at),
  pt.status
ORDER BY
  transaction_date DESC,
  pt.station_id ASC;

-- Create a view for transaction with all payment details
CREATE OR REPLACE VIEW v_transaction_with_payment_details AS
SELECT
  pt.id,
  pt.prescription_id,
  pt.patient_id,
  pt.station_id,
  pt.status,
  pt.total_amount,
  pt.created_at,
  pt.metadata,
  jsonb_agg(
    jsonb_build_object(
      'payment_id', p.id,
      'payment_method', p.payment_method,
      'amount', p.amount,
      'payment_meta', p.payment_meta
    ) ORDER BY p.id ASC
  ) FILTER (WHERE p.id IS NOT NULL) AS payments_array,
  COUNT(DISTINCT p.id) AS payment_count,
  SUM(COALESCE(p.amount, 0)) AS total_paid,
  (pt.total_amount - COALESCE(SUM(p.amount), 0)) AS remaining_balance
FROM
  pos_transactions pt
LEFT JOIN
  payments p ON pt.id = p.pos_transaction_id
GROUP BY
  pt.id,
  pt.prescription_id,
  pt.patient_id,
  pt.station_id,
  pt.status,
  pt.total_amount,
  pt.created_at,
  pt.metadata
ORDER BY
  pt.created_at DESC;

-- ==================== Combined Claims View ====================
-- This view combines the claims and prescription_claims tables to provide
-- a unified view of all insurance claims and reimbursement data
CREATE OR REPLACE VIEW v_prescription_claims_combined AS
SELECT
  -- Primary Keys
  c.id AS claim_id,
  pc.id AS prescription_claim_id,

  -- Foreign Keys
  c.prescription_id,
  pc.patient_insurance_id,

  -- Claim Identifiers
  pc.claim_number,
  pc.prior_authorization_number,

  -- Payer Information
  c.payer_name,

  -- Claim Status (prioritize prescription_claims status if available)
  COALESCE(pc.claim_status, c.claim_status) AS claim_status,

  -- Rejection Information
  pc.rejection_code,
  pc.rejection_reason,

  -- Financial Data
  pc.billed_amount,
  pc.reimbursed_amount,
  pc.patient_responsibility,

  -- Calculated Financial Fields
  COALESCE(pc.billed_amount, 0) - COALESCE(pc.reimbursed_amount, 0) AS write_off_amount,
  CASE
    WHEN pc.billed_amount IS NOT NULL AND pc.billed_amount > 0
    THEN ROUND((COALESCE(pc.reimbursed_amount, 0) / pc.billed_amount * 100)::NUMERIC, 2)
    ELSE NULL
  END AS reimbursement_percentage,

  -- Response and Adjudication Data
  c.response AS claim_response,
  pc.adjudication_data AS prescription_claim_adjudication,
  c.fiscal_fields AS claim_fiscal_fields,

  -- Timestamps
  c.submitted_at AS claim_submitted_at,
  pc.claim_date AS prescription_claim_date,
  pc.created_at AS prescription_claim_created_at,
  pc.updated_at AS prescription_claim_updated_at,

  -- Calculated Status Fields
  CASE
    WHEN COALESCE(pc.claim_status, c.claim_status) = 'approved' THEN 'SUCCESS'
    WHEN COALESCE(pc.claim_status, c.claim_status) = 'rejected' THEN 'FAILED'
    WHEN COALESCE(pc.claim_status, c.claim_status) = 'pending' THEN 'PENDING'
    WHEN COALESCE(pc.claim_status, c.claim_status) = 'submitted' THEN 'SUBMITTED'
    WHEN COALESCE(pc.claim_status, c.claim_status) = 'reversed' THEN 'REVERSED'
    ELSE 'UNKNOWN'
  END AS claim_outcome,

  -- Timing Analysis
  CASE
    WHEN c.submitted_at IS NOT NULL
    THEN (NOW() - c.submitted_at)::INTERVAL
    ELSE NULL
  END AS time_since_submission,

  CASE
    WHEN c.submitted_at IS NOT NULL
    THEN (EXTRACT(DAY FROM (NOW() - c.submitted_at)))::INT
    ELSE NULL
  END AS days_since_submission

FROM claims c
FULL OUTER JOIN prescription_claims pc
  ON c.prescription_id = pc.prescription_id

ORDER BY
  COALESCE(c.submitted_at, pc.claim_date) DESC NULLS LAST,
  c.id;

-- ==================== Alternative: Left Join View ====================
-- Use this if you want all prescription_claims with optional claim data
-- (useful if not all prescription_claims have corresponding claims entry)
CREATE OR REPLACE VIEW v_prescription_claims_full AS
SELECT
  -- Primary Keys
  c.id AS claim_id,
  pc.id AS prescription_claim_id,

  -- Foreign Keys
  pc.prescription_id,
  pc.patient_insurance_id,

  -- Claim Identifiers
  pc.claim_number,
  pc.prior_authorization_number,

  -- Payer Information
  c.payer_name,

  -- Claim Status
  COALESCE(pc.claim_status, c.claim_status) AS claim_status,

  -- Rejection Information
  pc.rejection_code,
  pc.rejection_reason,

  -- Financial Data
  pc.billed_amount,
  pc.reimbursed_amount,
  pc.patient_responsibility,
  COALESCE(pc.billed_amount, 0) - COALESCE(pc.reimbursed_amount, 0) AS write_off_amount,
  CASE
    WHEN pc.billed_amount IS NOT NULL AND pc.billed_amount > 0
    THEN ROUND((COALESCE(pc.reimbursed_amount, 0) / pc.billed_amount * 100)::NUMERIC, 2)
    ELSE NULL
  END AS reimbursement_percentage,

  -- Response Data
  c.response AS claim_response,
  pc.adjudication_data,
  c.fiscal_fields,

  -- Timestamps
  c.submitted_at,
  pc.claim_date,
  pc.created_at,
  pc.updated_at,

  -- Status Fields
  CASE
    WHEN COALESCE(pc.claim_status, c.claim_status) = 'APPROVED' THEN 'SUCCESS'
    WHEN COALESCE(pc.claim_status, c.claim_status) = 'REJECTED' THEN 'FAILED'
    WHEN COALESCE(pc.claim_status, c.claim_status) = 'PENDING' THEN 'PENDING'
    WHEN COALESCE(pc.claim_status, c.claim_status) = 'SUBMITTED' THEN 'SUBMITTED'
    WHEN COALESCE(pc.claim_status, c.claim_status) = 'REVERSED' THEN 'REVERSED'
    ELSE 'UNKNOWN'
  END AS claim_outcome,

  -- Days Since Submission
  CASE
    WHEN COALESCE(c.submitted_at, pc.claim_date) IS NOT NULL
    THEN (EXTRACT(DAY FROM (NOW() - COALESCE(c.submitted_at, pc.claim_date))))::INT
    ELSE NULL
  END AS days_since_submission

FROM prescription_claims pc
LEFT JOIN claims c
  ON pc.prescription_id = c.prescription_id

ORDER BY
  COALESCE(c.submitted_at, pc.claim_date) DESC NULLS LAST;

-- ==================== Summary View: Claims Statistics ====================
-- Aggregate view for reporting and analytics
CREATE OR REPLACE VIEW v_claims_summary AS
SELECT
  -- Count by Status
  COALESCE(pc.claim_status, c.claim_status) AS claim_status,
  COUNT(*) AS total_claims,
  COUNT(CASE WHEN pc.claim_status = 'approved' THEN 1 END) AS approved_count,
  COUNT(CASE WHEN pc.claim_status = 'rejected' THEN 1 END) AS rejected_count,
  COUNT(CASE WHEN pc.claim_status = 'pending' THEN 1 END) AS pending_count,

  -- Financial Summary
  SUM(pc.billed_amount) AS total_billed,
  SUM(pc.reimbursed_amount) AS total_reimbursed,
  SUM(pc.patient_responsibility) AS total_patient_responsibility,
  SUM(COALESCE(pc.billed_amount, 0) - COALESCE(pc.reimbursed_amount, 0)) AS total_write_off,

  -- Average Metrics
  ROUND(AVG(pc.billed_amount)::NUMERIC, 2) AS avg_billed_amount,
  ROUND(AVG(pc.reimbursed_amount)::NUMERIC, 2) AS avg_reimbursed_amount,
  CASE
    WHEN AVG(pc.billed_amount) > 0
    THEN ROUND((AVG(COALESCE(pc.reimbursed_amount, 0)) / AVG(pc.billed_amount) * 100)::NUMERIC, 2)
    ELSE NULL
  END AS avg_reimbursement_percentage,

  -- Payer Information
  c.payer_name,
  COUNT(DISTINCT c.payer_name) AS unique_payers

FROM prescription_claims pc
LEFT JOIN claims c
  ON pc.prescription_id = c.prescription_id

GROUP BY
  COALESCE(pc.claim_status, c.claim_status),
  c.payer_name

ORDER BY
  total_claims DESC,
  claim_status;


CREATE OR REPLACE VIEW v_patient_insurance_details AS
SELECT
    p.id AS patient_id,
    p.mrn,
    p.first_name,
    p.last_name,
    p.dob,
    p.gender,
    p.preferred_language,
    p.is_student_record,
    p.contact,
    p.accessibility_preferences,

    pi.id AS patient_insurance_id,
    pi.member_id,
    pi.group_number,
    pi.plan_name,
    pi.coverage_type,
    pi.copay_fixed,
    pi.copay_percent,
    pi.deductible,
    pi.out_of_pocket_max,
    pi.status AS insurance_status,
    pi.effective_date,
    pi.expiration_date,

    ic.id AS insurance_company_id,
    ic.name AS insurance_company_name,
    ic.type AS insurance_company_type,
    ic.payer_id,
    ic.contact_number AS insurance_contact_number,
    ic.fax_number AS insurance_fax_number,
    ic.email AS insurance_email,
    ic.address AS insurance_address,
    ic.city AS insurance_city,
    ic.state AS insurance_state,
    ic.zip AS insurance_zip,
    ic.website AS insurance_website,

    GREATEST(p.created_at, pi.created_at, ic.created_at) AS record_created_at,
    LEAST(COALESCE(pi.expiration_date, CURRENT_DATE), CURRENT_DATE) AS record_valid_until
FROM patients p
LEFT JOIN patient_insurances pi ON p.id = pi.patient_id
LEFT JOIN insurance_companies ic ON pi.insurance_company_id = ic.id;


CREATE OR REPLACE VIEW public.v_prescription_summary
 AS
 SELECT p.id AS prescription_id,
    p.issue_date,
    p.status,
    p.priority,
	p.workflow_step_id,
	workflow.display_name as workflow_descr,
    p.notes AS description,
    p.prescriber_name,
	p.assigned_to,
    i.name AS drug_name,
    i.strength AS drug_strength,
    i.form AS drug_form,
    pt.first_name,
	pt.last_name,
    pt.mrn AS patient_mrn,
    pt.dob AS patient_dob,
    pt.gender AS patient_gender,
    p.created_at,
	pt.copay_fixed,
	pt.insurance_company_name
   FROM prescriptions p
     JOIN prescription_items item ON p.id = item.prescription_id
	 JOIN workflow_steps workflow ON p.workflow_step_id = workflow.id
     LEFT JOIN v_patient_insurance_details pt ON p.patient_id = pt.patient_id
     LEFT JOIN inventory_items i ON item.inventory_item_id = i.id
	 where pt.insurance_status='active';

ALTER TABLE public.v_prescription_summary
    OWNER TO postgres;


CREATE OR REPLACE VIEW v_prescription_queue_summary AS
SELECT
    wq.name AS queue_name,
    COUNT(p.id) AS total_prescriptions,
    COUNT(p.id) FILTER (WHERE p.priority = 'urgent') AS urgent_count,
    COUNT(p.id) FILTER (WHERE p.workflow_status = 'ready_for_pickup') AS ready_for_pickup_count,
    COUNT(p.id) FILTER (WHERE p.workflow_status = 'on_hold') AS on_hold_count,
    MAX(p.last_status_update) AS last_activity
FROM prescriptions p
LEFT JOIN workflow_queues wq ON wq.name = p.queue_name
GROUP BY wq.name;

CREATE OR REPLACE VIEW v_inventory_overview AS
SELECT
  -- Inventory Item Details
  ii.id AS item_id,
  ii.ndc,
  ii.sku,
  ii.name,
  ii.strength,
  ii.form,
  ii.pack_size,
  ii.attributes,

  -- Batch Details
  ib.id AS batch_id,
  ib.lot_number,
  ib.expiry_date,
  ib.quantity_on_hand,
  ib.location,
  ib.wholesaler_id,
  ib.last_order,
  -- Reorder Rule Details
  rr.min_level,
  rr.max_level,
  rr.preferred_wholesalers,

  -- Calculated Fields
  (ib.quantity_on_hand < rr.min_level) AS needs_reorder,
  (rr.max_level - ib.quantity_on_hand) AS reorder_quantity,
  CASE
    WHEN ib.expiry_date IS NOT NULL THEN (ib.expiry_date - CURRENT_DATE)::INT
    ELSE NULL
  END AS days_until_expiry,
  CASE
    WHEN ib.expiry_date IS NOT NULL AND (ib.expiry_date - CURRENT_DATE)::INT < 30 THEN 'URGENT'
    WHEN ib.expiry_date IS NOT NULL AND (ib.expiry_date - CURRENT_DATE)::INT < 90 THEN 'WARNING'
    WHEN ib.expiry_date IS NOT NULL THEN 'OK'
    ELSE 'NO_EXPIRY'
  END AS expiry_status,

  (CURRENT_DATE - DATE(ib.last_order))::INT AS days_since_last_order,
  CASE
    WHEN ib.last_order IS NULL THEN 'NEVER_ORDERED'
    WHEN (CURRENT_DATE - DATE(ib.last_order))::INT < 7 THEN 'RECENTLY_ORDERED'
    WHEN (CURRENT_DATE - DATE(ib.last_order))::INT < 30 THEN 'ORDERED_THIS_MONTH'
    WHEN (CURRENT_DATE - DATE(ib.last_order))::INT < 90 THEN 'ORDERED_THIS_QUARTER'
    ELSE 'LONG_TIME_AGO'
  END AS order_frequency_status,

  -- Timestamps
  ii.created_at AS item_created_at,
  ib.created_at AS batch_created_at

FROM inventory_items ii
JOIN inventory_batches ib ON ii.id = ib.inventory_item_id
LEFT JOIN reorder_rules rr ON ii.id = rr.inventory_item_id
ORDER BY ii.name, ib.lot_number;

-- Schedule weekly
-- SELECT enforce_audit_retention();

-- =============================
-- 4️⃣ COMPLIANCE SUMMARY VIEWS
-- =============================

-- Monthly User Access Summary
CREATE OR REPLACE VIEW v_user_access_summary_monthly AS
SELECT
    u.id AS user_id,
    u.username,
    date_trunc('month', a.accessed_at) AS month,
    COUNT(*) AS total_accesses,
    COUNT(DISTINCT a.patient_id) AS distinct_patients_accessed,
    jsonb_object_agg(a.action, cnt) FILTER (WHERE cnt IS NOT NULL) AS action_breakdown,
    jsonb_object_agg(a.access_reason, reason_cnt) FILTER (WHERE reason_cnt IS NOT NULL) AS reason_breakdown
FROM (
    SELECT
        user_id,
        accessed_at,
        action,
        access_reason,
        patient_id,
        COUNT(*) AS cnt,
        COUNT(*) AS reason_cnt
    FROM access_logs
    GROUP BY user_id, accessed_at, action, access_reason, patient_id
) a
JOIN users u ON u.id = a.user_id
GROUP BY u.id, u.username, date_trunc('month', a.accessed_at);

-- Patient Access Audit Summary
CREATE OR REPLACE VIEW v_patient_access_audit AS
SELECT
    p.id AS patient_id,
    p.mrn,
    p.is_student_record,
    u.username AS accessed_by,
    a.action,
    a.access_reason,
    COUNT(*) AS access_count,
    MIN(a.accessed_at) AS first_access,
    MAX(a.accessed_at) AS last_access
FROM access_logs a
JOIN patients p ON p.id = a.patient_id
JOIN users u ON u.id = a.user_id
GROUP BY p.id, p.mrn, p.is_student_record, u.username, a.action, a.access_reason;

-- PDMP Query Summary
CREATE OR REPLACE VIEW v_pdmp_query_summary AS
SELECT
    u.id AS user_id,
    u.username,
    date_trunc('month', q.created_at) AS month,
    COUNT(*) AS total_queries,
    COUNT(*) FILTER (WHERE q.status = 'success') AS successful_queries,
    COUNT(*) FILTER (WHERE q.status = 'failed') AS failed_queries,
    ROUND(AVG(EXTRACT(EPOCH FROM (q.completed_at - q.transmitted_at))), 2) AS avg_latency_seconds,
    jsonb_object_agg(q.query_reason, reason_cnt) FILTER (WHERE reason_cnt IS NOT NULL) AS reasons
FROM (
    SELECT user_id, created_at, status, transmitted_at, completed_at, query_reason, COUNT(*) AS reason_cnt
    FROM pdmp_queries
    GROUP BY user_id, created_at, status, transmitted_at, completed_at, query_reason
) q
JOIN users u ON u.id = q.user_id
GROUP BY u.id, u.username, date_trunc('month', q.created_at);

-- PDMP Noncompliance Flags
CREATE OR REPLACE VIEW v_pdmp_noncompliance_flags AS
SELECT
    pr.id AS prescription_id,
    pr.patient_id,
    pr.prescriber_name,
    pr.issue_date,
    pr.status,
    pi.is_controlled,
    COUNT(q.id) FILTER (
        WHERE q.patient_id = pr.patient_id
          AND q.created_at > (pr.issue_date - INTERVAL '1 day')
          AND q.created_at <= pr.issue_date
    ) AS pdmp_queries_last_24h,
    CASE
        WHEN pi.is_controlled AND
             COUNT(q.id) FILTER (
                 WHERE q.patient_id = pr.patient_id
                   AND q.created_at > (pr.issue_date - INTERVAL '1 day')
                   AND q.created_at <= pr.issue_date
             ) = 0
        THEN 'MISSING_PDMP_QUERY'
        ELSE NULL
    END AS compliance_flag
FROM prescriptions pr
JOIN prescription_items pi ON pi.prescription_id = pr.id
LEFT JOIN pdmp_queries q ON q.patient_id = pr.patient_id
GROUP BY pr.id, pr.patient_id, pr.prescriber_name, pr.issue_date, pr.status, pi.is_controlled;

-- Compliance Overview Dashboard
CREATE OR REPLACE VIEW v_compliance_overview_dashboard AS
SELECT
    CURRENT_DATE AS report_date,
    (SELECT COUNT(*) FROM access_logs WHERE accessed_at > now() - INTERVAL '30 days') AS accesses_30d,
    (SELECT COUNT(DISTINCT user_id) FROM access_logs WHERE accessed_at > now() - INTERVAL '30 days') AS active_users_30d,
    (SELECT COUNT(*) FROM pdmp_queries WHERE status = 'success' AND created_at > now() - INTERVAL '30 days') AS pdmp_success_30d,
    (SELECT COUNT(*) FROM v_pdmp_noncompliance_flags WHERE compliance_flag = 'MISSING_PDMP_QUERY') AS pdmp_flags_30d;


-- ====================================
-- 5️⃣ OPTIONAL MATERIALIZED VIEW CACHE
-- ====================================
CREATE MATERIALIZED VIEW IF NOT EXISTS mv_user_access_summary_monthly AS
SELECT * FROM v_user_access_summary_monthly;


-- ============================================================
-- 7️⃣ COMPLIANCE VIEW: E-FAX SUMMARY
-- ============================================================
CREATE OR REPLACE VIEW v_efax_summary AS
SELECT
    e.id AS efax_job_id,
    e.direction,
    e.status,
    e.patient_id,
    e.prescription_id,
    e.user_id,
    e.fax_number,
    e.subject,
    e.total_pages,
    e.created_at,
    e.sent_at,
    e.completed_at,
    COUNT(a.id) AS attachments_count,
    COUNT(sl.id) FILTER (WHERE sl.status = 'failed') AS failures,
    MAX(sl.created_at) AS last_status_update
FROM efax_jobs e
LEFT JOIN efax_attachments a ON a.efax_job_id = e.id
LEFT JOIN efax_status_logs sl ON sl.efax_job_id = e.id
GROUP BY e.id, e.direction, e.status, e.patient_id, e.prescription_id, e.user_id, e.fax_number, e.subject, e.total_pages, e.created_at, e.sent_at, e.completed_at;


-- ============================================================
-- 6️⃣ COMPLIANCE + SUMMARY VIEW
-- ============================================================
CREATE OR REPLACE VIEW v_insurance_compliance_summary AS
SELECT
    i.name AS insurance_company,
    COUNT(DISTINCT pi.patient_id) AS patients_covered,
    COUNT(DISTINCT c.id) AS claims_processed,
    SUM(c.billed_amount) AS total_billed,
    SUM(c.reimbursed_amount) AS total_reimbursed,
    SUM(cp.copay_amount) FILTER (WHERE cp.copay_status = 'paid') AS total_copays_collected,
    SUM(cp.copay_amount) FILTER (WHERE cp.copay_status = 'unpaid') AS total_copays_pending,
    COUNT(DISTINCT CASE WHEN c.claim_status = 'rejected' THEN c.id END) AS rejected_claims,
    COUNT(DISTINCT CASE WHEN c.claim_status = 'approved' THEN c.id END) AS approved_claims
FROM insurance_companies i
LEFT JOIN patient_insurances pi ON pi.insurance_company_id = i.id
LEFT JOIN prescription_claims c ON c.patient_insurance_id = pi.id
LEFT JOIN prescription_copays cp ON cp.claim_id = c.id
GROUP BY i.name;
-- ============================================================
-- ✅ END OF E-FAX EXTENSION SCHEMA
-- ============================================================

