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
@Table(name = "profit_audit_warnings")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfitAuditWarnings implements Serializable {
    private static final long serialVersionUID = 176311132691245019L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Long id;

    /** Description: related_object_type. */
    @Basic
    @Column(name = "related_object_type")
    private String relatedObjectType;

    /** Description: related_object_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "related_object_id")
    private java.util.UUID relatedObjectId;

    /** Description: warning_code. */
    @Basic
    @Column(name = "warning_code")
    private String warningCode;

    /** Description: description. */
    @Basic
    @Column(name = "description")
    private String description;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    public ProfitAuditWarnings() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRelatedObjectType() {
        return this.relatedObjectType;
    }

    public java.util.UUID getRelatedObjectId() {
        return this.relatedObjectId;
    }

    public String getWarningCode() {
        return this.warningCode;
    }

    public String getDescription() {
        return this.description;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setRelatedObjectType(String relatedObjectType) {
        this.relatedObjectType = relatedObjectType;
    }

    public void setRelatedObjectId(java.util.UUID relatedObjectId) {
        this.relatedObjectId = relatedObjectId;
    }

    public void setWarningCode(String warningCode) {
        this.warningCode = warningCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
