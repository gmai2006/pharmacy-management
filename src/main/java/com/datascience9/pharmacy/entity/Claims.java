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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "claims")
public class Claims implements Serializable {
    private static final long serialVersionUID = 176294189247272301L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: prescription_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "prescription_id")
    private java.util.UUID prescriptionId;

    /** Description: payer_name. */
    @Basic
    @Column(name = "payer_name")
    private String payerName;

    /** Description: claim_status. */
    @Basic
    @Column(name = "claim_status")
    private String claimStatus;

    /** Description: submitted_at. */
    @Basic
    @Column(name = "submitted_at")
    private java.sql.Timestamp submittedAt;

    /** Description: response. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "response")
    private Map<String, Object> response;

    /** Description: fiscal_fields. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "fiscal_fields")
    private Map<String, Object> fiscalFields;

    @Transient List<DirFees> dirfees;

    public Claims() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getPrescriptionId() {
        return this.prescriptionId;
    }

    public String getPayerName() {
        return this.payerName;
    }

    public String getClaimStatus() {
        return this.claimStatus;
    }

    public java.sql.Timestamp getSubmittedAt() {
        return this.submittedAt;
    }

    public Map<String, Object> getResponse() {
        return this.response;
    }

    public Map<String, Object> getFiscalFields() {
        return this.fiscalFields;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public void setSubmittedAt(java.sql.Timestamp submittedAt) {
        this.submittedAt = submittedAt;
    }

    public void setResponse(Map<String, Object> response) {
        this.response = response;
    }

    public void setFiscalFields(Map<String, Object> fiscalFields) {
        this.fiscalFields = fiscalFields;
    }

    public List<DirFees> getDirFees() {
        return this.dirfees;
    }

    public void setDirFees(List<DirFees> dirfees) {
        this.dirfees = new ArrayList<>(dirfees);
    }
}
