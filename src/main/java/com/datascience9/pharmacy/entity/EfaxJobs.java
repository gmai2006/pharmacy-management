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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "efax_jobs")
public class EfaxJobs implements Serializable {
    private static final long serialVersionUID = 176284555410150048L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: patient_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "patient_id")
    private java.util.UUID patientId;

    /** Description: prescription_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "prescription_id")
    private java.util.UUID prescriptionId;

    /** Description: user_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "user_id")
    private java.util.UUID userId;

    /** Description: recipient_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "recipient_id")
    private java.util.UUID recipientId;

    /** Description: direction. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "direction")
    private java.lang.String direction;

    /** Description: subject. */
    @Basic
    @Column(name = "subject")
    private java.lang.String subject;

    /** Description: fax_number. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "fax_number")
    private java.lang.String faxNumber;

    /** Description: provider_name. */
    @Basic
    @Column(name = "provider_name")
    private java.lang.String providerName;

    /** Description: status. */
    @Basic
    @Column(name = "status")
    private java.lang.String status;

    /** Description: total_pages. */
    @Basic
    @Column(name = "total_pages")
    private java.lang.Integer totalPages;

    /** Description: priority. */
    @Basic
    @Column(name = "priority")
    private java.lang.String priority;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    /** Description: sent_at. */
    @Basic
    @Column(name = "sent_at")
    private java.sql.Timestamp sentAt;

    /** Description: completed_at. */
    @Basic
    @Column(name = "completed_at")
    private java.sql.Timestamp completedAt;

    /** Description: error_message. */
    @Basic
    @Column(name = "error_message")
    private java.lang.String errorMessage;

    /** Description: retry_count. */
    @Basic
    @Column(name = "retry_count")
    private java.lang.Integer retryCount;

    /** Description: metadata. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "metadata")
    private Map<String, Object> metadata;

    @Transient List<EfaxStatusLogs> efaxstatuslogs;
    @Transient List<EfaxAttachments> efaxattachments;

    public EfaxJobs() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getPatientId() {
        return this.patientId;
    }

    public java.util.UUID getPrescriptionId() {
        return this.prescriptionId;
    }

    public java.util.UUID getUserId() {
        return this.userId;
    }

    public java.util.UUID getRecipientId() {
        return this.recipientId;
    }

    public java.lang.String getDirection() {
        return this.direction;
    }

    public java.lang.String getSubject() {
        return this.subject;
    }

    public java.lang.String getFaxNumber() {
        return this.faxNumber;
    }

    public java.lang.String getProviderName() {
        return this.providerName;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public java.lang.Integer getTotalPages() {
        return this.totalPages;
    }

    public java.lang.String getPriority() {
        return this.priority;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public java.sql.Timestamp getSentAt() {
        return this.sentAt;
    }

    public java.sql.Timestamp getCompletedAt() {
        return this.completedAt;
    }

    public java.lang.String getErrorMessage() {
        return this.errorMessage;
    }

    public java.lang.Integer getRetryCount() {
        return this.retryCount;
    }

    public java.util.Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public void setPatientId(java.util.UUID patientId) {
        this.patientId = patientId;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setUserId(java.util.UUID userId) {
        this.userId = userId;
    }

    public void setRecipientId(java.util.UUID recipientId) {
        this.recipientId = recipientId;
    }

    public void setDirection(java.lang.String direction) {
        this.direction = direction;
    }

    public void setSubject(java.lang.String subject) {
        this.subject = subject;
    }

    public void setFaxNumber(java.lang.String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public void setProviderName(java.lang.String providerName) {
        this.providerName = providerName;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public void setTotalPages(java.lang.Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void setPriority(java.lang.String priority) {
        this.priority = priority;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setSentAt(java.sql.Timestamp sentAt) {
        this.sentAt = sentAt;
    }

    public void setCompletedAt(java.sql.Timestamp completedAt) {
        this.completedAt = completedAt;
    }

    public void setErrorMessage(java.lang.String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setRetryCount(java.lang.Integer retryCount) {
        this.retryCount = retryCount;
    }

    public void setMetadata(java.util.Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public List<EfaxStatusLogs> getEfaxStatusLogs() {
        return this.efaxstatuslogs;
    }

    public List<EfaxAttachments> getEfaxAttachments() {
        return this.efaxattachments;
    }

    public void setEfaxStatusLogs(List<EfaxStatusLogs> efaxstatuslogs) {
        this.efaxstatuslogs = new ArrayList<>(efaxstatuslogs);
    }

    public void setEfaxAttachments(List<EfaxAttachments> efaxattachments) {
        this.efaxattachments = new ArrayList<>(efaxattachments);
    }
}
