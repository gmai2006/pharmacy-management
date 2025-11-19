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
@Table(name = "reorder_rules")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReorderRules implements Serializable {
    private static final long serialVersionUID = 176351898739122L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Integer id;

    /** Description: inventory_item_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "inventory_item_id")
    private java.util.UUID inventoryItemId;

    /** Description: min_level. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "min_level")
    private Integer minLevel;

    /** Description: max_level. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "max_level")
    private Integer maxLevel;

    /** Description: preferred_wholesalers. */
    @Basic
    @Column(name = "preferred_wholesalers")
    private Integer preferredWholesalers;

    public ReorderRules() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.util.UUID getInventoryItemId() {
        return this.inventoryItemId;
    }

    public Integer getMinLevel() {
        return this.minLevel;
    }

    public Integer getMaxLevel() {
        return this.maxLevel;
    }

    public Integer getPreferredWholesalers() {
        return this.preferredWholesalers;
    }

    public void setInventoryItemId(java.util.UUID inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public void setMinLevel(Integer minLevel) {
        this.minLevel = minLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }

    public void setPreferredWholesalers(Integer preferredWholesalers) {
        this.preferredWholesalers = preferredWholesalers;
    }
}
