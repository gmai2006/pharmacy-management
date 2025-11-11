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
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.io.Serializable;
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "pdmp_queries")
public class PdmpQueries implements Serializable {
    private static final long serialVersionUID = 176284555409650753L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: patient_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(columnDefinition = "UUID", name = "patient_id")
    private java.util.UUID patientId;

    /** Description: user_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(columnDefinition = "UUID", name = "user_id")
    private java.util.UUID userId;

    /** Description: prescription_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "prescription_id")
    private java.util.UUID prescriptionId;

    /** Description: state. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "state")
    private java.lang.String state;

    /** Description: query_reason. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "query_reason")
    private java.lang.String queryReason;

    /** Description: status. */
    @Basic
    @Column(name = "status")
    private java.lang.String status;

    /** Description: response_code. */
    @Basic
    @Column(name = "response_code")
    private java.lang.String responseCode;

    /** Description: response_payload. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "response_payload")
    private Map<String, Object> responsePayload;

    /** Description: transmitted_at. */
    @Basic
    @Column(name = "transmitted_at")
    private java.sql.Timestamp transmittedAt;

    /** Description: completed_at. */
    @Basic
    @Column(name = "completed_at")
    private java.sql.Timestamp completedAt;

    /** Description: error_message. */
    @Basic
    @Column(name = "error_message")
    private java.lang.String errorMessage;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    public PdmpQueries() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getPatientId() {
        return this.patientId;
    }

    public java.util.UUID getUserId() {
        return this.userId;
    }

    public java.util.UUID getPrescriptionId() {
        return this.prescriptionId;
    }

    public java.lang.String getState() {
        return this.state;
    }

    public java.lang.String getQueryReason() {
        return this.queryReason;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public java.lang.String getResponseCode() {
        return this.responseCode;
    }

    public java.util.Map<String, Object> getResponsePayload() {
        return this.responsePayload;
    }

    public java.sql.Timestamp getTransmittedAt() {
        return this.transmittedAt;
    }

    public java.sql.Timestamp getCompletedAt() {
        return this.completedAt;
    }

    public java.lang.String getErrorMessage() {
        return this.errorMessage;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setPatientId(java.util.UUID patientId) {
        this.patientId = patientId;
    }

    public void setUserId(java.util.UUID userId) {
        this.userId = userId;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setState(java.lang.String state) {
        this.state = state;
    }

    public void setQueryReason(java.lang.String queryReason) {
        this.queryReason = queryReason;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public void setResponseCode(java.lang.String responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponsePayload(java.util.Map<String, Object> responsePayload) {
        this.responsePayload = responsePayload;
    }

    public void setTransmittedAt(java.sql.Timestamp transmittedAt) {
        this.transmittedAt = transmittedAt;
    }

    public void setCompletedAt(java.sql.Timestamp completedAt) {
        this.completedAt = completedAt;
    }

    public void setErrorMessage(java.lang.String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
