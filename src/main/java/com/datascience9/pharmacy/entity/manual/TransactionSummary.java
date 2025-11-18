package com.datascience9.pharmacy.entity.manual;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "v_transaction_summary")
@Immutable // Hibernate annotation; remove if not using Hibernate
public class TransactionSummary implements Serializable {
    private static final long serialVersionUID = 436L;

    @Id
    @Column(name = "transaction_id", nullable = false)
    private java.util.UUID transactionId;

    @Column(name = "prescription_id")
    private java.util.UUID prescriptionId;

    @Column(name = "patient_id")
    private java.util.UUID patientId;

    @Column(name = "patient_first_name")
    private String patientFirstName;

    @Column(name = "patient_last_name")
    private String patientLastName;

    @Column(name = "patient_full_name")
    private String patientFullName;

    @Column(name = "patient_mrn")
    private String patientMrn;

    @Column(name = "prescriber_name")
    private String prescriberName;

    @Column(name = "drug_name")
    private String drugName;

    @Column(name = "station_id")
    private String stationId;

    @Column(name = "status")
    private String status;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "total_payments")
    private Integer totalPayments;

    @Column(name = "total_paid")
    private BigDecimal totalPaid;

    @Column(name = "balance_due")
    private BigDecimal balanceDue;

    @Column(name = "payment_percentage")
    private BigDecimal paymentPercentage;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "payment_methods_used")
    private String paymentMethodsUsed;

    // =============================
    // Getters and Setters
    // =============================

    public java.util.UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(java.util.UUID transactionId) {
        this.transactionId = transactionId;
    }

    public java.util.UUID getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public java.util.UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(java.util.UUID patientId) {
        this.patientId = patientId;
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

    public String getPatientFullName() {
        return patientFullName;
    }

    public void setPatientFullName(String patientFullName) {
        this.patientFullName = patientFullName;
    }

    public String getPatientMrn() {
        return patientMrn;
    }

    public void setPatientMrn(String patientMrn) {
        this.patientMrn = patientMrn;
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

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(Integer totalPayments) {
        this.totalPayments = totalPayments;
    }

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }

    public BigDecimal getBalanceDue() {
        return balanceDue;
    }

    public void setBalanceDue(BigDecimal balanceDue) {
        this.balanceDue = balanceDue;
    }

    public BigDecimal getPaymentPercentage() {
        return paymentPercentage;
    }

    public void setPaymentPercentage(BigDecimal paymentPercentage) {
        this.paymentPercentage = paymentPercentage;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethodsUsed() {
        return paymentMethodsUsed;
    }

    public void setPaymentMethodsUsed(String paymentMethodsUsed) {
        this.paymentMethodsUsed = paymentMethodsUsed;
    }
}
