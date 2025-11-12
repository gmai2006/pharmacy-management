package com.datascience9.pharmacy.entity.manual;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import org.hibernate.annotations.Immutable;

@Entity
// Map to the Postgres view
@Table(name = "v_prescription_summary")
@Immutable // Optional: Hibernate annotation to mark view as read-only
public class PrescriptionSummary {

    @Id
    @Column(name = "prescription_id", nullable = false)
    private java.util.UUID prescriptionId;

    @Column(name = "issue_date")
    private OffsetDateTime issueDate;

    @Column(name = "status")
    private String status;

    @Column(name = "priority")
    private String priority;

    @Column(name = "description")
    private String description;

    @Column(name = "prescriber_name")
    private String prescriberName;

    @Column(name = "drug_name")
    private String drugName;

    @Column(name = "drug_strength")
    private String drugStrength;

    @Column(name = "drug_form")
    private String drugForm;

    @Column(name = "first_name")
    private String patientFirstName;

    @Column(name = "last_name")
    private String patientLastName;

    @Column(name = "patient_mrn")
    private String patientMrn;

    @Column(name = "patient_dob")
    private LocalDate patientDob;

    @Column(name = "patient_gender")
    private String patientGender;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "copay_fixed")
    private java.math.BigDecimal copayFixed;

    @Column(name = "insurance_company_name")
    private String insuranceCompanyName;

    // ---------------------------
    // Getters and Setters
    // ---------------------------

    public java.util.UUID getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public OffsetDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(OffsetDateTime issueDate) {
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

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public java.math.BigDecimal getCopayFixed() {
        return copayFixed;
    }

    public void setCopayFixed(java.math.BigDecimal copayFixed) {
        this.copayFixed = copayFixed;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }
}
