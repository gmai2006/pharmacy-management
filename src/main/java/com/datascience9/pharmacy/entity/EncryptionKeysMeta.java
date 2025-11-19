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
@Table(name = "encryption_keys_meta")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EncryptionKeysMeta implements Serializable {
    private static final long serialVersionUID = 176311132693729914L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Integer id;

    /** Description: key_id. */
    @Basic
    @Column(name = "key_id")
    private String keyId;

    /** Description: purpose. */
    @Basic
    @Column(name = "purpose")
    private String purpose;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    /** Description: rotated_at. */
    @Basic
    @Column(name = "rotated_at")
    private java.time.LocalDateTime rotatedAt;

    /** Description: metadata. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "metadata")
    private Map<String, Object> metadata;

    public EncryptionKeysMeta() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getPurpose() {
        return this.purpose;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public java.time.LocalDateTime getRotatedAt() {
        return this.rotatedAt;
    }

    public Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setRotatedAt(java.time.LocalDateTime rotatedAt) {
        this.rotatedAt = rotatedAt;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
