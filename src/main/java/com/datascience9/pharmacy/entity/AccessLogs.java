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
@Table(name = "access_logs")
public class AccessLogs implements Serializable {
    private static final long serialVersionUID = 176284555409718163L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(name = "id")
    private java.lang.Long id;

    /** Description: user_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "user_id")
    private java.util.UUID userId;

    /** Description: patient_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "patient_id")
    private java.util.UUID patientId;

    /** Description: entity_type. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "entity_type")
    private java.lang.String entityType;

    /** Description: entity_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "entity_id")
    private java.util.UUID entityId;

    /** Description: action. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "action")
    private java.lang.String action;

    /** Description: access_reason. */
    @Basic
    @Column(name = "access_reason")
    private java.lang.String accessReason;

    /** Description: access_context. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "access_context")
    private Map<String, Object> accessContext;

    /** Description: ip_address. */
    @Basic
    @Column(name = "ip_address")
    private java.lang.String ipAddress;

    /** Description: user_agent. */
    @Basic
    @Column(name = "user_agent")
    private java.lang.String userAgent;

    /** Description: accessed_at. */
    @Basic
    @Column(name = "accessed_at")
    private java.sql.Timestamp accessedAt;

    public AccessLogs() {}

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.util.UUID getUserId() {
        return this.userId;
    }

    public java.util.UUID getPatientId() {
        return this.patientId;
    }

    public java.lang.String getEntityType() {
        return this.entityType;
    }

    public java.util.UUID getEntityId() {
        return this.entityId;
    }

    public java.lang.String getAction() {
        return this.action;
    }

    public java.lang.String getAccessReason() {
        return this.accessReason;
    }

    public java.util.Map<String, Object> getAccessContext() {
        return this.accessContext;
    }

    public java.lang.String getIpAddress() {
        return this.ipAddress;
    }

    public java.lang.String getUserAgent() {
        return this.userAgent;
    }

    public java.sql.Timestamp getAccessedAt() {
        return this.accessedAt;
    }

    public void setUserId(java.util.UUID userId) {
        this.userId = userId;
    }

    public void setPatientId(java.util.UUID patientId) {
        this.patientId = patientId;
    }

    public void setEntityType(java.lang.String entityType) {
        this.entityType = entityType;
    }

    public void setEntityId(java.util.UUID entityId) {
        this.entityId = entityId;
    }

    public void setAction(java.lang.String action) {
        this.action = action;
    }

    public void setAccessReason(java.lang.String accessReason) {
        this.accessReason = accessReason;
    }

    public void setAccessContext(java.util.Map<String, Object> accessContext) {
        this.accessContext = accessContext;
    }

    public void setIpAddress(java.lang.String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setUserAgent(java.lang.String userAgent) {
        this.userAgent = userAgent;
    }

    public void setAccessedAt(java.sql.Timestamp accessedAt) {
        this.accessedAt = accessedAt;
    }
}
