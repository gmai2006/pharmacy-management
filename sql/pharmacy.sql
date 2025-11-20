-- ---------- Extension prerequisites ----------
-- Required: pgcrypto for encryption helpers (optional), citext for case-insensitive text
CREATE EXTENSION IF NOT EXISTS pgcrypto;
CREATE EXTENSION IF NOT EXISTS citext;

-- ---------- Core users & roles ----------
CREATE TABLE roles (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL UNIQUE,
  description TEXT
);

CREATE TABLE users (
  id UUID PRIMARY KEY,
  username citext NOT NULL UNIQUE,
  display_name TEXT,
  email citext NOT NULL UNIQUE,
  role_id INT REFERENCES roles(id),
  is_active BOOLEAN NOT NULL DEFAULT TRUE,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT now(),
  last_login_at TIMESTAMP WITH TIME ZONE
);

-- SSO mapping (Okta)
CREATE TABLE user_sso (
  id UUID PRIMARY KEY,
  user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  provider TEXT NOT NULL, -- e.g., 'okta'
  external_id TEXT NOT NULL,
  metadata JSONB,
  UNIQUE(provider, external_id)
);

-- Fine-grained permissions (optional)
CREATE TABLE user_permissions (
  id SERIAL PRIMARY KEY,
  user_id UUID REFERENCES users(id) ON DELETE CASCADE,
  permission_key TEXT NOT NULL, -- e.g., 'prescription.review.override'
  granted BOOLEAN NOT NULL DEFAULT true,
  granted_at TIMESTAMPTZ DEFAULT now()
);

-- ---------- Patients & sensitive profile ----------
CREATE TABLE patients (
  id UUID PRIMARY KEY,
  mrn TEXT, -- medical record number (nullable)
  first_name TEXT NOT NULL,
  last_name TEXT NOT NULL,
  dob DATE,
  gender TEXT,
  contact JSONB, -- phone, email, addresses
  -- sensitive_data should be encrypted at application level or using pgcrypto: recommended to not store plain PHI here
  sensitive_data BYTEA, -- encrypted blob (AES-256) or use pgcrypto functions
  is_student_record BOOLEAN DEFAULT FALSE, -- FERPA flag
  preferred_language TEXT,
  accessibility_preferences JSONB, -- e.g., {"large_print": true, "braille": false, "tts": true}
  created_at TIMESTAMPTZ DEFAULT now()
);
CREATE INDEX idx_patients_name ON patients (last_name, first_name);

CREATE TABLE patient_aliases (
  id SERIAL PRIMARY KEY,
  patient_id UUID REFERENCES patients(id) ON DELETE CASCADE,
  alias_type TEXT, -- e.g., 'school_id', 'insurance_id'
  alias_value TEXT,
  created_at TIMESTAMPTZ DEFAULT now()
);

-- ---------- Pharmacists / staff ----------
CREATE TABLE pharmacists (
  id UUID PRIMARY KEY,
  user_id UUID REFERENCES users(id) UNIQUE,
  license_number TEXT,
  license_state TEXT,
  active BOOLEAN DEFAULT TRUE
);

-- ---------- Inventory & wholesalers ----------
CREATE TABLE wholesalers (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  contact JSONB,
  trading_partner_id TEXT -- used for DSCSA trading partner validation
);

CREATE TABLE inventory_items (
  id UUID PRIMARY KEY,
  ndc TEXT, -- national drug code
  sku TEXT,
  name TEXT NOT NULL,
  strength TEXT,
  form TEXT, -- e.g., tablet, syrup
  pack_size INT,
  reorder_rule_id INT,
  attributes JSONB, -- e.g., DEA class, controlled flag, manufacturer
  created_at TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE inventory_batches (
  id UUID PRIMARY KEY,
  inventory_item_id UUID REFERENCES inventory_items(id) ON DELETE CASCADE,
  lot_number TEXT,
  expiry_date DATE,
  quantity_on_hand INT NOT NULL DEFAULT 0,
  location TEXT, -- store or shelf
  wholesaler_id INT REFERENCES wholesalers(id),
  created_at TIMESTAMPTZ DEFAULT now(),
  last_order TIMESTAMPTZ
);

-- DSCSA serials (one per serialized package)
CREATE TABLE dscsa_serials (
  id UUID PRIMARY KEY,
  batch_id UUID REFERENCES inventory_batches(id) ON DELETE CASCADE,
  serial_number TEXT NOT NULL,
  status TEXT NOT NULL DEFAULT 'in_stock', -- e.g., in_stock, shipped, verified
  trace_metadata JSONB, -- e.g., events, timestamps, trading partners
  last_updated TIMESTAMPTZ DEFAULT now()
);
CREATE UNIQUE INDEX uq_dscsa_serial_unique ON dscsa_serials (serial_number);

-- Reorder rules for automated reorder
CREATE TABLE reorder_rules (
  id SERIAL PRIMARY KEY,
  inventory_item_id UUID REFERENCES inventory_items(id) UNIQUE,
  min_level INT NOT NULL,
  max_level INT NOT NULL,
  preferred_wholesalers INT[] -- array of wholesaler ids in priority order
);

-- Purchase orders to wholesalers
CREATE TABLE purchase_orders (
  id UUID PRIMARY KEY,
  wholesaler_id INT REFERENCES wholesalers(id),
  created_by UUID REFERENCES users(id),
  status TEXT DEFAULT 'open', -- open, submitted, received, cancelled
  ordered_at TIMESTAMPTZ DEFAULT now(),
  expected_arrival DATE,
  payload JSONB -- PO details
);

-- ---------- Prescriptions ----------
CREATE TABLE prescriptions (
  id UUID PRIMARY KEY,
  patient_id UUID REFERENCES patients(id),
  prescriber_name TEXT,
  prescriber_dea TEXT,
  issue_date TIMESTAMPTZ DEFAULT now(),
  status TEXT NOT NULL DEFAULT 'pending', -- pending, reviewed, filled, transferred, voided
  workflow_step_id INTEGER NOT NULL REFERENCES workflow_steps(id),
  priority TEXT DEFAULT 'normal' CHECK (priority IN ('low', 'normal', 'high', 'urgent')),
  notes TEXT,
  metadata JSONB, -- e.g., eRx metadata, Surescripts IDs
  created_at TIMESTAMPTZ DEFAULT now(),
  queue_name TEXT,  -- Custom routing queue name (e.g. “Counseling”, “Insurance Hold”)
  assigned_to UUID REFERENCES users(id), -- Assigned technician/pharmacist
  last_status_update TIMESTAMPTZ DEFAULT now(),
  estimated_ready_time TIMESTAMPTZ,
  pickup_time TIMESTAMPTZ,
  completion_time TIMESTAMPTZ
);

CREATE TABLE prescription_items (
  id UUID PRIMARY KEY,
  prescription_id UUID REFERENCES prescriptions(id) ON DELETE CASCADE,
  inventory_item_id UUID REFERENCES inventory_items(id),
  quantity INT NOT NULL,
  days_supply INT,
  sig TEXT,
  refills_allowed INT DEFAULT 0,
  is_controlled BOOLEAN DEFAULT FALSE,
  label_options JSONB, -- accessibility options
  status TEXT DEFAULT 'active', -- active, cancelled
  created_at TIMESTAMPTZ DEFAULT now()
);

-- Electronic transfer / eRx log
CREATE TABLE prescription_transfers (
  id UUID PRIMARY KEY,
  prescription_id UUID REFERENCES prescriptions(id) ON DELETE CASCADE,
  transfer_type TEXT, -- 'send', 'receive'
  provider TEXT, -- e.g., 'Surescripts', 'CoverMyMeds'
  external_id TEXT,
  payload JSONB,
  transmitted_at TIMESTAMPTZ,
  status TEXT,
  signed BOOLEAN DEFAULT FALSE
);

-- Prescription audit (machine-readable change history)
CREATE TABLE prescription_audit (
  id BIGSERIAL PRIMARY KEY,
  prescription_id UUID REFERENCES prescriptions(id),
  user_id UUID REFERENCES users(id),
  action TEXT NOT NULL, -- created, updated, status_change, override
  diff JSONB,
  reason TEXT,
  created_at TIMESTAMPTZ DEFAULT now()
);
CREATE INDEX idx_prescription_audit_presc ON prescription_audit(prescription_id);

-- ---------- Workflows, queues, tasks ----------
---You can create **dynamic routing queues** that define what statuses route to which roles or departments.
CREATE TABLE workflows (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  description TEXT,
  config JSONB, -- workflow definition (steps, parallelization)
  created_by UUID REFERENCES users(id),
  created_at TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE workflow_steps (
  id SERIAL PRIMARY KEY,
  workflow_id INT REFERENCES workflows(id) ON DELETE CASCADE,
  step_key TEXT,
  display_name TEXT,
  config JSONB -- e.g., roles allowed, SLA, auto-assign
);

CREATE TABLE queues (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  description TEXT,
  config JSONB -- routing rules, filters
);

CREATE TABLE tasks (
  id UUID PRIMARY KEY,
  object_type TEXT NOT NULL, -- e.g., 'prescription', 'inventory_batch'
  object_id UUID NOT NULL,
  workflow_id INT REFERENCES workflows(id),
  step_id INT REFERENCES workflow_steps(id),
  queue_id INT REFERENCES queues(id),
  assignee UUID REFERENCES users(id),
  status TEXT DEFAULT 'open',
  payload JSONB,
  priority INT DEFAULT 0,
  created_at TIMESTAMPTZ DEFAULT now(),
  due_at TIMESTAMPTZ
);

CREATE TABLE task_routing (
  id SERIAL PRIMARY KEY,
  queue_id INT REFERENCES queues(id),
  rule_order INT DEFAULT 0,
  rule JSONB -- e.g., condition and assignment (role/user)
);

-- ---------- Barcode scanning & labeling ----------
CREATE TABLE barcode_labels (
  id UUID PRIMARY KEY,
  prescription_item_id UUID REFERENCES prescription_items(id),
  barcode TEXT NOT NULL,
  label_type TEXT, -- e.g., 'safety', 'patient', 'shipping'
  generated_at TIMESTAMPTZ DEFAULT now(),
  printed_by UUID REFERENCES users(id),
  print_payload JSONB -- layout, accessibility, QR content
);
CREATE UNIQUE INDEX uq_barcode_labels_barcode ON barcode_labels(barcode);

-- ---------- POS (point of sale) ----------
CREATE TABLE pos_transactions (
  id UUID PRIMARY KEY,
  prescription_id UUID REFERENCES prescriptions(id),
  patient_id UUID REFERENCES patients(id),
  station_id TEXT, -- station identifier
  total_amount NUMERIC(12,2) NOT NULL,
  status TEXT DEFAULT 'pending', -- pending, completed, refunded
  created_at TIMESTAMPTZ DEFAULT now(),
  metadata JSONB
);

CREATE TABLE pos_signatures (
  id UUID PRIMARY KEY,
  pos_transaction_id UUID REFERENCES pos_transactions(id) ON DELETE CASCADE,
  station_id TEXT,
  signature_data BYTEA, -- could be encoded signature blob / image
  signed_by UUID REFERENCES users(id), -- or null if patient signature
  signed_at TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE payments (
  id UUID PRIMARY KEY,
  pos_transaction_id UUID REFERENCES pos_transactions(id),
  payment_method TEXT,
  amount NUMERIC(12,2),
  payment_meta JSONB
);

-- ---------- Claims, DIR fees, AWP reclaims, profit protection ----------
CREATE TABLE claims (
  id UUID PRIMARY KEY,
  prescription_id UUID REFERENCES prescriptions(id),
  payer_name TEXT,
  claim_status TEXT,
  submitted_at TIMESTAMPTZ,
  response JSONB,
  fiscal_fields JSONB -- e.g., reimbursement amounts
);

CREATE TABLE IF NOT EXISTS dir_fees (
    id BIGSERIAL PRIMARY KEY,

    -- The claim this DIR fee applies to (required)
    claim_id UUID NOT NULL REFERENCES claims(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,

    -- Dollar amount of the DIR fee
    amount NUMERIC(12,2) NOT NULL CHECK (amount >= 0),

    -- PBM-provided reason (performance, network adjustment, etc.)
    reason TEXT,

    -- Date/time the DIR fee was assessed or recorded
    recorded_at TIMESTAMPTZ NOT NULL DEFAULT now(),

    -- Optional: Pharmacy’s reconciliation cycle (useful for DIR fee reports)
    reconciliation_period TEXT,    -- e.g., '2025-Q1', '2025-04'

    -- Optional: PBM name or payer identifier
    payer_name TEXT,

    -- Optional: PBM-provided raw metadata (JSON response, adjudication details)
    metadata JSONB
);

CREATE INDEX IF NOT EXISTS idx_dir_fees_claim_id
    ON dir_fees (claim_id);

CREATE INDEX IF NOT EXISTS idx_dir_fees_recorded_at
    ON dir_fees (recorded_at);

CREATE INDEX IF NOT EXISTS idx_dir_fees_reconciliation_period
    ON dir_fees (reconciliation_period);

CREATE TABLE awp_reclaims (
  id BIGSERIAL PRIMARY KEY,
  prescription_id UUID REFERENCES prescriptions(id),
  amount NUMERIC(12,2),
  processed_at TIMESTAMPTZ DEFAULT now(),
  notes TEXT
);

CREATE TABLE profit_audit_warnings (
  id BIGSERIAL PRIMARY KEY,
  related_object_type TEXT,
  related_object_id UUID,
  warning_code TEXT,
  description TEXT,
  created_at TIMESTAMPTZ DEFAULT now()
);

-- ---------- Clinical alerts ----------
CREATE TABLE alert_rules (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL,
  description TEXT,
  rule_json JSONB NOT NULL, -- e.g., rule language: {"type":"morphine_equiv","threshold":50}
  severity TEXT,
  active BOOLEAN DEFAULT TRUE,
  created_at TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE IF NOT EXISTS public.alert_logs
(
    id bigint NOT NULL DEFAULT nextval('alert_logs_id_seq'::regclass),
    alert_rule_id integer,
    prescription_id uuid,
    patient_id uuid,
    triggered_by uuid,
    context jsonb,
    action_taken text COLLATE pg_catalog."default",
    override_reason text COLLATE pg_catalog."default",
    created_at timestamp with time zone DEFAULT now(),
    suggested_alternatives jsonb,
    pharmacist_action text COLLATE pg_catalog."default",
    resolved_at timestamp with time zone,
    CONSTRAINT alert_logs_pkey PRIMARY KEY (id),
    CONSTRAINT alert_logs_alert_rule_id_fkey FOREIGN KEY (alert_rule_id)
        REFERENCES public.alert_rules (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT alert_logs_patient_id_fkey FOREIGN KEY (patient_id)
        REFERENCES public.patients (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT alert_logs_prescription_id_fkey FOREIGN KEY (prescription_id)
        REFERENCES public.prescriptions (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT alert_logs_triggered_by_fkey FOREIGN KEY (triggered_by)
        REFERENCES public.users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- ============================================================
-- 1️⃣ INSURANCE COMPANIES
-- ============================================================
CREATE TABLE IF NOT EXISTS insurance_companies (
    id UUID PRIMARY KEY ,
    name TEXT NOT NULL,
    type TEXT CHECK (type IN ('private', 'medicare', 'medicaid', 'university', 'other')),
    payer_id TEXT, -- NCPDP or internal payer identifier
    contact_number TEXT,
    fax_number TEXT,
    email TEXT,
    address TEXT,
    city TEXT,
    state TEXT,
    zip TEXT,
    website TEXT,
    created_at TIMESTAMPTZ DEFAULT now(),
    updated_at TIMESTAMPTZ DEFAULT now()
);

CREATE INDEX IF NOT EXISTS idx_insurance_companies_name ON insurance_companies (name);

-- ============================================================
-- 2️⃣ PATIENT INSURANCE LINK
-- ============================================================
CREATE TABLE IF NOT EXISTS patient_insurances (
    id UUID PRIMARY KEY ,
    patient_id UUID NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    insurance_company_id UUID NOT NULL REFERENCES insurance_companies(id),
    member_id TEXT NOT NULL,
    group_number TEXT,
    plan_name TEXT,
    effective_date DATE,
    expiration_date DATE,
    coverage_type TEXT CHECK (coverage_type IN ('primary', 'secondary', 'tertiary')),
    copay_fixed NUMERIC(10,2),
    copay_percent NUMERIC(5,2),
    deductible NUMERIC(10,2),
    out_of_pocket_max NUMERIC(10,2),
    status TEXT DEFAULT 'active' CHECK (status IN ('active', 'inactive')),
    created_at TIMESTAMPTZ DEFAULT now(),
    updated_at TIMESTAMPTZ DEFAULT now()
);

CREATE INDEX IF NOT EXISTS idx_patient_insurances_patient ON patient_insurances (patient_id);
CREATE INDEX IF NOT EXISTS idx_patient_insurances_company ON patient_insurances (insurance_company_id);

-- ============================================================
-- 3️⃣ PRESCRIPTION CLAIMS
-- ============================================================
CREATE TABLE IF NOT EXISTS prescription_claims (
    id UUID PRIMARY KEY ,
    prescription_id UUID NOT NULL REFERENCES prescriptions(id) ON DELETE CASCADE,
    patient_insurance_id UUID REFERENCES patient_insurances(id),
    claim_number TEXT,
    claim_status TEXT CHECK (claim_status IN ('SUBMITTED', 'APPROVED', 'REJECTED', 'PENDING', 'REVERSED')),
    claim_date TIMESTAMPTZ DEFAULT now(),
    billed_amount NUMERIC(10,2),
    reimbursed_amount NUMERIC(10,2),
    patient_responsibility NUMERIC(10,2),
    rejection_code TEXT,
    rejection_reason TEXT,
    prior_authorization_number TEXT,
    adjudication_data JSONB, -- payer response details
    created_at TIMESTAMPTZ DEFAULT now(),
    updated_at TIMESTAMPTZ DEFAULT now()
);

--ALTER TABLE prescription_claims
--DROP CONSTRAINT prescription_claims_claim_status_check;
--
--ALTER TABLE prescription_claims
--ADD CONSTRAINT prescription_claims_claim_status_check
--CHECK (claim_status IN ('SUBMITTED', 'APPROVED', 'REJECTED', 'PENDING', 'REVERSED'));

CREATE INDEX IF NOT EXISTS idx_prescription_claims_prescription ON prescription_claims (prescription_id);
CREATE INDEX IF NOT EXISTS idx_prescription_claims_status ON prescription_claims (claim_status);

-- ============================================================
-- 4️⃣ PRESCRIPTION COPAYS
-- ============================================================
CREATE TABLE IF NOT EXISTS prescription_copays (
    id UUID PRIMARY KEY ,
    prescription_id UUID NOT NULL REFERENCES prescriptions(id) ON DELETE CASCADE,
    patient_id UUID NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    insurance_company_id UUID REFERENCES insurance_companies(id),
    claim_id UUID REFERENCES prescription_claims(id),
    copay_amount NUMERIC(10,2) NOT NULL,
    copay_status TEXT DEFAULT 'unpaid' CHECK (copay_status IN ('unpaid', 'paid', 'waived', 'billed')),
    payment_method TEXT CHECK (payment_method IN ('cash', 'card', 'insurance', 'copay assistance', 'other')),
    payment_reference TEXT,
    paid_at TIMESTAMPTZ,
    created_at TIMESTAMPTZ DEFAULT now()
);

ALTER TABLE prescriptions
ADD COLUMN IF NOT EXISTS queue_name TEXT,  -- Custom routing queue name (e.g. “Counseling”, “Insurance Hold”)
ADD COLUMN IF NOT EXISTS assigned_to UUID REFERENCES users(id), -- Assigned technician/pharmacist
ADD COLUMN IF NOT EXISTS priority TEXT DEFAULT 'normal'
    CHECK (priority IN ('low', 'normal', 'high', 'urgent')),
ADD COLUMN IF NOT EXISTS last_status_update TIMESTAMPTZ DEFAULT now(),
ADD COLUMN IF NOT EXISTS estimated_ready_time TIMESTAMPTZ,
ADD COLUMN IF NOT EXISTS pickup_time TIMESTAMPTZ,
ADD COLUMN IF NOT EXISTS completion_time TIMESTAMPTZ;

CREATE TABLE IF NOT EXISTS prescription_workflow_logs (
    id BIGSERIAL PRIMARY KEY,
    prescription_id UUID NOT NULL REFERENCES prescriptions(id) ON DELETE CASCADE,
    from_status TEXT,
    to_status TEXT NOT NULL,
    queue_name TEXT,
    changed_by UUID REFERENCES users(id),
    change_reason TEXT,
    changed_at TIMESTAMPTZ DEFAULT now(),
    metadata JSONB -- additional context (e.g., "auto transition from claim approval")
);

CREATE INDEX IF NOT EXISTS idx_workflow_logs_prescription ON prescription_workflow_logs (prescription_id);
CREATE INDEX IF NOT EXISTS idx_workflow_logs_to_status ON prescription_workflow_logs (to_status);
CREATE INDEX IF NOT EXISTS idx_workflow_logs_changed_at ON prescription_workflow_logs (changed_at);

CREATE OR REPLACE FUNCTION log_prescription_workflow_change() RETURNS TRIGGER AS $$
BEGIN
    IF (OLD.workflow_status IS DISTINCT FROM NEW.workflow_status) THEN
        INSERT INTO prescription_workflow_logs (
            prescription_id,
            from_status,
            to_status,
            queue_name,
            changed_by,
            change_reason
        )
        VALUES (
            NEW.id,
            OLD.workflow_status,
            NEW.workflow_status,
            NEW.queue_name,
            NEW.assigned_to,
            'auto transition via update'
        );
        NEW.last_status_update := now();
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

DROP TRIGGER IF EXISTS trg_prescription_workflow_change ON prescriptions;

CREATE TRIGGER trg_prescription_workflow_change
BEFORE UPDATE ON prescriptions
FOR EACH ROW
WHEN (OLD.workflow_status IS DISTINCT FROM NEW.workflow_status)
EXECUTE FUNCTION log_prescription_workflow_change();

-- ---------- Integrations & HL7 / external events ----------
CREATE TABLE integrations (
  id SERIAL PRIMARY KEY,
  name TEXT NOT NULL, -- e.g., 'Surescripts', 'CoverMyMeds', 'HL7-Lab'
  type TEXT,
  config JSONB,
  created_at TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE integration_events (
  id UUID PRIMARY KEY,
  integration_id INT REFERENCES integrations(id),
  event_type TEXT,
  external_id TEXT,
  payload JSONB,
  processed_at TIMESTAMPTZ,
  status TEXT
);

-- ---------- Reporting (metadata & saved filters) ----------
CREATE TABLE reports (
  id UUID PRIMARY KEY,
  owner_id UUID REFERENCES users(id),
  name TEXT NOT NULL,
  description TEXT,
  filters JSONB,
  schedule JSONB, -- cron-like
  last_run TIMESTAMPTZ
);

-- ---------- Audit logs (generic) ----------
CREATE TABLE auth_logs (
    id BIGSERIAL PRIMARY KEY,
    user_id UUID REFERENCES users(id),
    username TEXT,
    event_type TEXT CHECK (event_type IN ('login','logout')),
    status TEXT CHECK (status IN ('success','failure')),
    ip_address TEXT,
    user_agent TEXT,
    metadata JSONB,
    created_at TIMESTAMPTZ DEFAULT now()
);

-- ---------- Consent & privacy ----------
CREATE TABLE consent_records (
  id UUID PRIMARY KEY,
  patient_id UUID REFERENCES patients(id),
  consent_type TEXT, -- e.g., 'data_sharing', 'student_health_release'
  granted BOOLEAN,
  source TEXT, -- e.g., 'in_person', 'online'
  recorded_by UUID REFERENCES users(id),
  recorded_at TIMESTAMPTZ DEFAULT now(),
  metadata JSONB
);

-- ---------- Encryption key metadata (do NOT store keys here in plaintext) ----------
CREATE TABLE encryption_keys_meta (
  id SERIAL PRIMARY KEY,
  key_id TEXT UNIQUE,
  purpose TEXT,
  created_at TIMESTAMPTZ DEFAULT now(),
  rotated_at TIMESTAMPTZ,
  metadata JSONB
);

-- ============================================================
-- 🏥 Pharmacy Compliance & Audit Schema Extension
-- Includes PDMP Queries, Access Logs, Partitioning, Retention,
-- and Compliance Summary Views
-- ============================================================

-- ======================
-- 1️⃣ PDMP QUERIES TABLE
-- ======================
CREATE TABLE IF NOT EXISTS pdmp_queries (
    id UUID PRIMARY KEY,
    patient_id UUID NOT NULL REFERENCES patients(id) ON DELETE CASCADE,
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    prescription_id UUID REFERENCES prescriptions(id),
    state TEXT NOT NULL,
    query_reason TEXT NOT NULL,
    status TEXT DEFAULT 'pending',
    response_code TEXT,
    response_payload JSONB,
    transmitted_at TIMESTAMPTZ DEFAULT now(),
    completed_at TIMESTAMPTZ,
    error_message TEXT,
    created_at TIMESTAMPTZ DEFAULT now()
);

-- Indexes for PDMP performance
CREATE INDEX IF NOT EXISTS idx_pdmp_queries_patient ON pdmp_queries (patient_id);
CREATE INDEX IF NOT EXISTS idx_pdmp_queries_user ON pdmp_queries (user_id);
CREATE INDEX IF NOT EXISTS idx_pdmp_queries_state_status ON pdmp_queries (state, status);
CREATE INDEX IF NOT EXISTS idx_pdmp_queries_created_at ON pdmp_queries (created_at);

-- =================================
-- 2️⃣ ACCESS LOGS (AUDIT TRAIL TABLE)
-- =================================
CREATE TABLE IF NOT EXISTS access_logs (
    id BIGSERIAL PRIMARY KEY,
    user_id UUID REFERENCES users(id),
    patient_id UUID REFERENCES patients(id),
    entity_type TEXT NOT NULL,
    entity_id UUID,
    action TEXT NOT NULL,
    access_reason TEXT,
    access_context JSONB,
    ip_address TEXT,
    user_agent TEXT,
    accessed_at TIMESTAMPTZ DEFAULT now()
);

CREATE INDEX IF NOT EXISTS idx_access_logs_user ON access_logs (user_id);
CREATE INDEX IF NOT EXISTS idx_access_logs_patient ON access_logs (patient_id);
CREATE INDEX IF NOT EXISTS idx_access_logs_entity ON access_logs (entity_type, entity_id);
CREATE INDEX IF NOT EXISTS idx_access_logs_time ON access_logs (accessed_at);

-- ====================================
-- 3️⃣ PARTITIONING & RETENTION POLICIES
-- ====================================

-- Convert audit tables to time-based partitions
ALTER TABLE access_logs
    SET (autovacuum_enabled = true, toast.autovacuum_enabled = true);

ALTER TABLE pdmp_queries
    SET (autovacuum_enabled = true, toast.autovacuum_enabled = true);

-- Create monthly partitions automatically
CREATE OR REPLACE FUNCTION create_audit_partitions() RETURNS void AS $$
DECLARE
    start_month DATE := date_trunc('month', now())::date;
    next_month DATE := start_month + INTERVAL '1 month';
BEGIN
    EXECUTE format('
        CREATE TABLE IF NOT EXISTS access_logs_%s
        PARTITION OF access_logs
        FOR VALUES FROM (%L) TO (%L);
    ', to_char(start_month, 'YYYYMM'), start_month, next_month);

    EXECUTE format('
        CREATE TABLE IF NOT EXISTS pdmp_queries_%s
        PARTITION OF pdmp_queries
        FOR VALUES FROM (%L) TO (%L);
    ', to_char(start_month, 'YYYYMM'), start_month, next_month);
END;
$$ LANGUAGE plpgsql;

-- Run monthly via cron/pgAgent
-- SELECT create_audit_partitions();

-- Retention: delete audit data older than 6 years (HIPAA minimum)
CREATE OR REPLACE FUNCTION enforce_audit_retention() RETURNS void AS $$
BEGIN
    DELETE FROM access_logs WHERE accessed_at < now() - INTERVAL '6 years';
    DELETE FROM pdmp_queries WHERE created_at < now() - INTERVAL '6 years';
END;
$$ LANGUAGE plpgsql;



-- Combined inventory view with items, batches, and reorder rules



-- Schedule refresh weekly
-- REFRESH MATERIALIZED VIEW CONCURRENTLY mv_user_access_summary_monthly;

-- ============================================================
-- ✅ END OF SCRIPT
-- ============================================================

-- ============================================================
-- 2️⃣ E-FAX RECIPIENTS TABLE
-- ============================================================
CREATE TABLE IF NOT EXISTS efax_recipients (
    id UUID PRIMARY KEY,
    name TEXT NOT NULL,
    organization TEXT,
    fax_number TEXT UNIQUE NOT NULL,
    email TEXT,
    contact_type TEXT CHECK (contact_type IN ('prescriber', 'payer', 'facility', 'lab', 'other')),
    is_verified BOOLEAN DEFAULT false,
    last_verified_at TIMESTAMPTZ,
    created_at TIMESTAMPTZ DEFAULT now()
);

-- ============================================================
-- 1️⃣ E-FAX CORE TABLE
-- ============================================================
CREATE TABLE IF NOT EXISTS efax_jobs (
    id UUID PRIMARY KEY,
    patient_id UUID REFERENCES patients(id),
    prescription_id UUID REFERENCES prescriptions(id),
    user_id UUID REFERENCES users(id),
    recipient_id UUID REFERENCES efax_recipients(id),
    direction TEXT NOT NULL CHECK (direction IN ('outbound', 'inbound')),
    subject TEXT,
    fax_number TEXT NOT NULL,
    provider_name TEXT,
    status TEXT DEFAULT 'queued' CHECK (status IN ('queued', 'sending', 'sent', 'failed', 'received')),
    total_pages INT DEFAULT 0,
    priority TEXT DEFAULT 'normal' CHECK (priority IN ('low', 'normal', 'high')),
    created_at TIMESTAMPTZ DEFAULT now(),
    sent_at TIMESTAMPTZ,
    completed_at TIMESTAMPTZ,
    error_message TEXT,
    retry_count INT DEFAULT 0,
    metadata JSONB -- provider tracking IDs, message IDs, correlation IDs
);

CREATE INDEX IF NOT EXISTS idx_efax_jobs_patient ON efax_jobs (patient_id);
CREATE INDEX IF NOT EXISTS idx_efax_jobs_prescription ON efax_jobs (prescription_id);
CREATE INDEX IF NOT EXISTS idx_efax_jobs_status ON efax_jobs (status);
CREATE INDEX IF NOT EXISTS idx_efax_jobs_created_at ON efax_jobs (created_at);

CREATE INDEX IF NOT EXISTS idx_efax_recipients_fax_number ON efax_recipients (fax_number);

-- ============================================================
-- 3️⃣ E-FAX ATTACHMENTS
-- ============================================================
CREATE TABLE IF NOT EXISTS efax_attachments (
    id UUID PRIMARY KEY,
    efax_job_id UUID NOT NULL REFERENCES efax_jobs(id) ON DELETE CASCADE,
    file_name TEXT NOT NULL,
    file_type TEXT NOT NULL CHECK (file_type IN ('pdf', 'tiff', 'jpg', 'png')),
    file_size_bytes BIGINT,
    encrypted_path TEXT NOT NULL, -- Encrypted storage location (AES-256)
    checksum TEXT, -- integrity validation
    page_number INT,
    created_at TIMESTAMPTZ DEFAULT now()
);

CREATE INDEX IF NOT EXISTS idx_efax_attachments_job ON efax_attachments (efax_job_id);

-- ============================================================
-- 4️⃣ E-FAX STATUS LOGS (AUDIT TRAIL)
-- ============================================================
CREATE TABLE IF NOT EXISTS efax_status_logs (
    id BIGSERIAL PRIMARY KEY,
    efax_job_id UUID NOT NULL REFERENCES efax_jobs(id) ON DELETE CASCADE,
    status TEXT NOT NULL CHECK (status IN ('queued', 'sending', 'sent', 'failed', 'received', 'rejected')),
    message TEXT,
    provider_code TEXT,
    created_at TIMESTAMPTZ DEFAULT now()
);

CREATE INDEX IF NOT EXISTS idx_efax_status_logs_job ON efax_status_logs (efax_job_id);
CREATE INDEX IF NOT EXISTS idx_efax_status_logs_status ON efax_status_logs (status);

-- ============================================================
-- 5️⃣ E-FAX INCOMING (RECEIVED FAXES)
-- ============================================================
CREATE TABLE IF NOT EXISTS efax_incoming (
    id UUID PRIMARY KEY,
    from_fax_number TEXT NOT NULL,
    from_name TEXT,
    received_at TIMESTAMPTZ DEFAULT now(),
    total_pages INT,
    file_path TEXT NOT NULL, -- encrypted PDF or TIFF
    checksum TEXT,
    linked_patient_id UUID REFERENCES patients(id),
    linked_prescription_id UUID REFERENCES prescriptions(id),
    processed_by UUID REFERENCES users(id),
    metadata JSONB -- provider-specific data
);

CREATE INDEX IF NOT EXISTS idx_efax_incoming_received_at ON efax_incoming (received_at);

-- ============================================================
-- 6️⃣ ACCESS LOG INTEGRATION (E-FAX ACTIONS)
-- ============================================================
-- Log fax transmissions for HIPAA compliance
-- Example trigger
CREATE OR REPLACE FUNCTION log_efax_access() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO access_logs (
        user_id,
        patient_id,
        entity_type,
        entity_id,
        action,
        access_reason,
        access_context
    ) VALUES (
        NEW.user_id,
        NEW.patient_id,
        'efax_job',
        NEW.id,
        CASE WHEN NEW.direction = 'outbound' THEN 'FAX_SEND' ELSE 'FAX_RECEIVE' END,
        'prescription_transmission',
        jsonb_build_object('fax_number', NEW.fax_number, 'status', NEW.status)
    );
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_efax_audit
AFTER INSERT ON efax_jobs
FOR EACH ROW
EXECUTE FUNCTION log_efax_access();

-- ============================================================
-- 5️⃣ INTEGRATION WITH E-FAX
-- ============================================================
-- Example: Linking prior authorizations and EOBs to fax transmissions
ALTER TABLE efax_jobs
ADD COLUMN IF NOT EXISTS claim_id UUID REFERENCES prescription_claims(id);

-- ============================================================================
-- 1. STATIONS TABLE - Stores station configuration
-- ============================================================================
CREATE TABLE IF NOT EXISTS stations (
    id SERIAL PRIMARY KEY,
    station_prefix VARCHAR(10) NOT NULL,
    department VARCHAR(50) NOT NULL,
    location VARCHAR(100),
    starting_number INTEGER DEFAULT 1,
    current_number INTEGER DEFAULT 1,
    max_stations INTEGER,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unique_station_config UNIQUE(station_prefix, department, location)
);

-- ============================================================================
-- 2. DEVICE_FINGERPRINTS TABLE - Core table for device fingerprint mapping
-- ============================================================================
CREATE TABLE IF NOT EXISTS device_fingerprints (
    id UUID PRIMARY KEY,

    -- Station assignment
    station_id SERIAL UNIQUE NOT NULL,

    -- Device fingerprint
    fingerprint_hash VARCHAR(64) UNIQUE NOT NULL,

    -- Device characteristics
    browser_user_agent TEXT,
    screen_resolution VARCHAR(50),
    timezone VARCHAR(50),
    language VARCHAR(20),

    -- Canvas and WebGL fingerprints
    canvas_fingerprint TEXT,
    webgl_fingerprint VARCHAR(255),

    -- Device metadata
    department VARCHAR(50) NOT NULL,
    location VARCHAR(100),

    -- Tracking information
    assigned_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_seen TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE,

    -- Statistics
    access_count INTEGER DEFAULT 1,

    -- Foreign key
    FOREIGN KEY (station_id) REFERENCES stations(id) ON DELETE CASCADE
);

-- ============================================================================
-- 3. FINGERPRINT_HISTORY TABLE - Track fingerprint changes
-- ============================================================================
CREATE TABLE IF NOT EXISTS fingerprint_history (
    id UUID PRIMARY KEY,

    station_id SERIAL NOT NULL,

    -- Fingerprint comparison
    old_fingerprint_hash VARCHAR(64),
    new_fingerprint_hash VARCHAR(64) NOT NULL,

    -- Change details
    change_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    reason VARCHAR(255),
    similarity_percentage NUMERIC(5, 2),

    -- Browser info
    browser_user_agent TEXT,
    screen_resolution VARCHAR(50),
    timezone VARCHAR(50),

    -- Admin notes
    notes TEXT,
    verified_by VARCHAR(100),

    FOREIGN KEY (station_id) REFERENCES device_fingerprints(station_id) ON DELETE CASCADE
);