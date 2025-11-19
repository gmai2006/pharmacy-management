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
@Table(name = "inventory_items")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventoryItems implements Serializable {
    private static final long serialVersionUID = 176311132687744337L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: ndc. */
    @Basic
    @Column(name = "ndc")
    private String ndc;

    /** Description: sku. */
    @Basic
    @Column(name = "sku")
    private String sku;

    /** Description: name. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "name")
    private String name;

    /** Description: strength. */
    @Basic
    @Column(name = "strength")
    private String strength;

    /** Description: form. */
    @Basic
    @Column(name = "form")
    private String form;

    /** Description: pack_size. */
    @Basic
    @Column(name = "pack_size")
    private Integer packSize;

    /** Description: reorder_rule_id. */
    @Basic
    @Column(name = "reorder_rule_id")
    private Integer reorderRuleId;

    /** Description: attributes. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "attributes")
    private Map<String, Object> attributes;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

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

    public String getNdc() {
        return this.ndc;
    }

    public String getSku() {
        return this.sku;
    }

    public String getName() {
        return this.name;
    }

    public String getStrength() {
        return this.strength;
    }

    public String getForm() {
        return this.form;
    }

    public Integer getPackSize() {
        return this.packSize;
    }

    public Integer getReorderRuleId() {
        return this.reorderRuleId;
    }

    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setNdc(String ndc) {
        this.ndc = ndc;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public void setPackSize(Integer packSize) {
        this.packSize = packSize;
    }

    public void setReorderRuleId(Integer reorderRuleId) {
        this.reorderRuleId = reorderRuleId;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
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
