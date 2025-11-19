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

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "inventory_batches")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventoryBatches implements Serializable {
    private static final long serialVersionUID = 176351898738722828L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: inventory_item_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "inventory_item_id")
    private java.util.UUID inventoryItemId;

    /** Description: lot_number. */
    @Basic
    @Column(name = "lot_number")
    private String lotNumber;

    /** Description: expiry_date. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "expiry_date")
    private java.time.LocalDateTime expiryDate;

    /** Description: quantity_on_hand. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "quantity_on_hand")
    private Integer quantityOnHand;

    /** Description: location. */
    @Basic
    @Column(name = "location")
    private String location;

    /** Description: wholesaler_id. */
    @Basic
    @Column(name = "wholesaler_id")
    private Integer wholesalerId;

    /** Description: created_at. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    /** Description: last_order. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "last_order")
    private java.time.LocalDateTime lastOrder;

    @Transient List<DscsaSerials> dscsaserials;

    public InventoryBatches() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getInventoryItemId() {
        return this.inventoryItemId;
    }

    public String getLotNumber() {
        return this.lotNumber;
    }

    public java.time.LocalDateTime getExpiryDate() {
        return this.expiryDate;
    }

    public Integer getQuantityOnHand() {
        return this.quantityOnHand;
    }

    public String getLocation() {
        return this.location;
    }

    public Integer getWholesalerId() {
        return this.wholesalerId;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public java.time.LocalDateTime getLastOrder() {
        return this.lastOrder;
    }

    public void setInventoryItemId(java.util.UUID inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public void setExpiryDate(java.time.LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWholesalerId(Integer wholesalerId) {
        this.wholesalerId = wholesalerId;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastOrder(java.time.LocalDateTime lastOrder) {
        this.lastOrder = lastOrder;
    }

    public List<DscsaSerials> getDscsaSerials() {
        return this.dscsaserials;
    }

    public void setDscsaSerials(List<DscsaSerials> dscsaserials) {
        this.dscsaserials = new ArrayList<>(dscsaserials);
    }
}
