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
@Table(name = "profit_audit_warnings")
public class ProfitAuditWarnings implements Serializable {
    private static final long serialVersionUID = 176284555408384557L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(name = "id")
    private java.lang.Long id;

    /** Description: related_object_type. */
    @Basic
    @Column(name = "related_object_type")
    private java.lang.String relatedObjectType;

    /** Description: related_object_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "related_object_id")
    private java.util.UUID relatedObjectId;

    /** Description: warning_code. */
    @Basic
    @Column(name = "warning_code")
    private java.lang.String warningCode;

    /** Description: description. */
    @Basic
    @Column(name = "description")
    private java.lang.String description;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    public ProfitAuditWarnings() {}

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.lang.String getRelatedObjectType() {
        return this.relatedObjectType;
    }

    public java.util.UUID getRelatedObjectId() {
        return this.relatedObjectId;
    }

    public java.lang.String getWarningCode() {
        return this.warningCode;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setRelatedObjectType(java.lang.String relatedObjectType) {
        this.relatedObjectType = relatedObjectType;
    }

    public void setRelatedObjectId(java.util.UUID relatedObjectId) {
        this.relatedObjectId = relatedObjectId;
    }

    public void setWarningCode(java.lang.String warningCode) {
        this.warningCode = warningCode;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
