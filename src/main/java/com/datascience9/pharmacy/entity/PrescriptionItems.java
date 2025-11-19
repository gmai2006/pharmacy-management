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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "prescription_items")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrescriptionItems implements Serializable {
    private static final long serialVersionUID = 176351898739899480L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: prescription_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "prescription_id")
    private java.util.UUID prescriptionId;

    /** Description: inventory_item_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "inventory_item_id")
    private java.util.UUID inventoryItemId;

    /** Description: quantity. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    /** Description: days_supply. */
    @Basic
    @Column(name = "days_supply")
    private Integer daysSupply;

    /** Description: sig. */
    @Basic
    @Column(name = "sig")
    private String sig;

    /** Description: refills_allowed. */
    @Basic
    @Column(name = "refills_allowed")
    private Integer refillsAllowed;

    /** Description: is_controlled. */
    @Basic
    @Column(name = "is_controlled")
    private Boolean isControlled;

    /** Description: label_options. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "label_options")
    private Map<String, Object> labelOptions;

    /** Description: status. */
    @Basic
    @Column(name = "status")
    private String status;

    /** Description: created_at. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    @Transient List<BarcodeLabels> barcodelabels;

    public PrescriptionItems() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getPrescriptionId() {
        return this.prescriptionId;
    }

    public java.util.UUID getInventoryItemId() {
        return this.inventoryItemId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Integer getDaysSupply() {
        return this.daysSupply;
    }

    public String getSig() {
        return this.sig;
    }

    public Integer getRefillsAllowed() {
        return this.refillsAllowed;
    }

    public Boolean getIsControlled() {
        return this.isControlled;
    }

    public Map<String, Object> getLabelOptions() {
        return this.labelOptions;
    }

    public String getStatus() {
        return this.status;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setInventoryItemId(java.util.UUID inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setDaysSupply(Integer daysSupply) {
        this.daysSupply = daysSupply;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public void setRefillsAllowed(Integer refillsAllowed) {
        this.refillsAllowed = refillsAllowed;
    }

    public void setIsControlled(Boolean isControlled) {
        this.isControlled = isControlled;
    }

    public void setLabelOptions(Map<String, Object> labelOptions) {
        this.labelOptions = labelOptions;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<BarcodeLabels> getBarcodeLabels() {
        return this.barcodelabels;
    }

    public void setBarcodeLabels(List<BarcodeLabels> barcodelabels) {
        this.barcodelabels = new ArrayList<>(barcodelabels);
    }
}
