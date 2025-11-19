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
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "tasks")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Tasks implements Serializable {
    private static final long serialVersionUID = 176311132689928998L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: object_type. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "object_type")
    private String objectType;

    /** Description: object_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(columnDefinition = "UUID", name = "object_id")
    private java.util.UUID objectId;

    /** Description: workflow_id. */
    @Basic
    @Column(name = "workflow_id")
    private Integer workflowId;

    /** Description: step_id. */
    @Basic
    @Column(name = "step_id")
    private Integer stepId;

    /** Description: queue_id. */
    @Basic
    @Column(name = "queue_id")
    private Integer queueId;

    /** Description: assignee. */
    @Basic
    @Column(columnDefinition = "UUID", name = "assignee")
    private java.util.UUID assignee;

    /** Description: status. */
    @Basic
    @Column(name = "status")
    private String status;

    /** Description: payload. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "payload")
    private Map<String, Object> payload;

    /** Description: priority. */
    @Basic
    @Column(name = "priority")
    private Integer priority;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    /** Description: due_at. */
    @Basic
    @Column(name = "due_at")
    private java.time.LocalDateTime dueAt;

    public Tasks() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public String getObjectType() {
        return this.objectType;
    }

    public java.util.UUID getObjectId() {
        return this.objectId;
    }

    public Integer getWorkflowId() {
        return this.workflowId;
    }

    public Integer getStepId() {
        return this.stepId;
    }

    public Integer getQueueId() {
        return this.queueId;
    }

    public java.util.UUID getAssignee() {
        return this.assignee;
    }

    public String getStatus() {
        return this.status;
    }

    public Map<String, Object> getPayload() {
        return this.payload;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public java.time.LocalDateTime getDueAt() {
        return this.dueAt;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public void setObjectId(java.util.UUID objectId) {
        this.objectId = objectId;
    }

    public void setWorkflowId(Integer workflowId) {
        this.workflowId = workflowId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }

    public void setQueueId(Integer queueId) {
        this.queueId = queueId;
    }

    public void setAssignee(java.util.UUID assignee) {
        this.assignee = assignee;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setDueAt(java.time.LocalDateTime dueAt) {
        this.dueAt = dueAt;
    }
}
