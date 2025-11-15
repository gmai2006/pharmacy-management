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

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "prescription_claims")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrescriptionClaims implements Serializable {
    private static final long serialVersionUID = 17631113269234715L;

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

    /** Description: patient_insurance_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "patient_insurance_id")
    private java.util.UUID patientInsuranceId;

    /** Description: claim_number. */
    @Basic
    @Column(name = "claim_number")
    private String claimNumber;

    /** Description: claim_status. */
    @Basic
    @Column(name = "claim_status")
    private String claimStatus;

    /** Description: claim_date. */
    @Basic
    @Column(name = "claim_date")
    private java.sql.Timestamp claimDate;

    /** Description: billed_amount. */
    @Basic
    @Column(name = "billed_amount")
    private java.math.BigDecimal billedAmount;

    /** Description: reimbursed_amount. */
    @Basic
    @Column(name = "reimbursed_amount")
    private java.math.BigDecimal reimbursedAmount;

    /** Description: patient_responsibility. */
    @Basic
    @Column(name = "patient_responsibility")
    private java.math.BigDecimal patientResponsibility;

    /** Description: rejection_code. */
    @Basic
    @Column(name = "rejection_code")
    private String rejectionCode;

    /** Description: rejection_reason. */
    @Basic
    @Column(name = "rejection_reason")
    private String rejectionReason;

    /** Description: prior_authorization_number. */
    @Basic
    @Column(name = "prior_authorization_number")
    private String priorAuthorizationNumber;

    /** Description: adjudication_data. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "adjudication_data")
    private Map<String, Object> adjudicationData;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    /** Description: updated_at. */
    @Basic
    @Column(name = "updated_at")
    private java.sql.Timestamp updatedAt;

    @Transient List<PrescriptionCopays> prescriptioncopays;

    public PrescriptionClaims() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getPrescriptionId() {
        return this.prescriptionId;
    }

    public java.util.UUID getPatientInsuranceId() {
        return this.patientInsuranceId;
    }

    public String getClaimNumber() {
        return this.claimNumber;
    }

    public String getClaimStatus() {
        return this.claimStatus;
    }

    public java.sql.Timestamp getClaimDate() {
        return this.claimDate;
    }

    public java.math.BigDecimal getBilledAmount() {
        return this.billedAmount;
    }

    public java.math.BigDecimal getReimbursedAmount() {
        return this.reimbursedAmount;
    }

    public java.math.BigDecimal getPatientResponsibility() {
        return this.patientResponsibility;
    }

    public String getRejectionCode() {
        return this.rejectionCode;
    }

    public String getRejectionReason() {
        return this.rejectionReason;
    }

    public String getPriorAuthorizationNumber() {
        return this.priorAuthorizationNumber;
    }

    public Map<String, Object> getAdjudicationData() {
        return this.adjudicationData;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public java.sql.Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setPatientInsuranceId(java.util.UUID patientInsuranceId) {
        this.patientInsuranceId = patientInsuranceId;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public void setClaimDate(java.sql.Timestamp claimDate) {
        this.claimDate = claimDate;
    }

    public void setBilledAmount(java.math.BigDecimal billedAmount) {
        this.billedAmount = billedAmount;
    }

    public void setReimbursedAmount(java.math.BigDecimal reimbursedAmount) {
        this.reimbursedAmount = reimbursedAmount;
    }

    public void setPatientResponsibility(java.math.BigDecimal patientResponsibility) {
        this.patientResponsibility = patientResponsibility;
    }

    public void setRejectionCode(String rejectionCode) {
        this.rejectionCode = rejectionCode;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public void setPriorAuthorizationNumber(String priorAuthorizationNumber) {
        this.priorAuthorizationNumber = priorAuthorizationNumber;
    }

    public void setAdjudicationData(Map<String, Object> adjudicationData) {
        this.adjudicationData = adjudicationData;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(java.sql.Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<PrescriptionCopays> getPrescriptionCopays() {
        return this.prescriptioncopays;
    }

    public void setPrescriptionCopays(List<PrescriptionCopays> prescriptioncopays) {
        this.prescriptioncopays = new ArrayList<>(prescriptioncopays);
    }
}
