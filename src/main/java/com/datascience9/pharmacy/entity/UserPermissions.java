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
@Table(name = "user_permissions")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserPermissions implements Serializable {
    private static final long serialVersionUID = 176311132686620515L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Integer id;

    /** Description: user_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "user_id")
    private java.util.UUID userId;

    /** Description: permission_key. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "permission_key")
    private String permissionKey;

    /** Description: granted. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "granted")
    private Boolean granted;

    /** Description: granted_at. */
    @Basic
    @Column(name = "granted_at")
    private java.time.LocalDateTime grantedAt;

    public UserPermissions() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.util.UUID getUserId() {
        return this.userId;
    }

    public String getPermissionKey() {
        return this.permissionKey;
    }

    public Boolean getGranted() {
        return this.granted;
    }

    public java.time.LocalDateTime getGrantedAt() {
        return this.grantedAt;
    }

    public void setUserId(java.util.UUID userId) {
        this.userId = userId;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public void setGranted(Boolean granted) {
        this.granted = granted;
    }

    public void setGrantedAt(java.time.LocalDateTime grantedAt) {
        this.grantedAt = grantedAt;
    }
}
