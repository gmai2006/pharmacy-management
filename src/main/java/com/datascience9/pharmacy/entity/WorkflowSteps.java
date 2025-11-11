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
import java.util.Map;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "workflow_steps")
public class WorkflowSteps implements Serializable {
    private static final long serialVersionUID = 176284555406838232L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(name = "id")
    private java.lang.Integer id;

    /** Description: workflow_id. */
    @Basic
    @Column(name = "workflow_id")
    private java.lang.Integer workflowId;

    /** Description: step_key. */
    @Basic
    @Column(name = "step_key")
    private java.lang.String stepKey;

    /** Description: display_name. */
    @Basic
    @Column(name = "display_name")
    private java.lang.String displayName;

    /** Description: config. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "config")
    private Map<String, Object> config;

    @Transient List<Tasks> tasks;

    public WorkflowSteps() {}

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.Integer getWorkflowId() {
        return this.workflowId;
    }

    public java.lang.String getStepKey() {
        return this.stepKey;
    }

    public java.lang.String getDisplayName() {
        return this.displayName;
    }

    public java.util.Map<String, Object> getConfig() {
        return this.config;
    }

    public void setWorkflowId(java.lang.Integer workflowId) {
        this.workflowId = workflowId;
    }

    public void setStepKey(java.lang.String stepKey) {
        this.stepKey = stepKey;
    }

    public void setDisplayName(java.lang.String displayName) {
        this.displayName = displayName;
    }

    public void setConfig(java.util.Map<String, Object> config) {
        this.config = config;
    }

    public List<Tasks> getTasks() {
        return this.tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }
}
