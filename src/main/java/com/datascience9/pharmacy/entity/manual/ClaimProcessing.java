package com.datascience9.pharmacy.entity.manual;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * Read-only view entity for v_claim_processing. Provides comprehensive claim processing workflow
 * data combining claims, prescription_claims, and patient information.
 *
 * <p>This entity is immutable and designed for operational claim processing queries. Use this
 * entity to track claim status, financial metrics, and recommended actions.
 */
@Entity
@Table(name = "v_claim_processing")
@Immutable
public class ClaimProcessing {

    // ==================== Composite Key ====================
    /**
     * Using prescription_claim_id as primary key since it's the unique identifier for the
     * prescription_claims row in the view
     */
    @Id
    @Column(name = "prescription_claim_id")
    private UUID prescriptionClaimId;

    // ==================== Primary Identifiers ====================
    @Column(name = "claim_id")
    private UUID claimId;

    @Column(name = "prescription_id")
    private UUID prescriptionId;

    @Column(name = "patient_id")
    private UUID patientId;

    // ==================== Patient Information ====================
    @Column(name = "mrn")
    private String mrn;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "dob")
    private LocalDate dateOfBirth;

    @Column(name = "gender")
    private String gender;

    // ==================== Insurance and Payer Information ====================
    @Column(name = "patient_insurance_id")
    private UUID patientInsuranceId;

    @Column(name = "claim_number")
    private String claimNumber;

    @Column(name = "payer_name")
    private String payerName;

    // ==================== Claim Status ====================
    @Column(name = "claim_status")
    @Enumerated(EnumType.STRING)
    private ClaimStatus claimStatus;

    // ==================== Prior Authorization ====================
    @Column(name = "prior_authorization_number")
    private String priorAuthorizationNumber;

    // ==================== Rejection Information ====================
    @Column(name = "rejection_code")
    private String rejectionCode;

    @Column(name = "rejection_reason")
    private String rejectionReason;

    @Column(name = "has_rejection")
    private Boolean hasRejection;

    // ==================== Financial Information ====================
    @Column(name = "billed_amount")
    private BigDecimal billedAmount;

    @Column(name = "reimbursed_amount")
    private BigDecimal reimbursedAmount;

    @Column(name = "patient_responsibility")
    private BigDecimal patientResponsibility;

    @Column(name = "billed_amount_safe")
    private BigDecimal billedAmountSafe;

    @Column(name = "reimbursed_amount_safe")
    private BigDecimal reimbursedAmountSafe;

    @Column(name = "patient_responsibility_safe")
    private BigDecimal patientResponsibilitySafe;

    @Column(name = "write_off_amount")
    private BigDecimal writeOffAmount;

    @Column(name = "reimbursement_rate_percentage")
    private BigDecimal reimbursementRatePercentage;

    @Column(name = "write_off_percentage")
    private BigDecimal writeOffPercentage;

    // ==================== Response and Adjudication Data ====================
    @Column(name = "claim_payer_response")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode claimPayerResponse;

    @Column(name = "adjudication_data")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode adjudicationData;

    @Column(name = "claim_fiscal_fields")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode claimFiscalFields;

    // ==================== Timestamps ====================
    @Column(name = "claim_submitted_at")
    private Instant claimSubmittedAt;

    @Column(name = "claim_date")
    private Instant claimDate;

    @Column(name = "prescription_claim_created_at")
    private Instant prescriptionClaimCreatedAt;

    @Column(name = "prescription_claim_updated_at")
    private Instant prescriptionClaimUpdatedAt;

    // ==================== Processing Metrics ====================
    @Column(name = "days_in_processing")
    private Integer daysInProcessing;

    @Column(name = "claim_outcome")
    @Enumerated(EnumType.STRING)
    private ClaimOutcome claimOutcome;

    @Column(name = "processing_priority")
    @Enumerated(EnumType.STRING)
    private ProcessingPriority processingPriority;

    @Column(name = "recommended_action")
    @Enumerated(EnumType.STRING)
    private RecommendedAction recommendedAction;

    // ==================== Patient Contact Information ====================
    @Column(name = "patient_phone")
    private String patientPhone;

    @Column(name = "patient_email")
    private String patientEmail;

    @Column(name = "preferred_contact_method")
    private String preferredContactMethod;

    // ==================== Patient Preferences ====================
    @Column(name = "preferred_language")
    private String preferredLanguage;

    @Column(name = "accessibility_preferences")
    @JdbcTypeCode(SqlTypes.JSON)
    private JsonNode accessibilityPreferences;

    // ==================== Constructors ====================
    public ClaimProcessing() {}

    // ==================== Getters ====================
    public UUID getPrescriptionClaimId() {
        return prescriptionClaimId;
    }

    public UUID getClaimId() {
        return claimId;
    }

    public UUID getPrescriptionId() {
        return prescriptionId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public String getMrn() {
        return mrn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatientName() {
        return patientName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public UUID getPatientInsuranceId() {
        return patientInsuranceId;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public String getPayerName() {
        return payerName;
    }

    public ClaimStatus getClaimStatus() {
        return claimStatus;
    }

    public String getPriorAuthorizationNumber() {
        return priorAuthorizationNumber;
    }

    public String getRejectionCode() {
        return rejectionCode;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public Boolean getHasRejection() {
        return hasRejection;
    }

    public BigDecimal getBilledAmount() {
        return billedAmount;
    }

    public BigDecimal getReimbursedAmount() {
        return reimbursedAmount;
    }

    public BigDecimal getPatientResponsibility() {
        return patientResponsibility;
    }

    public BigDecimal getBilledAmountSafe() {
        return billedAmountSafe;
    }

    public BigDecimal getReimbursedAmountSafe() {
        return reimbursedAmountSafe;
    }

    public BigDecimal getPatientResponsibilitySafe() {
        return patientResponsibilitySafe;
    }

    public BigDecimal getWriteOffAmount() {
        return writeOffAmount;
    }

    public BigDecimal getReimbursementRatePercentage() {
        return reimbursementRatePercentage;
    }

    public BigDecimal getWriteOffPercentage() {
        return writeOffPercentage;
    }

    public JsonNode getClaimPayerResponse() {
        return claimPayerResponse;
    }

    public JsonNode getAdjudicationData() {
        return adjudicationData;
    }

    public JsonNode getClaimFiscalFields() {
        return claimFiscalFields;
    }

    public Instant getClaimSubmittedAt() {
        return claimSubmittedAt;
    }

    public Instant getClaimDate() {
        return claimDate;
    }

    public Instant getPrescriptionClaimCreatedAt() {
        return prescriptionClaimCreatedAt;
    }

    public Instant getPrescriptionClaimUpdatedAt() {
        return prescriptionClaimUpdatedAt;
    }

    public Integer getDaysInProcessing() {
        return daysInProcessing;
    }

    public ClaimOutcome getClaimOutcome() {
        return claimOutcome;
    }

    public ProcessingPriority getProcessingPriority() {
        return processingPriority;
    }

    public RecommendedAction getRecommendedAction() {
        return recommendedAction;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public String getPreferredContactMethod() {
        return preferredContactMethod;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public JsonNode getAccessibilityPreferences() {
        return accessibilityPreferences;
    }

    // ==================== Enums ====================
    /** Claim status enumeration aligned with prescription_claims CHECK constraint */
    public enum ClaimStatus {
        SUBMITTED, // Claim has been submitted to payer
        APPROVED, // Claim has been approved by payer
        REJECTED, // Claim has been rejected by payer
        PENDING, // Claim is pending response from payer
        REVERSED // Claim has been reversed/cancelled
    }

    /** Normalized claim outcome for easier reporting */
    public enum ClaimOutcome {
        APPROVED, // Successfully approved
        REJECTED, // Denied/rejected
        PENDING, // Awaiting response
        SUBMITTED, // Recently submitted
        REVERSED, // Reversed/cancelled
        UNKNOWN // Unable to determine
    }

    /** Processing priority for workflow management */
    public enum ProcessingPriority {
        HIGH, // Requires immediate attention
        MEDIUM, // Normal processing
        LOW // Resolved/no action needed
    }

    /** Recommended action for claim processors */
    public enum RecommendedAction {
        APPEAL_OR_RESUBMIT, // Claim rejected - appeal or resubmit
        FOLLOW_UP, // Pending claim exceeds SLA - follow up with payer
        OBTAIN_AUTH, // Prior authorization needed
        COLLECT_COPAY, // Collect patient copay/responsibility
        MONITOR // Monitor status - no immediate action
    }

    // ==================== toString ====================
    @Override
    public String toString() {
        return "ClaimProcessingEntity{"
                + "prescriptionClaimId="
                + prescriptionClaimId
                + ", claimNumber='"
                + claimNumber
                + '\''
                + ", patientName='"
                + patientName
                + '\''
                + ", payerName='"
                + payerName
                + '\''
                + ", claimStatus="
                + claimStatus
                + ", claimOutcome="
                + claimOutcome
                + ", processingPriority="
                + processingPriority
                + ", recommendedAction="
                + recommendedAction
                + ", billedAmount="
                + billedAmount
                + ", reimbursedAmount="
                + reimbursedAmount
                + ", daysInProcessing="
                + daysInProcessing
                + '}';
    }

    // ==================== Helper Methods ====================
    /** Checks if claim requires immediate action */
    public boolean requiresImmediateAction() {
        return processingPriority == ProcessingPriority.HIGH;
    }

    /** Checks if claim has been rejected */
    public boolean isRejected() {
        return claimStatus == ClaimStatus.REJECTED || claimOutcome == ClaimOutcome.REJECTED;
    }

    /** Checks if claim is pending and within normal SLA */
    public boolean isPendingWithinSla() {
        return claimStatus == ClaimStatus.PENDING
                && daysInProcessing != null
                && daysInProcessing <= 30;
    }

    /** Checks if claim exceeds SLA */
    public boolean exceedsSla() {
        return claimStatus == ClaimStatus.PENDING
                && daysInProcessing != null
                && daysInProcessing > 45;
    }

    /** Checks if claim is fully resolved (approved) */
    public boolean isFullyResolved() {
        return claimOutcome == ClaimOutcome.APPROVED;
    }

    /** Calculates claim reimbursement efficiency as a percentage */
    public BigDecimal getReimbursementEfficiency() {
        if (billedAmountSafe == null || billedAmountSafe.compareTo(BigDecimal.ZERO) <= 0) {
            return BigDecimal.ZERO;
        }
        return reimbursedAmountSafe
                .divide(billedAmountSafe, 4, java.math.RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100"));
    }

    /** Checks if patient has any financial responsibility */
    public boolean hasPatientResponsibility() {
        return patientResponsibilitySafe != null
                && patientResponsibilitySafe.compareTo(BigDecimal.ZERO) > 0;
    }

    /** Checks if claim needs prior authorization */
    public boolean needsPriorAuthorization() {
        return priorAuthorizationNumber == null
                && (claimStatus == ClaimStatus.PENDING || claimStatus == ClaimStatus.SUBMITTED);
    }

    /** Gets patient's primary contact information */
    public String getPrimaryContact() {
        if (preferredContactMethod != null && preferredContactMethod.equalsIgnoreCase("email")) {
            return patientEmail;
        }
        return patientPhone;
    }
}
