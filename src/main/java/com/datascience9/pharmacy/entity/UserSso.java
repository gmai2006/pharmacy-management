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
import java.io.Serializable;
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "user_sso")
public class UserSso implements Serializable {
    private static final long serialVersionUID = 176294189240986533L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: user_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(columnDefinition = "UUID", name = "user_id")
    private java.util.UUID userId;

    /** Description: provider. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "provider")
    private String provider;

    /** Description: external_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "external_id")
    private String externalId;

    /** Description: metadata. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "metadata")
    private Map<String, Object> metadata;

    public UserSso() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getUserId() {
        return this.userId;
    }

    public String getProvider() {
        return this.provider;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public void setUserId(java.util.UUID userId) {
        this.userId = userId;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }
}
