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

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "pos_signatures")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PosSignatures implements Serializable {
    private static final long serialVersionUID = 176351898741688564L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: pos_transaction_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "pos_transaction_id")
    private java.util.UUID posTransactionId;

    /** Description: station_id. */
    @Basic
    @Column(name = "station_id")
    private String stationId;

    /** Description: signature_data. */
    @Basic
    @Column(name = "signature_data")
    private byte[] signatureData;

    /** Description: signed_by. */
    @Basic
    @Column(columnDefinition = "UUID", name = "signed_by")
    private java.util.UUID signedBy;

    /** Description: signed_at. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "signed_at")
    private java.time.LocalDateTime signedAt;

    public PosSignatures() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getPosTransactionId() {
        return this.posTransactionId;
    }

    public String getStationId() {
        return this.stationId;
    }

    public byte[] getSignatureData() {
        return this.signatureData;
    }

    public java.util.UUID getSignedBy() {
        return this.signedBy;
    }

    public java.time.LocalDateTime getSignedAt() {
        return this.signedAt;
    }

    public void setPosTransactionId(java.util.UUID posTransactionId) {
        this.posTransactionId = posTransactionId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public void setSignatureData(byte[] signatureData) {
        this.signatureData = signatureData;
    }

    public void setSignedBy(java.util.UUID signedBy) {
        this.signedBy = signedBy;
    }

    public void setSignedAt(java.time.LocalDateTime signedAt) {
        this.signedAt = signedAt;
    }
}
