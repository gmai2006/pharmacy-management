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
@Table(name = "prescription_transfers")
public class PrescriptionTransfers implements Serializable {
    private static final long serialVersionUID = 176284555406463276L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: prescription_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "prescription_id")
    private java.util.UUID prescriptionId;

    /** Description: transfer_type. */
    @Basic
    @Column(name = "transfer_type")
    private java.lang.String transferType;

    /** Description: provider. */
    @Basic
    @Column(name = "provider")
    private java.lang.String provider;

    /** Description: external_id. */
    @Basic
    @Column(name = "external_id")
    private java.lang.String externalId;

    /** Description: payload. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "payload")
    private Map<String, Object> payload;

    /** Description: transmitted_at. */
    @Basic
    @Column(name = "transmitted_at")
    private java.sql.Timestamp transmittedAt;

    /** Description: status. */
    @Basic
    @Column(name = "status")
    private java.lang.String status;

    /** Description: signed. */
    @Basic
    @Column(name = "signed")
    private java.lang.Boolean signed;

    public PrescriptionTransfers() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getPrescriptionId() {
        return this.prescriptionId;
    }

    public java.lang.String getTransferType() {
        return this.transferType;
    }

    public java.lang.String getProvider() {
        return this.provider;
    }

    public java.lang.String getExternalId() {
        return this.externalId;
    }

    public java.util.Map<String, Object> getPayload() {
        return this.payload;
    }

    public java.sql.Timestamp getTransmittedAt() {
        return this.transmittedAt;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public java.lang.Boolean getSigned() {
        return this.signed;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setTransferType(java.lang.String transferType) {
        this.transferType = transferType;
    }

    public void setProvider(java.lang.String provider) {
        this.provider = provider;
    }

    public void setExternalId(java.lang.String externalId) {
        this.externalId = externalId;
    }

    public void setPayload(java.util.Map<String, Object> payload) {
        this.payload = payload;
    }

    public void setTransmittedAt(java.sql.Timestamp transmittedAt) {
        this.transmittedAt = transmittedAt;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public void setSigned(java.lang.Boolean signed) {
        this.signed = signed;
    }
}
