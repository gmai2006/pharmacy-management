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

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "efax_status_logs")
public class EfaxStatusLogs implements Serializable {
    private static final long serialVersionUID = 176284555410568217L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(name = "id")
    private java.lang.Long id;

    /** Description: efax_job_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(columnDefinition = "UUID", name = "efax_job_id")
    private java.util.UUID efaxJobId;

    /** Description: status. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "status")
    private java.lang.String status;

    /** Description: message. */
    @Basic
    @Column(name = "message")
    private java.lang.String message;

    /** Description: provider_code. */
    @Basic
    @Column(name = "provider_code")
    private java.lang.String providerCode;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    public EfaxStatusLogs() {}

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.util.UUID getEfaxJobId() {
        return this.efaxJobId;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public java.lang.String getMessage() {
        return this.message;
    }

    public java.lang.String getProviderCode() {
        return this.providerCode;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setEfaxJobId(java.util.UUID efaxJobId) {
        this.efaxJobId = efaxJobId;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    public void setProviderCode(java.lang.String providerCode) {
        this.providerCode = providerCode;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
