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
@Table(name = "awp_reclaims")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AwpReclaims implements Serializable {
    private static final long serialVersionUID = 17631113269101657L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Long id;

    /** Description: prescription_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "prescription_id")
    private java.util.UUID prescriptionId;

    /** Description: amount. */
    @Basic
    @Column(name = "amount")
    private java.math.BigDecimal amount;

    /** Description: processed_at. */
    @Basic
    @Column(name = "processed_at")
    private java.sql.Timestamp processedAt;

    /** Description: notes. */
    @Basic
    @Column(name = "notes")
    private String notes;

    public AwpReclaims() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.UUID getPrescriptionId() {
        return this.prescriptionId;
    }

    public java.math.BigDecimal getAmount() {
        return this.amount;
    }

    public java.sql.Timestamp getProcessedAt() {
        return this.processedAt;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }

    public void setProcessedAt(java.sql.Timestamp processedAt) {
        this.processedAt = processedAt;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
