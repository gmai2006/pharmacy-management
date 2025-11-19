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
@Table(name = "access_logs")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccessLogs implements Serializable {
    private static final long serialVersionUID = 176351898744974400L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Long id;

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
    private String entityType;

    /** Description: entity_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "entity_id")
    private java.util.UUID entityId;

    /** Description: action. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "action")
    private String action;

    /** Description: access_reason. */
    @Basic
    @Column(name = "access_reason")
    private String accessReason;

    /** Description: access_context. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "access_context")
    private Map<String, Object> accessContext;

    /** Description: ip_address. */
    @Basic
    @Column(name = "ip_address")
    private String ipAddress;

    /** Description: user_agent. */
    @Basic
    @Column(name = "user_agent")
    private String userAgent;

    /** Description: accessed_at. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "accessed_at")
    private java.time.LocalDateTime accessedAt;

    public AccessLogs() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.UUID getUserId() {
        return this.userId;
    }

    public java.util.UUID getPatientId() {
        return this.patientId;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public java.util.UUID getEntityId() {
        return this.entityId;
    }

    public String getAction() {
        return this.action;
    }

    public String getAccessReason() {
        return this.accessReason;
    }

    public Map<String, Object> getAccessContext() {
        return this.accessContext;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public java.time.LocalDateTime getAccessedAt() {
        return this.accessedAt;
    }

    public void setUserId(java.util.UUID userId) {
        this.userId = userId;
    }

    public void setPatientId(java.util.UUID patientId) {
        this.patientId = patientId;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public void setEntityId(java.util.UUID entityId) {
        this.entityId = entityId;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setAccessReason(String accessReason) {
        this.accessReason = accessReason;
    }

    public void setAccessContext(Map<String, Object> accessContext) {
        this.accessContext = accessContext;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setAccessedAt(java.time.LocalDateTime accessedAt) {
        this.accessedAt = accessedAt;
    }
}
