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
@Table(name = "tasks")
public class Tasks implements Serializable {
    private static final long serialVersionUID = 176284555407191542L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: object_type. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "object_type")
    private java.lang.String objectType;

    /** Description: object_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(columnDefinition = "UUID", name = "object_id")
    private java.util.UUID objectId;

    /** Description: workflow_id. */
    @Basic
    @Column(name = "workflow_id")
    private java.lang.Integer workflowId;

    /** Description: step_id. */
    @Basic
    @Column(name = "step_id")
    private java.lang.Integer stepId;

    /** Description: queue_id. */
    @Basic
    @Column(name = "queue_id")
    private java.lang.Integer queueId;

    /** Description: assignee. */
    @Basic
    @Column(columnDefinition = "UUID", name = "assignee")
    private java.util.UUID assignee;

    /** Description: status. */
    @Basic
    @Column(name = "status")
    private java.lang.String status;

    /** Description: payload. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "payload")
    private Map<String, Object> payload;

    /** Description: priority. */
    @Basic
    @Column(name = "priority")
    private java.lang.Integer priority;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    /** Description: due_at. */
    @Basic
    @Column(name = "due_at")
    private java.sql.Timestamp dueAt;

    public Tasks() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.lang.String getObjectType() {
        return this.objectType;
    }

    public java.util.UUID getObjectId() {
        return this.objectId;
    }

    public java.lang.Integer getWorkflowId() {
        return this.workflowId;
    }

    public java.lang.Integer getStepId() {
        return this.stepId;
    }

    public java.lang.Integer getQueueId() {
        return this.queueId;
    }

    public java.util.UUID getAssignee() {
        return this.assignee;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public java.util.Map<String, Object> getPayload() {
        return this.payload;
    }

    public java.lang.Integer getPriority() {
        return this.priority;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public java.sql.Timestamp getDueAt() {
        return this.dueAt;
    }

    public void setObjectType(java.lang.String objectType) {
        this.objectType = objectType;
    }

    public void setObjectId(java.util.UUID objectId) {
        this.objectId = objectId;
    }

    public void setWorkflowId(java.lang.Integer workflowId) {
        this.workflowId = workflowId;
    }

    public void setStepId(java.lang.Integer stepId) {
        this.stepId = stepId;
    }

    public void setQueueId(java.lang.Integer queueId) {
        this.queueId = queueId;
    }

    public void setAssignee(java.util.UUID assignee) {
        this.assignee = assignee;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public void setPayload(java.util.Map<String, Object> payload) {
        this.payload = payload;
    }

    public void setPriority(java.lang.Integer priority) {
        this.priority = priority;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setDueAt(java.sql.Timestamp dueAt) {
        this.dueAt = dueAt;
    }
}
