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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "patient_insurances")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientInsurances implements Serializable {
    private static final long serialVersionUID = 176351898742798172L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: patient_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(columnDefinition = "UUID", name = "patient_id")
    private java.util.UUID patientId;

    /** Description: insurance_company_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(columnDefinition = "UUID", name = "insurance_company_id")
    private java.util.UUID insuranceCompanyId;

    /** Description: member_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "member_id")
    private String memberId;

    /** Description: group_number. */
    @Basic
    @Column(name = "group_number")
    private String groupNumber;

    /** Description: plan_name. */
    @Basic
    @Column(name = "plan_name")
    private String planName;

    /** Description: effective_date. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "effective_date")
    private java.time.LocalDateTime effectiveDate;

    /** Description: expiration_date. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "expiration_date")
    private java.time.LocalDateTime expirationDate;

    /** Description: coverage_type. */
    @Basic
    @Column(name = "coverage_type")
    private String coverageType;

    /** Description: copay_fixed. */
    @Basic
    @Column(name = "copay_fixed")
    private java.math.BigDecimal copayFixed;

    /** Description: copay_percent. */
    @Basic
    @Column(name = "copay_percent")
    private java.math.BigDecimal copayPercent;

    /** Description: deductible. */
    @Basic
    @Column(name = "deductible")
    private java.math.BigDecimal deductible;

    /** Description: out_of_pocket_max. */
    @Basic
    @Column(name = "out_of_pocket_max")
    private java.math.BigDecimal outOfPocketMax;

    /** Description: status. */
    @Basic
    @Column(name = "status")
    private String status;

    /** Description: created_at. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    /** Description: updated_at. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;

    @Transient List<PrescriptionClaims> prescriptionclaims;

    public PatientInsurances() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getPatientId() {
        return this.patientId;
    }

    public java.util.UUID getInsuranceCompanyId() {
        return this.insuranceCompanyId;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public String getGroupNumber() {
        return this.groupNumber;
    }

    public String getPlanName() {
        return this.planName;
    }

    public java.time.LocalDateTime getEffectiveDate() {
        return this.effectiveDate;
    }

    public java.time.LocalDateTime getExpirationDate() {
        return this.expirationDate;
    }

    public String getCoverageType() {
        return this.coverageType;
    }

    public java.math.BigDecimal getCopayFixed() {
        return this.copayFixed;
    }

    public java.math.BigDecimal getCopayPercent() {
        return this.copayPercent;
    }

    public java.math.BigDecimal getDeductible() {
        return this.deductible;
    }

    public java.math.BigDecimal getOutOfPocketMax() {
        return this.outOfPocketMax;
    }

    public String getStatus() {
        return this.status;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public java.time.LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setPatientId(java.util.UUID patientId) {
        this.patientId = patientId;
    }

    public void setInsuranceCompanyId(java.util.UUID insuranceCompanyId) {
        this.insuranceCompanyId = insuranceCompanyId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public void setEffectiveDate(java.time.LocalDateTime effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public void setExpirationDate(java.time.LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    public void setCopayFixed(java.math.BigDecimal copayFixed) {
        this.copayFixed = copayFixed;
    }

    public void setCopayPercent(java.math.BigDecimal copayPercent) {
        this.copayPercent = copayPercent;
    }

    public void setDeductible(java.math.BigDecimal deductible) {
        this.deductible = deductible;
    }

    public void setOutOfPocketMax(java.math.BigDecimal outOfPocketMax) {
        this.outOfPocketMax = outOfPocketMax;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(java.time.LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<PrescriptionClaims> getPrescriptionClaims() {
        return this.prescriptionclaims;
    }

    public void setPrescriptionClaims(List<PrescriptionClaims> prescriptionclaims) {
        this.prescriptionclaims = new ArrayList<>(prescriptionclaims);
    }
}
