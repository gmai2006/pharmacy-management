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
@Table(name = "integration_events")
public class IntegrationEvents implements Serializable {
    private static final long serialVersionUID = 176284555408838929L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: integration_id. */
    @Basic
    @Column(name = "integration_id")
    private java.lang.Integer integrationId;

    /** Description: event_type. */
    @Basic
    @Column(name = "event_type")
    private java.lang.String eventType;

    /** Description: external_id. */
    @Basic
    @Column(name = "external_id")
    private java.lang.String externalId;

    /** Description: payload. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "payload")
    private Map<String, Object> payload;

    /** Description: processed_at. */
    @Basic
    @Column(name = "processed_at")
    private java.sql.Timestamp processedAt;

    /** Description: status. */
    @Basic
    @Column(name = "status")
    private java.lang.String status;

    public IntegrationEvents() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.lang.Integer getIntegrationId() {
        return this.integrationId;
    }

    public java.lang.String getEventType() {
        return this.eventType;
    }

    public java.lang.String getExternalId() {
        return this.externalId;
    }

    public java.util.Map<String, Object> getPayload() {
        return this.payload;
    }

    public java.sql.Timestamp getProcessedAt() {
        return this.processedAt;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public void setIntegrationId(java.lang.Integer integrationId) {
        this.integrationId = integrationId;
    }

    public void setEventType(java.lang.String eventType) {
        this.eventType = eventType;
    }

    public void setExternalId(java.lang.String externalId) {
        this.externalId = externalId;
    }

    public void setPayload(java.util.Map<String, Object> payload) {
        this.payload = payload;
    }

    public void setProcessedAt(java.sql.Timestamp processedAt) {
        this.processedAt = processedAt;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }
}
