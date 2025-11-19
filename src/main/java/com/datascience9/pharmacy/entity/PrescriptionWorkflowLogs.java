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
@Table(name = "prescription_workflow_logs")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrescriptionWorkflowLogs implements Serializable {
    private static final long serialVersionUID = 176351898743729423L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Long id;

    /** Description: prescription_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(columnDefinition = "UUID", name = "prescription_id")
    private java.util.UUID prescriptionId;

    /** Description: from_status. */
    @Basic
    @Column(name = "from_status")
    private String fromStatus;

    /** Description: to_status. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "to_status")
    private String toStatus;

    /** Description: queue_name. */
    @Basic
    @Column(name = "queue_name")
    private String queueName;

    /** Description: changed_by. */
    @Basic
    @Column(columnDefinition = "UUID", name = "changed_by")
    private java.util.UUID changedBy;

    /** Description: change_reason. */
    @Basic
    @Column(name = "change_reason")
    private String changeReason;

    /** Description: changed_at. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "changed_at")
    private java.time.LocalDateTime changedAt;

    /** Description: metadata. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "metadata")
    private Map<String, Object> metadata;

    public PrescriptionWorkflowLogs() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.UUID getPrescriptionId() {
        return this.prescriptionId;
    }

    public String getFromStatus() {
        return this.fromStatus;
    }

    public String getToStatus() {
        return this.toStatus;
    }

    public String getQueueName() {
        return this.queueName;
    }

    public java.util.UUID getChangedBy() {
        return this.changedBy;
    }

    public String getChangeReason() {
        return this.changeReason;
    }

    public java.time.LocalDateTime getChangedAt() {
        return this.changedAt;
    }

    public Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setFromStatus(String fromStatus) {
        this.fromStatus = fromStatus;
    }

    public void setToStatus(String toStatus) {
        this.toStatus = toStatus;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public void setChangedBy(java.util.UUID changedBy) {
        this.changedBy = changedBy;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }

    public void setChangedAt(java.time.LocalDateTime changedAt) {
        this.changedAt = changedAt;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
