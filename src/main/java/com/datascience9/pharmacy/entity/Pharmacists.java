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
@Table(name = "pharmacists")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pharmacists implements Serializable {
    private static final long serialVersionUID = 176351898738125658L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: user_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "user_id")
    private java.util.UUID userId;

    /** Description: license_number. */
    @Basic
    @Column(name = "license_number")
    private String licenseNumber;

    /** Description: license_state. */
    @Basic
    @Column(name = "license_state")
    private String licenseState;

    /** Description: active. */
    @Basic
    @Column(name = "active")
    private Boolean active;

    public Pharmacists() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getUserId() {
        return this.userId;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public String getLicenseState() {
        return this.licenseState;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setUserId(java.util.UUID userId) {
        this.userId = userId;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setLicenseState(String licenseState) {
        this.licenseState = licenseState;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
