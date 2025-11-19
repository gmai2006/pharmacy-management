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
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "dir_fees")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DirFees implements Serializable {
    private static final long serialVersionUID = 176351898742082173L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Long id;

    /** Description: claim_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(columnDefinition = "UUID", name = "claim_id")
    private java.util.UUID claimId;

    /** Description: amount. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "amount")
    private java.math.BigDecimal amount;

    /** Description: reason. */
    @Basic
    @Column(name = "reason")
    private String reason;

    /** Description: recorded_at. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "recorded_at")
    private java.time.LocalDateTime recordedAt;

    /** Description: reconciliation_period. */
    @Basic
    @Column(name = "reconciliation_period")
    private String reconciliationPeriod;

    /** Description: payer_name. */
    @Basic
    @Column(name = "payer_name")
    private String payerName;

    /** Description: metadata. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "metadata")
    private Map<String, Object> metadata;

    public DirFees() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.util.UUID getClaimId() {
        return this.claimId;
    }

    public java.math.BigDecimal getAmount() {
        return this.amount;
    }

    public String getReason() {
        return this.reason;
    }

    public java.time.LocalDateTime getRecordedAt() {
        return this.recordedAt;
    }

    public String getReconciliationPeriod() {
        return this.reconciliationPeriod;
    }

    public String getPayerName() {
        return this.payerName;
    }

    public Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public void setClaimId(java.util.UUID claimId) {
        this.claimId = claimId;
    }

    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setRecordedAt(java.time.LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }

    public void setReconciliationPeriod(String reconciliationPeriod) {
        this.reconciliationPeriod = reconciliationPeriod;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
