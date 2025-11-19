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
@Table(name = "reports")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reports implements Serializable {
    private static final long serialVersionUID = 176311132693346328L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: owner_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "owner_id")
    private java.util.UUID ownerId;

    /** Description: name. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "name")
    private String name;

    /** Description: description. */
    @Basic
    @Column(name = "description")
    private String description;

    /** Description: filters. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "filters")
    private Map<String, Object> filters;

    /** Description: schedule. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "schedule")
    private Map<String, Object> schedule;

    /** Description: last_run. */
    @Basic
    @Column(name = "last_run")
    private java.time.LocalDateTime lastRun;

    public Reports() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getOwnerId() {
        return this.ownerId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, Object> getFilters() {
        return this.filters;
    }

    public Map<String, Object> getSchedule() {
        return this.schedule;
    }

    public java.time.LocalDateTime getLastRun() {
        return this.lastRun;
    }

    public void setOwnerId(java.util.UUID ownerId) {
        this.ownerId = ownerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFilters(Map<String, Object> filters) {
        this.filters = filters;
    }

    public void setSchedule(Map<String, Object> schedule) {
        this.schedule = schedule;
    }

    public void setLastRun(java.time.LocalDateTime lastRun) {
        this.lastRun = lastRun;
    }
}
