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
@Table(name = "barcode_labels")
public class BarcodeLabels implements Serializable {
    private static final long serialVersionUID = 176284555407466141L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: prescription_item_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "prescription_item_id")
    private java.util.UUID prescriptionItemId;

    /** Description: barcode. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "barcode")
    private java.lang.String barcode;

    /** Description: label_type. */
    @Basic
    @Column(name = "label_type")
    private java.lang.String labelType;

    /** Description: generated_at. */
    @Basic
    @Column(name = "generated_at")
    private java.sql.Timestamp generatedAt;

    /** Description: printed_by. */
    @Basic
    @Column(columnDefinition = "UUID", name = "printed_by")
    private java.util.UUID printedBy;

    /** Description: print_payload. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "print_payload")
    private Map<String, Object> printPayload;

    public BarcodeLabels() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getPrescriptionItemId() {
        return this.prescriptionItemId;
    }

    public java.lang.String getBarcode() {
        return this.barcode;
    }

    public java.lang.String getLabelType() {
        return this.labelType;
    }

    public java.sql.Timestamp getGeneratedAt() {
        return this.generatedAt;
    }

    public java.util.UUID getPrintedBy() {
        return this.printedBy;
    }

    public java.util.Map<String, Object> getPrintPayload() {
        return this.printPayload;
    }

    public void setPrescriptionItemId(java.util.UUID prescriptionItemId) {
        this.prescriptionItemId = prescriptionItemId;
    }

    public void setBarcode(java.lang.String barcode) {
        this.barcode = barcode;
    }

    public void setLabelType(java.lang.String labelType) {
        this.labelType = labelType;
    }

    public void setGeneratedAt(java.sql.Timestamp generatedAt) {
        this.generatedAt = generatedAt;
    }

    public void setPrintedBy(java.util.UUID printedBy) {
        this.printedBy = printedBy;
    }

    public void setPrintPayload(java.util.Map<String, Object> printPayload) {
        this.printPayload = printPayload;
    }
}
