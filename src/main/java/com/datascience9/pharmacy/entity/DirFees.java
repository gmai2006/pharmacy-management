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
@Table(name = "dir_fees")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DirFees implements Serializable {
    private static final long serialVersionUID = 176311132690942859L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Long id;

    /** Description: claim_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "claim_id")
    private java.util.UUID claimId;

    /** Description: amount. */
    @Basic
    @Column(name = "amount")
    private java.math.BigDecimal amount;

    /** Description: reason. */
    @Basic
    @Column(name = "reason")
    private String reason;

    /** Description: recorded_at. */
    @Basic
    @Column(name = "recorded_at")
    private java.time.LocalDateTime recordedAt;

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
}
