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
@Table(name = "prescription_audit")
public class PrescriptionAudit implements Serializable {
    private static final long serialVersionUID = 176284555406652069L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(name = "id")
    private java.lang.Long id;

    /** Description: prescription_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "prescription_id")
    private java.util.UUID prescriptionId;

    /** Description: user_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "user_id")
    private java.util.UUID userId;

    /** Description: action. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "action")
    private java.lang.String action;

    /** Description: diff. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "diff")
    private Map<String, Object> diff;

    /** Description: reason. */
    @Basic
    @Column(name = "reason")
    private java.lang.String reason;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    public PrescriptionAudit() {}

    public java.lang.Long getId() {
        return this.id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public java.util.UUID getPrescriptionId() {
        return this.prescriptionId;
    }

    public java.util.UUID getUserId() {
        return this.userId;
    }

    public java.lang.String getAction() {
        return this.action;
    }

    public java.util.Map<String, Object> getDiff() {
        return this.diff;
    }

    public java.lang.String getReason() {
        return this.reason;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setUserId(java.util.UUID userId) {
        this.userId = userId;
    }

    public void setAction(java.lang.String action) {
        this.action = action;
    }

    public void setDiff(java.util.Map<String, Object> diff) {
        this.diff = diff;
    }

    public void setReason(java.lang.String reason) {
        this.reason = reason;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
