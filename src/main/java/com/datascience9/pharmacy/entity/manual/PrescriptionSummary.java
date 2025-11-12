package com.datascience9.pharmacy.entity.manual;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import org.hibernate.annotations.Immutable;

/**
 * JPA entity representing the v_prescription_summary database view. This view provides a summary of
 * prescriptions with related prescription items, workflow information, drug details, and
 * patient/insurance information.
 */
@Entity
@Table(name = "v_prescription_summary")
@Immutable // Optional: Hibernate annotation to mark view as read-only
public class PrescriptionSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prescription_id")
    private java.util.UUID prescriptionId;

    @Column(name = "issue_date")
    private ZonedDateTime issueDate;

    @Column(name = "status")
    private String status;

    @Column(name = "priority")
    private String priority;

    @Column(name = "workflow_step_id")
    private Integer workflowStepId;

    @Column(name = "workflow_descr")
    private String workflowDescr;

    @Column(name = "description")
    private String description;

    @Column(name = "prescriber_name")
    private String prescriberName;

    @Column(name = "assigned_to")
    private java.util.UUID assignedTo;

    @Column(name = "drug_name")
    private String drugName;

    @Column(name = "drug_strength")
    private String drugStrength;

    @Column(name = "drug_form")
    private String drugForm;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patient_mrn")
    private String patientMrn;

    @Column(name = "patient_dob")
    private LocalDate patientDob;

    @Column(name = "patient_gender")
    private String patientGender;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "copay_fixed")
    private BigDecimal copayFixed;

    @Column(name = "insurance_company_name")
    private String insuranceCompanyName;

    // Constructors
    public PrescriptionSummary() {}

    public PrescriptionSummary(
            java.util.UUID prescriptionId,
            ZonedDateTime issueDate,
            String status,
            String priority,
            Integer workflowStepId,
            String workflowDescr,
            String description,
            String prescriberName,
            java.util.UUID assignedTo,
            String drugName,
            String drugStrength,
            String drugForm,
            String firstName,
            String lastName,
            String patientMrn,
            LocalDate patientDob,
            String patientGender,
            ZonedDateTime createdAt,
            BigDecimal copayFixed,
            String insuranceCompanyName) {
        this.prescriptionId = prescriptionId;
        this.issueDate = issueDate;
        this.status = status;
        this.priority = priority;
        this.workflowStepId = workflowStepId;
        this.workflowDescr = workflowDescr;
        this.description = description;
        this.prescriberName = prescriberName;
        this.assignedTo = assignedTo;
        this.drugName = drugName;
        this.drugStrength = drugStrength;
        this.drugForm = drugForm;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patientMrn = patientMrn;
        this.patientDob = patientDob;
        this.patientGender = patientGender;
        this.createdAt = createdAt;
        this.copayFixed = copayFixed;
        this.insuranceCompanyName = insuranceCompanyName;
    }

    // Getters and Setters
    public java.util.UUID getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public ZonedDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(ZonedDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getWorkflowStepId() {
        return workflowStepId;
    }

    public void setWorkflowStepId(Integer workflowStepId) {
        this.workflowStepId = workflowStepId;
    }

    public String getWorkflowDescr() {
        return workflowDescr;
    }

    public void setWorkflowDescr(String workflowDescr) {
        this.workflowDescr = workflowDescr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrescriberName() {
        return prescriberName;
    }

    public void setPrescriberName(String prescriberName) {
        this.prescriberName = prescriberName;
    }

    public java.util.UUID getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(java.util.UUID assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugStrength() {
        return drugStrength;
    }

    public void setDrugStrength(String drugStrength) {
        this.drugStrength = drugStrength;
    }

    public String getDrugForm() {
        return drugForm;
    }

    public void setDrugForm(String drugForm) {
        this.drugForm = drugForm;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatientMrn() {
        return patientMrn;
    }

    public void setPatientMrn(String patientMrn) {
        this.patientMrn = patientMrn;
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

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getCopayFixed() {
        return copayFixed;
    }

    public void setCopayFixed(BigDecimal copayFixed) {
        this.copayFixed = copayFixed;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    // Helper methods
    public String getFullPatientName() {
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName;
        }
        return firstName != null ? firstName : lastName;
    }

    public String getDrugDescription() {
        StringBuilder sb = new StringBuilder();
        if (drugName != null) {
            sb.append(drugName);
        }
        if (drugStrength != null) {
            sb.append(" ").append(drugStrength);
        }
        if (drugForm != null) {
            sb.append(" ").append(drugForm);
        }
        return sb.toString().trim();
    }

    @Override
    public String toString() {
        return "PrescriptionSummary{"
                + "prescriptionId="
                + prescriptionId
                + ", issueDate="
                + issueDate
                + ", status='"
                + status
                + '\''
                + ", priority='"
                + priority
                + '\''
                + ", workflowStepId="
                + workflowStepId
                + ", workflowDescr='"
                + workflowDescr
                + '\''
                + ", prescriberName='"
                + prescriberName
                + '\''
                + ", drugName='"
                + drugName
                + '\''
                + ", drugStrength='"
                + drugStrength
                + '\''
                + ", drugForm='"
                + drugForm
                + '\''
                + ", firstName='"
                + firstName
                + '\''
                + ", lastName='"
                + lastName
                + '\''
                + ", patientMrn='"
                + patientMrn
                + '\''
                + ", insuranceCompanyName='"
                + insuranceCompanyName
                + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrescriptionSummary that = (PrescriptionSummary) o;

        return prescriptionId != null
                ? prescriptionId.equals(that.prescriptionId)
                : that.prescriptionId == null;
    }

    @Override
    public int hashCode() {
        return prescriptionId != null ? prescriptionId.hashCode() : 0;
    }
}
