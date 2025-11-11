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
@Table(name = "encryption_keys_meta")
public class EncryptionKeysMeta implements Serializable {
    private static final long serialVersionUID = 176284555409547199L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(name = "id")
    private java.lang.Integer id;

    /** Description: key_id. */
    @Basic
    @Column(name = "key_id")
    private java.lang.String keyId;

    /** Description: purpose. */
    @Basic
    @Column(name = "purpose")
    private java.lang.String purpose;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    /** Description: rotated_at. */
    @Basic
    @Column(name = "rotated_at")
    private java.sql.Timestamp rotatedAt;

    /** Description: metadata. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "metadata")
    private Map<String, Object> metadata;

    public EncryptionKeysMeta() {}

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.String getKeyId() {
        return this.keyId;
    }

    public java.lang.String getPurpose() {
        return this.purpose;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public java.sql.Timestamp getRotatedAt() {
        return this.rotatedAt;
    }

    public java.util.Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public void setKeyId(java.lang.String keyId) {
        this.keyId = keyId;
    }

    public void setPurpose(java.lang.String purpose) {
        this.purpose = purpose;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setRotatedAt(java.sql.Timestamp rotatedAt) {
        this.rotatedAt = rotatedAt;
    }

    public void setMetadata(java.util.Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
