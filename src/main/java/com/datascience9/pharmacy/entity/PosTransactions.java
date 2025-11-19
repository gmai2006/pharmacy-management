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
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "pos_transactions")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PosTransactions implements Serializable {
    private static final long serialVersionUID = 176311132690437621L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: prescription_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "prescription_id")
    private java.util.UUID prescriptionId;

    /** Description: patient_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "patient_id")
    private java.util.UUID patientId;

    /** Description: station_id. */
    @Basic
    @Column(name = "station_id")
    private String stationId;

    /** Description: total_amount. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "total_amount")
    private java.math.BigDecimal totalAmount;

    /** Description: status. */
    @Basic
    @Column(name = "status")
    private String status;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    /** Description: metadata. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "metadata")
    private Map<String, Object> metadata;

    @Transient List<Payments> payments;
    @Transient List<PosSignatures> possignatures;

    public PosTransactions() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getPrescriptionId() {
        return this.prescriptionId;
    }

    public java.util.UUID getPatientId() {
        return this.patientId;
    }

    public String getStationId() {
        return this.stationId;
    }

    public java.math.BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public String getStatus() {
        return this.status;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setPatientId(java.util.UUID patientId) {
        this.patientId = patientId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public void setTotalAmount(java.math.BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public List<Payments> getPayments() {
        return this.payments;
    }

    public List<PosSignatures> getPosSignatures() {
        return this.possignatures;
    }

    public void setPayments(List<Payments> payments) {
        this.payments = new ArrayList<>(payments);
    }

    public void setPosSignatures(List<PosSignatures> possignatures) {
        this.possignatures = new ArrayList<>(possignatures);
    }
}
