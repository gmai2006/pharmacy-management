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
@Table(name = "inventory_items")
public class InventoryItems implements Serializable {
    private static final long serialVersionUID = 176284555404918186L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: ndc. */
    @Basic
    @Column(name = "ndc")
    private java.lang.String ndc;

    /** Description: sku. */
    @Basic
    @Column(name = "sku")
    private java.lang.String sku;

    /** Description: name. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "name")
    private java.lang.String name;

    /** Description: strength. */
    @Basic
    @Column(name = "strength")
    private java.lang.String strength;

    /** Description: form. */
    @Basic
    @Column(name = "form")
    private java.lang.String form;

    /** Description: pack_size. */
    @Basic
    @Column(name = "pack_size")
    private java.lang.Integer packSize;

    /** Description: reorder_rule_id. */
    @Basic
    @Column(name = "reorder_rule_id")
    private java.lang.Integer reorderRuleId;

    /** Description: attributes. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "attributes")
    private Map<String, Object> attributes;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Transient List<PrescriptionItems> prescriptionitems;
    @Transient List<ReorderRules> reorderrules;
    @Transient List<InventoryBatches> inventorybatches;

    public InventoryItems() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.lang.String getNdc() {
        return this.ndc;
    }

    public java.lang.String getSku() {
        return this.sku;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public java.lang.String getStrength() {
        return this.strength;
    }

    public java.lang.String getForm() {
        return this.form;
    }

    public java.lang.Integer getPackSize() {
        return this.packSize;
    }

    public java.lang.Integer getReorderRuleId() {
        return this.reorderRuleId;
    }

    public java.util.Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setNdc(java.lang.String ndc) {
        this.ndc = ndc;
    }

    public void setSku(java.lang.String sku) {
        this.sku = sku;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public void setStrength(java.lang.String strength) {
        this.strength = strength;
    }

    public void setForm(java.lang.String form) {
        this.form = form;
    }

    public void setPackSize(java.lang.Integer packSize) {
        this.packSize = packSize;
    }

    public void setReorderRuleId(java.lang.Integer reorderRuleId) {
        this.reorderRuleId = reorderRuleId;
    }

    public void setAttributes(java.util.Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<PrescriptionItems> getPrescriptionItems() {
        return this.prescriptionitems;
    }

    public List<ReorderRules> getReorderRules() {
        return this.reorderrules;
    }

    public List<InventoryBatches> getInventoryBatches() {
        return this.inventorybatches;
    }

    public void setPrescriptionItems(List<PrescriptionItems> prescriptionitems) {
        this.prescriptionitems = new ArrayList<>(prescriptionitems);
    }

    public void setReorderRules(List<ReorderRules> reorderrules) {
        this.reorderrules = new ArrayList<>(reorderrules);
    }

    public void setInventoryBatches(List<InventoryBatches> inventorybatches) {
        this.inventorybatches = new ArrayList<>(inventorybatches);
    }
}
