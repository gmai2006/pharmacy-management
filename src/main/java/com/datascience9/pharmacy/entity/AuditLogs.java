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
@Table(name = "audit_logs")
public class AuditLogs implements Serializable {
    private static final long serialVersionUID = 176284555409168892L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(name = "id")
    private java.lang.Long id;

    /** Description: entity_type. */
    @Basic
    @Column(name = "entity_type")
    private java.lang.String entityType;

    /** Description: entity_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "entity_id")
    private java.util.UUID entityId;

    /** Description: user_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "user_id")
    private java.util.UUID userId;

    /** Description: action. */
    @Basic
    @Column(name = "action")
    private java.lang.String action;

    /** Description: payload. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "payload")
    private Map<String, Object> payload;

    /** Description: ip_address. */
    @Basic
    @Column(name = "ip_address")
    private java.lang.String ipAddress;

    /** Description: user_agent. */
    @Basic
    @Column(name = "user_agent")
    private java.lang.String userAgent;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    public AuditLogs() {}

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getEntityType() {
        return this.entityType;
    }

    public java.util.UUID getEntityId() {
        return this.entityId;
    }

    public java.util.UUID getUserId() {
        return this.userId;
    }

    public java.lang.String getAction() {
        return this.action;
    }

    public java.util.Map<String, Object> getPayload() {
        return this.payload;
    }

    public java.lang.String getIpAddress() {
        return this.ipAddress;
    }

    public java.lang.String getUserAgent() {
        return this.userAgent;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setEntityType(java.lang.String entityType) {
        this.entityType = entityType;
    }

    public void setEntityId(java.util.UUID entityId) {
        this.entityId = entityId;
    }

    public void setUserId(java.util.UUID userId) {
        this.userId = userId;
    }

    public void setAction(java.lang.String action) {
        this.action = action;
    }

    public void setPayload(java.util.Map<String, Object> payload) {
        this.payload = payload;
    }

    public void setIpAddress(java.lang.String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setUserAgent(java.lang.String userAgent) {
        this.userAgent = userAgent;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
