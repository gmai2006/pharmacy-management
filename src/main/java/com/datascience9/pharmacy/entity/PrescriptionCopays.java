/**
 * %% Copyright (C) 2025 DataScience 9 LLC %% Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License. #L%
 */
package com.datascience9.pharmacy.entity;

import jakarta.persistence.*;
import java.io.Serializable;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "prescription_copays")
public class PrescriptionCopays implements Serializable {
    private static final long serialVersionUID = 176294189249270668L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: prescription_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(columnDefinition = "UUID", name = "prescription_id")
    private java.util.UUID prescriptionId;

    /** Description: patient_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(columnDefinition = "UUID", name = "patient_id")
    private java.util.UUID patientId;

    /** Description: insurance_company_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "insurance_company_id")
    private java.util.UUID insuranceCompanyId;

    /** Description: claim_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "claim_id")
    private java.util.UUID claimId;

    /** Description: copay_amount. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "copay_amount")
    private java.math.BigDecimal copayAmount;

    /** Description: copay_status. */
    @Basic
    @Column(name = "copay_status")
    private String copayStatus;

    /** Description: payment_method. */
    @Basic
    @Column(name = "payment_method")
    private String paymentMethod;

    /** Description: payment_reference. */
    @Basic
    @Column(name = "payment_reference")
    private String paymentReference;

    /** Description: paid_at. */
    @Basic
    @Column(name = "paid_at")
    private java.sql.Timestamp paidAt;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    public PrescriptionCopays() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getPrescriptionId() {
        return this.prescriptionId;
    }

    public java.util.UUID getPatientId() {
        return this.patientId;
    }

    public java.util.UUID getInsuranceCompanyId() {
        return this.insuranceCompanyId;
    }

    public java.util.UUID getClaimId() {
        return this.claimId;
    }

    public java.math.BigDecimal getCopayAmount() {
        return this.copayAmount;
    }

    public String getCopayStatus() {
        return this.copayStatus;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public String getPaymentReference() {
        return this.paymentReference;
    }

    public java.sql.Timestamp getPaidAt() {
        return this.paidAt;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setPatientId(java.util.UUID patientId) {
        this.patientId = patientId;
    }

    public void setInsuranceCompanyId(java.util.UUID insuranceCompanyId) {
        this.insuranceCompanyId = insuranceCompanyId;
    }

    public void setClaimId(java.util.UUID claimId) {
        this.claimId = claimId;
    }

    public void setCopayAmount(java.math.BigDecimal copayAmount) {
        this.copayAmount = copayAmount;
    }

    public void setCopayStatus(String copayStatus) {
        this.copayStatus = copayStatus;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public void setPaidAt(java.sql.Timestamp paidAt) {
        this.paidAt = paidAt;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
