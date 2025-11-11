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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "wholesalers")
public class Wholesalers implements Serializable {
    private static final long serialVersionUID = 176284555404878700L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(name = "id")
    private java.lang.Integer id;

    /** Description: name. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "name")
    private java.lang.String name;

    /** Description: contact. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "contact")
    private Map<String, Object> contact;

    /** Description: trading_partner_id. */
    @Basic
    @Column(name = "trading_partner_id")
    private java.lang.String tradingPartnerId;

    @Transient List<PurchaseOrders> purchaseorders;
    @Transient List<InventoryBatches> inventorybatches;

    public Wholesalers() {}

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public java.util.Map<String, Object> getContact() {
        return this.contact;
    }

    public java.lang.String getTradingPartnerId() {
        return this.tradingPartnerId;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public void setContact(java.util.Map<String, Object> contact) {
        this.contact = contact;
    }

    public void setTradingPartnerId(java.lang.String tradingPartnerId) {
        this.tradingPartnerId = tradingPartnerId;
    }

    public List<PurchaseOrders> getPurchaseOrders() {
        return this.purchaseorders;
    }

    public List<InventoryBatches> getInventoryBatches() {
        return this.inventorybatches;
    }

    public void setPurchaseOrders(List<PurchaseOrders> purchaseorders) {
        this.purchaseorders = new ArrayList<>(purchaseorders);
    }

    public void setInventoryBatches(List<InventoryBatches> inventorybatches) {
        this.inventorybatches = new ArrayList<>(inventorybatches);
    }
}
