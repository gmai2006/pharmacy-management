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
import java.util.ArrayList;
import java.util.List;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "insurance_companies")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InsuranceCompanies implements Serializable {
    private static final long serialVersionUID = 176311132691885415L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: name. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "name")
    private String name;

    /** Description: type. */
    @Basic
    @Column(name = "type")
    private String type;

    /** Description: payer_id. */
    @Basic
    @Column(name = "payer_id")
    private String payerId;

    /** Description: contact_number. */
    @Basic
    @Column(name = "contact_number")
    private String contactNumber;

    /** Description: fax_number. */
    @Basic
    @Column(name = "fax_number")
    private String faxNumber;

    /** Description: email. */
    @Basic
    @Column(name = "email")
    private String email;

    /** Description: address. */
    @Basic
    @Column(name = "address")
    private String address;

    /** Description: city. */
    @Basic
    @Column(name = "city")
    private String city;

    /** Description: state. */
    @Basic
    @Column(name = "state")
    private String state;

    /** Description: zip. */
    @Basic
    @Column(name = "zip")
    private String zip;

    /** Description: website. */
    @Basic
    @Column(name = "website")
    private String website;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    /** Description: updated_at. */
    @Basic
    @Column(name = "updated_at")
    private java.sql.Timestamp updatedAt;

    @Transient List<PrescriptionCopays> prescriptioncopays;
    @Transient List<PatientInsurances> patientinsurances;

    public InsuranceCompanies() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getPayerId() {
        return this.payerId;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public String getFaxNumber() {
        return this.faxNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getZip() {
        return this.zip;
    }

    public String getWebsite() {
        return this.website;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public java.sql.Timestamp getUpdatedAt() {
        return this.updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(java.sql.Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<PrescriptionCopays> getPrescriptionCopays() {
        return this.prescriptioncopays;
    }

    public List<PatientInsurances> getPatientInsurances() {
        return this.patientinsurances;
    }

    public void setPrescriptionCopays(List<PrescriptionCopays> prescriptioncopays) {
        this.prescriptioncopays = new ArrayList<>(prescriptioncopays);
    }

    public void setPatientInsurances(List<PatientInsurances> patientinsurances) {
        this.patientinsurances = new ArrayList<>(patientinsurances);
    }
}
