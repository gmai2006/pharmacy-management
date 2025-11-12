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
import java.io.Serializable;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "patient_aliases")
public class PatientAliases implements Serializable {
    private static final long serialVersionUID = 176294189242192846L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Integer id;

    /** Description: patient_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "patient_id")
    private java.util.UUID patientId;

    /** Description: alias_type. */
    @Basic
    @Column(name = "alias_type")
    private String aliasType;

    /** Description: alias_value. */
    @Basic
    @Column(name = "alias_value")
    private String aliasValue;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    public PatientAliases() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.util.UUID getPatientId() {
        return this.patientId;
    }

    public String getAliasType() {
        return this.aliasType;
    }

    public String getAliasValue() {
        return this.aliasValue;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setPatientId(java.util.UUID patientId) {
        this.patientId = patientId;
    }

    public void setAliasType(String aliasType) {
        this.aliasType = aliasType;
    }

    public void setAliasValue(String aliasValue) {
        this.aliasValue = aliasValue;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
