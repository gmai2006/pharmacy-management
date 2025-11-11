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
import java.util.ArrayList;
import java.util.List;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "roles")
public class Roles implements Serializable {
    private static final long serialVersionUID = 176284555402158910L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(name = "id")
    private java.lang.Integer id;

    /** Description: name. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "name")
    private java.lang.String name;

    /** Description: description. */
    @Basic
    @Column(name = "description")
    private java.lang.String description;

    @Transient List<Users> users;

    public Roles() {}

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public java.lang.String getDescription() {
        return this.description;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public List<Users> getUsers() {
        return this.users;
    }

    public void setUsers(List<Users> users) {
        this.users = new ArrayList<>(users);
    }
}
