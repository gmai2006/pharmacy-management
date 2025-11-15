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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "workflows")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Workflows implements Serializable {
    private static final long serialVersionUID = 176311132689578984L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Integer id;

    /** Description: name. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "name")
    private String name;

    /** Description: description. */
    @Basic
    @Column(name = "description")
    private String description;

    /** Description: config. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "config")
    private Map<String, Object> config;

    /** Description: created_by. */
    @Basic
    @Column(columnDefinition = "UUID", name = "created_by")
    private java.util.UUID createdBy;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Transient List<WorkflowSteps> workflowsteps;
    @Transient List<Tasks> tasks;

    public Workflows() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, Object> getConfig() {
        return this.config;
    }

    public java.util.UUID getCreatedBy() {
        return this.createdBy;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setConfig(Map<String, Object> config) {
        this.config = config;
    }

    public void setCreatedBy(java.util.UUID createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<WorkflowSteps> getWorkflowSteps() {
        return this.workflowsteps;
    }

    public List<Tasks> getTasks() {
        return this.tasks;
    }

    public void setWorkflowSteps(List<WorkflowSteps> workflowsteps) {
        this.workflowsteps = new ArrayList<>(workflowsteps);
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }
}
