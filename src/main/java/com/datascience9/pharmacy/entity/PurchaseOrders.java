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
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "purchase_orders")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseOrders implements Serializable {
    private static final long serialVersionUID = 176311132688553335L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: wholesaler_id. */
    @Basic
    @Column(name = "wholesaler_id")
    private Integer wholesalerId;

    /** Description: created_by. */
    @Basic
    @Column(columnDefinition = "UUID", name = "created_by")
    private java.util.UUID createdBy;

    /** Description: status. */
    @Basic
    @Column(name = "status")
    private String status;

    /** Description: ordered_at. */
    @Basic
    @Column(name = "ordered_at")
    private java.time.LocalDateTime orderedAt;

    /** Description: expected_arrival. */
    @Basic
    @Column(name = "expected_arrival")
    private java.util.Date expectedArrival;

    /** Description: payload. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "payload")
    private Map<String, Object> payload;

    public PurchaseOrders() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public Integer getWholesalerId() {
        return this.wholesalerId;
    }

    public java.util.UUID getCreatedBy() {
        return this.createdBy;
    }

    public String getStatus() {
        return this.status;
    }

    public java.time.LocalDateTime getOrderedAt() {
        return this.orderedAt;
    }

    public java.util.Date getExpectedArrival() {
        return this.expectedArrival;
    }

    public Map<String, Object> getPayload() {
        return this.payload;
    }

    public void setWholesalerId(Integer wholesalerId) {
        this.wholesalerId = wholesalerId;
    }

    public void setCreatedBy(java.util.UUID createdBy) {
        this.createdBy = createdBy;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderedAt(java.time.LocalDateTime orderedAt) {
        this.orderedAt = orderedAt;
    }

    public void setExpectedArrival(java.util.Date expectedArrival) {
        this.expectedArrival = expectedArrival;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }
}
