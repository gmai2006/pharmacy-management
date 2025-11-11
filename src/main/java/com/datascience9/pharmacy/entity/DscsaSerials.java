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
@Table(name = "dscsa_serials")
public class DscsaSerials implements Serializable {
    private static final long serialVersionUID = 17628455540544951L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: batch_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "batch_id")
    private java.util.UUID batchId;

    /** Description: serial_number. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "serial_number")
    private java.lang.String serialNumber;

    /** Description: status. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "status")
    private java.lang.String status;

    /** Description: trace_metadata. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "trace_metadata")
    private Map<String, Object> traceMetadata;

    /** Description: last_updated. */
    @Basic
    @Column(name = "last_updated")
    private java.sql.Timestamp lastUpdated;

    public DscsaSerials() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getBatchId() {
        return this.batchId;
    }

    public java.lang.String getSerialNumber() {
        return this.serialNumber;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public java.util.Map<String, Object> getTraceMetadata() {
        return this.traceMetadata;
    }

    public java.sql.Timestamp getLastUpdated() {
        return this.lastUpdated;
    }

    public void setBatchId(java.util.UUID batchId) {
        this.batchId = batchId;
    }

    public void setSerialNumber(java.lang.String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public void setTraceMetadata(java.util.Map<String, Object> traceMetadata) {
        this.traceMetadata = traceMetadata;
    }

    public void setLastUpdated(java.sql.Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
