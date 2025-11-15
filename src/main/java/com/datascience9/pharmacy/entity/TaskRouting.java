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
@Table(name = "task_routing")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TaskRouting implements Serializable {
    private static final long serialVersionUID = 176311132690158143L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Integer id;

    /** Description: queue_id. */
    @Basic
    @Column(name = "queue_id")
    private Integer queueId;

    /** Description: rule_order. */
    @Basic
    @Column(name = "rule_order")
    private Integer ruleOrder;

    /** Description: rule. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "rule")
    private Map<String, Object> rule;

    public TaskRouting() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQueueId() {
        return this.queueId;
    }

    public Integer getRuleOrder() {
        return this.ruleOrder;
    }

    public Map<String, Object> getRule() {
        return this.rule;
    }

    public void setQueueId(Integer queueId) {
        this.queueId = queueId;
    }

    public void setRuleOrder(Integer ruleOrder) {
        this.ruleOrder = ruleOrder;
    }

    public void setRule(Map<String, Object> rule) {
        this.rule = rule;
    }
}
