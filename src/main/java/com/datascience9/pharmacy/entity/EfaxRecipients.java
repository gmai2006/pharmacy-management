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
@Table(name = "efax_recipients")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EfaxRecipients implements Serializable {
    private static final long serialVersionUID = 176311132694237650L;

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

    /** Description: organization. */
    @Basic
    @Column(name = "organization")
    private String organization;

    /** Description: fax_number. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "fax_number")
    private String faxNumber;

    /** Description: email. */
    @Basic
    @Column(name = "email")
    private String email;

    /** Description: contact_type. */
    @Basic
    @Column(name = "contact_type")
    private String contactType;

    /** Description: is_verified. */
    @Basic
    @Column(name = "is_verified")
    private Boolean isVerified;

    /** Description: last_verified_at. */
    @Basic
    @Column(name = "last_verified_at")
    private java.time.LocalDateTime lastVerifiedAt;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    @Transient List<EfaxJobs> efaxjobs;

    public EfaxRecipients() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getOrganization() {
        return this.organization;
    }

    public String getFaxNumber() {
        return this.faxNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public String getContactType() {
        return this.contactType;
    }

    public Boolean getIsVerified() {
        return this.isVerified;
    }

    public java.time.LocalDateTime getLastVerifiedAt() {
        return this.lastVerifiedAt;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public void setLastVerifiedAt(java.time.LocalDateTime lastVerifiedAt) {
        this.lastVerifiedAt = lastVerifiedAt;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<EfaxJobs> getEfaxJobs() {
        return this.efaxjobs;
    }

    public void setEfaxJobs(List<EfaxJobs> efaxjobs) {
        this.efaxjobs = new ArrayList<>(efaxjobs);
    }
}
