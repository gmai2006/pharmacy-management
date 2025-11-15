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
@Table(name = "alert_rules")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlertRules implements Serializable {
    private static final long serialVersionUID = 176311132691380451L;

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

    /** Description: rule_json. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "rule_json")
    private Map<String, Object> ruleJson;

    /** Description: severity. */
    @Basic
    @Column(name = "severity")
    private String severity;

    /** Description: active. */
    @Basic
    @Column(name = "active")
    private Boolean active;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Transient List<AlertLogs> alertlogs;

    public AlertRules() {}

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

    public Map<String, Object> getRuleJson() {
        return this.ruleJson;
    }

    public String getSeverity() {
        return this.severity;
    }

    public Boolean getActive() {
        return this.active;
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

    public void setRuleJson(Map<String, Object> ruleJson) {
        this.ruleJson = ruleJson;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<AlertLogs> getAlertLogs() {
        return this.alertlogs;
    }

    public void setAlertLogs(List<AlertLogs> alertlogs) {
        this.alertlogs = new ArrayList<>(alertlogs);
    }
}
