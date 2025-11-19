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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "prescription_transfers")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrescriptionTransfers implements Serializable {
    private static final long serialVersionUID = 176351898740054559L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: prescription_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "prescription_id")
    private java.util.UUID prescriptionId;

    /** Description: transfer_type. */
    @Basic
    @Column(name = "transfer_type")
    private String transferType;

    /** Description: provider. */
    @Basic
    @Column(name = "provider")
    private String provider;

    /** Description: external_id. */
    @Basic
    @Column(name = "external_id")
    private String externalId;

    /** Description: payload. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "payload")
    private Map<String, Object> payload;

    /** Description: transmitted_at. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "transmitted_at")
    private java.time.LocalDateTime transmittedAt;

    /** Description: status. */
    @Basic
    @Column(name = "status")
    private String status;

    /** Description: signed. */
    @Basic
    @Column(name = "signed")
    private Boolean signed;

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

    public String getTransferType() {
        return this.transferType;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public Map<String, Object> getPayload() {
        return this.payload;
    }

    public java.time.LocalDateTime getTransmittedAt() {
        return this.transmittedAt;
    }

    public String getStatus() {
        return this.status;
    }

    public Boolean getSigned() {
        return this.signed;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }

    public void setTransmittedAt(java.time.LocalDateTime transmittedAt) {
        this.transmittedAt = transmittedAt;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSigned(Boolean signed) {
        this.signed = signed;
    }
}
