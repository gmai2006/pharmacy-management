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
@Table(name = "alert_logs")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AlertLogs implements Serializable {
    private static final long serialVersionUID = 176311132691555709L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Long id;

    /** Description: alert_rule_id. */
    @Basic
    @Column(name = "alert_rule_id")
    private Integer alertRuleId;

    /** Description: prescription_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "prescription_id")
    private java.util.UUID prescriptionId;

    /** Description: patient_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "patient_id")
    private java.util.UUID patientId;

    /** Description: triggered_by. */
    @Basic
    @Column(columnDefinition = "UUID", name = "triggered_by")
    private java.util.UUID triggeredBy;

    /** Description: context. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "context")
    private Map<String, Object> context;

    /** Description: action_taken. */
    @Basic
    @Column(name = "action_taken")
    private String actionTaken;

    /** Description: override_reason. */
    @Basic
    @Column(name = "override_reason")
    private String overrideReason;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    public AlertLogs() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAlertRuleId() {
        return this.alertRuleId;
    }

    public java.util.UUID getPrescriptionId() {
        return this.prescriptionId;
    }

    public java.util.UUID getPatientId() {
        return this.patientId;
    }

    public java.util.UUID getTriggeredBy() {
        return this.triggeredBy;
    }

    public Map<String, Object> getContext() {
        return this.context;
    }

    public String getActionTaken() {
        return this.actionTaken;
    }

    public String getOverrideReason() {
        return this.overrideReason;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setAlertRuleId(Integer alertRuleId) {
        this.alertRuleId = alertRuleId;
    }

    public void setPrescriptionId(java.util.UUID prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setPatientId(java.util.UUID patientId) {
        this.patientId = patientId;
    }

    public void setTriggeredBy(java.util.UUID triggeredBy) {
        this.triggeredBy = triggeredBy;
    }

    public void setContext(Map<String, Object> context) {
        this.context = context;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    public void setOverrideReason(String overrideReason) {
        this.overrideReason = overrideReason;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
