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
@Table(name = "efax_incoming")
public class EfaxIncoming implements Serializable {
    private static final long serialVersionUID = 176284555410683081L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: from_fax_number. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "from_fax_number")
    private java.lang.String fromFaxNumber;

    /** Description: from_name. */
    @Basic
    @Column(name = "from_name")
    private java.lang.String fromName;

    /** Description: received_at. */
    @Basic
    @Column(name = "received_at")
    private java.sql.Timestamp receivedAt;

    /** Description: total_pages. */
    @Basic
    @Column(name = "total_pages")
    private java.lang.Integer totalPages;

    /** Description: file_path. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "file_path")
    private java.lang.String filePath;

    /** Description: checksum. */
    @Basic
    @Column(name = "checksum")
    private java.lang.String checksum;

    /** Description: linked_patient_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "linked_patient_id")
    private java.util.UUID linkedPatientId;

    /** Description: linked_prescription_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "linked_prescription_id")
    private java.util.UUID linkedPrescriptionId;

    /** Description: processed_by. */
    @Basic
    @Column(columnDefinition = "UUID", name = "processed_by")
    private java.util.UUID processedBy;

    /** Description: metadata. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "metadata")
    private Map<String, Object> metadata;

    public EfaxIncoming() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.lang.String getFromFaxNumber() {
        return this.fromFaxNumber;
    }

    public java.lang.String getFromName() {
        return this.fromName;
    }

    public java.sql.Timestamp getReceivedAt() {
        return this.receivedAt;
    }

    public java.lang.Integer getTotalPages() {
        return this.totalPages;
    }

    public java.lang.String getFilePath() {
        return this.filePath;
    }

    public java.lang.String getChecksum() {
        return this.checksum;
    }

    public java.util.UUID getLinkedPatientId() {
        return this.linkedPatientId;
    }

    public java.util.UUID getLinkedPrescriptionId() {
        return this.linkedPrescriptionId;
    }

    public java.util.UUID getProcessedBy() {
        return this.processedBy;
    }

    public java.util.Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public void setFromFaxNumber(java.lang.String fromFaxNumber) {
        this.fromFaxNumber = fromFaxNumber;
    }

    public void setFromName(java.lang.String fromName) {
        this.fromName = fromName;
    }

    public void setReceivedAt(java.sql.Timestamp receivedAt) {
        this.receivedAt = receivedAt;
    }

    public void setTotalPages(java.lang.Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void setFilePath(java.lang.String filePath) {
        this.filePath = filePath;
    }

    public void setChecksum(java.lang.String checksum) {
        this.checksum = checksum;
    }

    public void setLinkedPatientId(java.util.UUID linkedPatientId) {
        this.linkedPatientId = linkedPatientId;
    }

    public void setLinkedPrescriptionId(java.util.UUID linkedPrescriptionId) {
        this.linkedPrescriptionId = linkedPrescriptionId;
    }

    public void setProcessedBy(java.util.UUID processedBy) {
        this.processedBy = processedBy;
    }

    public void setMetadata(java.util.Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
