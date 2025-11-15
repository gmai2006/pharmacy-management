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

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "efax_status_logs")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EfaxStatusLogs implements Serializable {
    private static final long serialVersionUID = 176311132694736432L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Long id;

    /** Description: efax_job_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(columnDefinition = "UUID", name = "efax_job_id")
    private java.util.UUID efaxJobId;

    /** Description: status. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "status")
    private String status;

    /** Description: message. */
    @Basic
    @Column(name = "message")
    private String message;

    /** Description: provider_code. */
    @Basic
    @Column(name = "provider_code")
    private String providerCode;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    public EfaxStatusLogs() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.UUID getEfaxJobId() {
        return this.efaxJobId;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public String getProviderCode() {
        return this.providerCode;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setEfaxJobId(java.util.UUID efaxJobId) {
        this.efaxJobId = efaxJobId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
