package com.datascience9.pharmacy.entity.manual;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "v_alert_log_details")
@Immutable // Hibernate annotation — optional
public class AlertLogDetailsView implements Serializable {
    private static final long serialVersionUID = 4443L;

    // -----------------------
    // Primary ID (view PK)
    // -----------------------
    @Id
    @Column(name = "alert_log_id")
    private Long alertLogId;

    @Column(name = "alert_created_at")
    private OffsetDateTime alertCreatedAt;

    // -----------------------
    // Alert Rule Info
    // -----------------------
    @Column(name = "alert_rule_id")
    private Integer alertRuleId;

    @Column(name = "rule_name")
    private String ruleName;

    @Column(name = "rule_description")
    private String ruleDescription;

    @Column(name = "rule_json")
    private String ruleJson; // could map to JsonNode

    @Column(name = "rule_severity")
    private String ruleSeverity;

    @Column(name = "rule_active")
    private Boolean ruleActive;

    // -----------------------
    // Patient Info
    // -----------------------
    @Column(name = "patient_id")
    private UUID patientId;

    @Column(name = "patient_mrn")
    private String patientMrn;

    @Column(name = "patient_first_name")
    private String patientFirstName;

    @Column(name = "patient_last_name")
    private String patientLastName;

    @Column(name = "patient_dob")
    private LocalDate patientDob;

    @Column(name = "patient_gender")
    private String patientGender;

    // -----------------------
    // Prescription Info
    // -----------------------
    @Column(name = "prescription_id")
    private UUID prescriptionId;

    @Column(name = "prescriber_name")
    private String prescriberName;

    @Column(name = "prescription_issue_date")
    private OffsetDateTime prescriptionIssueDate;

    @Column(name = "prescription_status")
    private String prescriptionStatus;

    @Column(name = "prescription_priority")
    private String prescriptionPriority;

    @Column(name = "prescription_metadata")
    private String prescriptionMetadata; // JSONB

    @Column(name = "queue_name")
    private String queueName;

    @Column(name = "assigned_to")
    private UUID assignedTo;

    // -----------------------
    // Alert Log Fields
    // -----------------------
    @Column(name = "triggered_by_user_id")
    private UUID triggeredByUserId;

    @Column(name = "context")
    private String context; // JSONB

    @Column(name = "action_taken")
    private String actionTaken;

    @Column(name = "override_reason")
    private String overrideReason;

    // NEW FIELDS
    @Column(name = "suggested_alternatives")
    private String suggestedAlternatives; // JSONB

    @Column(name = "pharmacist_action")
    private String pharmacistAction;

    @Column(name = "resolved_at")
    private OffsetDateTime resolvedAt;

    // -----------------------
    // Getters and Setters
    // -----------------------

    public Long getAlertLogId() {
        return alertLogId;
    }

    public void setAlertLogId(Long alertLogId) {
        this.alertLogId = alertLogId;
    }

    public OffsetDateTime getAlertCreatedAt() {
        return alertCreatedAt;
    }

    public void setAlertCreatedAt(OffsetDateTime alertCreatedAt) {
        this.alertCreatedAt = alertCreatedAt;
    }

    public Integer getAlertRuleId() {
        return alertRuleId;
    }

    public void setAlertRuleId(Integer alertRuleId) {
        this.alertRuleId = alertRuleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleDescription() {
        return ruleDescription;
    }

    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }

    public String getRuleJson() {
        return ruleJson;
    }

    public void setRuleJson(String ruleJson) {
        this.ruleJson = ruleJson;
    }

    public String getRuleSeverity() {
        return ruleSeverity;
    }

    public void setRuleSeverity(String ruleSeverity) {
        this.ruleSeverity = ruleSeverity;
    }

    public Boolean getRuleActive() {
        return ruleActive;
    }

    public void setRuleActive(Boolean ruleActive) {
        this.ruleActive = ruleActive;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getPatientMrn() {
        return patientMrn;
    }

    public void setPatientMrn(String patientMrn) {
        this.patientMrn = patientMrn;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public LocalDate getPatientDob() {
        return patientDob;
    }

    public void setPatientDob(LocalDate patientDob) {
        this.patientDob = patientDob;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public UUID getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPrescriberName() {
        return prescriberName;
    }

    public void setPrescriberName(String prescriberName) {
        this.prescriberName = prescriberName;
    }

    public OffsetDateTime getPrescriptionIssueDate() {
        return prescriptionIssueDate;
    }

    public void setPrescriptionIssueDate(OffsetDateTime prescriptionIssueDate) {
        this.prescriptionIssueDate = prescriptionIssueDate;
    }

    public String getPrescriptionStatus() {
        return prescriptionStatus;
    }

    public void setPrescriptionStatus(String prescriptionStatus) {
        this.prescriptionStatus = prescriptionStatus;
    }

    public String getPrescriptionPriority() {
        return prescriptionPriority;
    }

    public void setPrescriptionPriority(String prescriptionPriority) {
        this.prescriptionPriority = prescriptionPriority;
    }

    public String getPrescriptionMetadata() {
        return prescriptionMetadata;
    }

    public void setPrescriptionMetadata(String prescriptionMetadata) {
        this.prescriptionMetadata = prescriptionMetadata;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public UUID getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UUID assignedTo) {
        this.assignedTo = assignedTo;
    }

    public UUID getTriggeredByUserId() {
        return triggeredByUserId;
    }

    public void setTriggeredByUserId(UUID triggeredByUserId) {
        this.triggeredByUserId = triggeredByUserId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public String getOverrideReason() {
        return overrideReason;
    }

    public void setOverrideReason(String overrideReason) {
        this.overrideReason = overrideReason;
    }

    public String getSuggestedAlternatives() {
        return suggestedAlternatives;
    }

    public void setSuggestedAlternatives(String suggestedAlternatives) {
        this.suggestedAlternatives = suggestedAlternatives;
    }

    public String getPharmacistAction() {
        return pharmacistAction;
    }

    public void setPharmacistAction(String pharmacistAction) {
        this.pharmacistAction = pharmacistAction;
    }

    public OffsetDateTime getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(OffsetDateTime resolvedAt) {
        this.resolvedAt = resolvedAt;
    }
}
