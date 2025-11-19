package com.datascience9.pharmacy.entity.manual;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "v_dir_fee_summary")
public class DirFeeSummary implements Serializable {
    private static final long serialVersionUID = 355L;

    @Id
    @Column(name = "dir_fee_id")
    private Long dirFeeId;

    // ---- DIR Fee fields ----

    @Column(name = "claim_id")
    private UUID claimId;

    @Column(name = "dir_fee_amount")
    private BigDecimal dirFeeAmount;

    @Column(name = "dir_fee_reason")
    private String dirFeeReason;

    @Column(name = "dir_fee_recorded_at")
    private OffsetDateTime dirFeeRecordedAt;

    @Column(name = "reconciliation_period")
    private String reconciliationPeriod;

    @Column(name = "dir_fee_payer_name")
    private String dirFeePayerName;

    @Column(name = "dir_fee_metadata")
    private String dirFeeMetadata; // Stored as JSON → map as String or JsonNode

    // ---- Claim fields ----

    @Column(name = "claim_payer_name")
    private String claimPayerName;

    @Column(name = "claim_status")
    private String claimStatus;

    @Column(name = "claim_submitted_at")
    private OffsetDateTime claimSubmittedAt;

    @Column(name = "claim_fiscal_fields")
    private String claimFiscalFields; // JSON

    @Column(name = "prescription_id")
    private UUID prescriptionId;

    // ---- Derived numeric values ----

    @Column(name = "claim_reimbursement_amount")
    private BigDecimal claimReimbursementAmount;

    @Column(name = "claim_plan_paid")
    private BigDecimal claimPlanPaid;

    @Column(name = "claim_patient_paid")
    private BigDecimal claimPatientPaid;

    @Column(name = "net_reimbursement_after_dir_fee")
    private BigDecimal netReimbursementAfterDirFee;

    // ---- Getters / Setters ----

    public Long getDirFeeId() {
        return dirFeeId;
    }

    public void setDirFeeId(Long dirFeeId) {
        this.dirFeeId = dirFeeId;
    }

    public UUID getClaimId() {
        return claimId;
    }

    public void setClaimId(UUID claimId) {
        this.claimId = claimId;
    }

    public BigDecimal getDirFeeAmount() {
        return dirFeeAmount;
    }

    public void setDirFeeAmount(BigDecimal dirFeeAmount) {
        this.dirFeeAmount = dirFeeAmount;
    }

    public String getDirFeeReason() {
        return dirFeeReason;
    }

    public void setDirFeeReason(String dirFeeReason) {
        this.dirFeeReason = dirFeeReason;
    }

    public OffsetDateTime getDirFeeRecordedAt() {
        return dirFeeRecordedAt;
    }

    public void setDirFeeRecordedAt(OffsetDateTime dirFeeRecordedAt) {
        this.dirFeeRecordedAt = dirFeeRecordedAt;
    }

    public String getReconciliationPeriod() {
        return reconciliationPeriod;
    }

    public void setReconciliationPeriod(String reconciliationPeriod) {
        this.reconciliationPeriod = reconciliationPeriod;
    }

    public String getDirFeePayerName() {
        return dirFeePayerName;
    }

    public void setDirFeePayerName(String dirFeePayerName) {
        this.dirFeePayerName = dirFeePayerName;
    }

    public String getDirFeeMetadata() {
        return dirFeeMetadata;
    }

    public void setDirFeeMetadata(String dirFeeMetadata) {
        this.dirFeeMetadata = dirFeeMetadata;
    }

    public String getClaimPayerName() {
        return claimPayerName;
    }

    public void setClaimPayerName(String claimPayerName) {
        this.claimPayerName = claimPayerName;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public OffsetDateTime getClaimSubmittedAt() {
        return claimSubmittedAt;
    }

    public void setClaimSubmittedAt(OffsetDateTime claimSubmittedAt) {
        this.claimSubmittedAt = claimSubmittedAt;
    }

    public String getClaimFiscalFields() {
        return claimFiscalFields;
    }

    public void setClaimFiscalFields(String claimFiscalFields) {
        this.claimFiscalFields = claimFiscalFields;
    }

    public UUID getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public BigDecimal getClaimReimbursementAmount() {
        return claimReimbursementAmount;
    }

    public void setClaimReimbursementAmount(BigDecimal claimReimbursementAmount) {
        this.claimReimbursementAmount = claimReimbursementAmount;
    }

    public BigDecimal getClaimPlanPaid() {
        return claimPlanPaid;
    }

    public void setClaimPlanPaid(BigDecimal claimPlanPaid) {
        this.claimPlanPaid = claimPlanPaid;
    }

    public BigDecimal getClaimPatientPaid() {
        return claimPatientPaid;
    }

    public void setClaimPatientPaid(BigDecimal claimPatientPaid) {
        this.claimPatientPaid = claimPatientPaid;
    }

    public BigDecimal getNetReimbursementAfterDirFee() {
        return netReimbursementAfterDirFee;
    }

    public void setNetReimbursementAfterDirFee(BigDecimal netReimbursementAfterDirFee) {
        this.netReimbursementAfterDirFee = netReimbursementAfterDirFee;
    }
}
