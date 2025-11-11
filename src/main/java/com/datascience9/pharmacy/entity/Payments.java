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
@Table(name = "payments")
public class Payments implements Serializable {
    private static final long serialVersionUID = 17628455540782553L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: pos_transaction_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "pos_transaction_id")
    private java.util.UUID posTransactionId;

    /** Description: payment_method. */
    @Basic
    @Column(name = "payment_method")
    private java.lang.String paymentMethod;

    /** Description: amount. */
    @Basic
    @Column(name = "amount")
    private java.math.BigDecimal amount;

    /** Description: payment_meta. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "payment_meta")
    private Map<String, Object> paymentMeta;

    public Payments() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getPosTransactionId() {
        return this.posTransactionId;
    }

    public java.lang.String getPaymentMethod() {
        return this.paymentMethod;
    }

    public java.math.BigDecimal getAmount() {
        return this.amount;
    }

    public java.util.Map<String, Object> getPaymentMeta() {
        return this.paymentMeta;
    }

    public void setPosTransactionId(java.util.UUID posTransactionId) {
        this.posTransactionId = posTransactionId;
    }

    public void setPaymentMethod(java.lang.String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }

    public void setPaymentMeta(java.util.Map<String, Object> paymentMeta) {
        this.paymentMeta = paymentMeta;
    }
}
