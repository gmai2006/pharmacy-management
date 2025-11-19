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
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "consent_records")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsentRecords implements Serializable {
    private static final long serialVersionUID = 176351898744592640L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: patient_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "patient_id")
    private java.util.UUID patientId;

    /** Description: consent_type. */
    @Basic
    @Column(name = "consent_type")
    private String consentType;

    /** Description: granted. */
    @Basic
    @Column(name = "granted")
    private Boolean granted;

    /** Description: source. */
    @Basic
    @Column(name = "source")
    private String source;

    /** Description: recorded_by. */
    @Basic
    @Column(columnDefinition = "UUID", name = "recorded_by")
    private java.util.UUID recordedBy;

    /** Description: recorded_at. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "recorded_at")
    private java.time.LocalDateTime recordedAt;

    /** Description: metadata. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "metadata")
    private Map<String, Object> metadata;

    public ConsentRecords() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getPatientId() {
        return this.patientId;
    }

    public String getConsentType() {
        return this.consentType;
    }

    public Boolean getGranted() {
        return this.granted;
    }

    public String getSource() {
        return this.source;
    }

    public java.util.UUID getRecordedBy() {
        return this.recordedBy;
    }

    public java.time.LocalDateTime getRecordedAt() {
        return this.recordedAt;
    }

    public Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public void setPatientId(java.util.UUID patientId) {
        this.patientId = patientId;
    }

    public void setConsentType(String consentType) {
        this.consentType = consentType;
    }

    public void setGranted(Boolean granted) {
        this.granted = granted;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setRecordedBy(java.util.UUID recordedBy) {
        this.recordedBy = recordedBy;
    }

    public void setRecordedAt(java.time.LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
