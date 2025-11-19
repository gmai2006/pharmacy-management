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

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "prescriptions")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Prescriptions implements Serializable {
    private static final long serialVersionUID = 176351898739545404L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: patient_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "patient_id")
    private java.util.UUID patientId;

    /** Description: prescriber_name. */
    @Basic
    @Column(name = "prescriber_name")
    private String prescriberName;

    /** Description: prescriber_dea. */
    @Basic
    @Column(name = "prescriber_dea")
    private String prescriberDea;

    /** Description: issue_date. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "issue_date")
    private java.time.LocalDateTime issueDate;

    /** Description: status. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "status")
    private String status;

    /** Description: workflow_step_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "workflow_step_id")
    private Integer workflowStepId;

    /** Description: priority. */
    @Basic
    @Column(name = "priority")
    private String priority;

    /** Description: notes. */
    @Basic
    @Column(name = "notes")
    private String notes;

    /** Description: metadata. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "metadata")
    private Map<String, Object> metadata;

    /** Description: created_at. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    /** Description: queue_name. */
    @Basic
    @Column(name = "queue_name")
    private String queueName;

    /** Description: assigned_to. */
    @Basic
    @Column(columnDefinition = "UUID", name = "assigned_to")
    private java.util.UUID assignedTo;

    /** Description: last_status_update. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "last_status_update")
    private java.time.LocalDateTime lastStatusUpdate;

    /** Description: estimated_ready_time. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "estimated_ready_time")
    private java.time.LocalDateTime estimatedReadyTime;

    /** Description: pickup_time. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "pickup_time")
    private java.time.LocalDateTime pickupTime;

    /** Description: completion_time. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "completion_time")
    private java.time.LocalDateTime completionTime;

    @Transient List<PrescriptionClaims> prescriptionclaims;
    @Transient List<PdmpQueries> pdmpqueries;
    @Transient List<PrescriptionCopays> prescriptioncopays;
    @Transient List<PrescriptionAudit> prescriptionaudit;
    @Transient List<EfaxIncoming> efaxincoming;
    @Transient List<Claims> claims;
    @Transient List<PrescriptionItems> prescriptionitems;
    @Transient List<EfaxJobs> efaxjobs;
    @Transient List<PosTransactions> postransactions;
    @Transient List<PrescriptionWorkflowLogs> prescriptionworkflowlogs;
    @Transient List<PrescriptionTransfers> prescriptiontransfers;
    @Transient List<AwpReclaims> awpreclaims;

    public Prescriptions() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getPatientId() {
        return this.patientId;
    }

    public String getPrescriberName() {
        return this.prescriberName;
    }

    public String getPrescriberDea() {
        return this.prescriberDea;
    }

    public java.time.LocalDateTime getIssueDate() {
        return this.issueDate;
    }

    public String getStatus() {
        return this.status;
    }

    public Integer getWorkflowStepId() {
        return this.workflowStepId;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getNotes() {
        return this.notes;
    }

    public Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public String getQueueName() {
        return this.queueName;
    }

    public java.util.UUID getAssignedTo() {
        return this.assignedTo;
    }

    public java.time.LocalDateTime getLastStatusUpdate() {
        return this.lastStatusUpdate;
    }

    public java.time.LocalDateTime getEstimatedReadyTime() {
        return this.estimatedReadyTime;
    }

    public java.time.LocalDateTime getPickupTime() {
        return this.pickupTime;
    }

    public java.time.LocalDateTime getCompletionTime() {
        return this.completionTime;
    }

    public void setPatientId(java.util.UUID patientId) {
        this.patientId = patientId;
    }

    public void setPrescriberName(String prescriberName) {
        this.prescriberName = prescriberName;
    }

    public void setPrescriberDea(String prescriberDea) {
        this.prescriberDea = prescriberDea;
    }

    public void setIssueDate(java.time.LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setWorkflowStepId(Integer workflowStepId) {
        this.workflowStepId = workflowStepId;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setMetadata(Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public void setAssignedTo(java.util.UUID assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setLastStatusUpdate(java.time.LocalDateTime lastStatusUpdate) {
        this.lastStatusUpdate = lastStatusUpdate;
    }

    public void setEstimatedReadyTime(java.time.LocalDateTime estimatedReadyTime) {
        this.estimatedReadyTime = estimatedReadyTime;
    }

    public void setPickupTime(java.time.LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public void setCompletionTime(java.time.LocalDateTime completionTime) {
        this.completionTime = completionTime;
    }

    public List<PrescriptionClaims> getPrescriptionClaims() {
        return this.prescriptionclaims;
    }

    public List<PdmpQueries> getPdmpQueries() {
        return this.pdmpqueries;
    }

    public List<PrescriptionCopays> getPrescriptionCopays() {
        return this.prescriptioncopays;
    }

    public List<PrescriptionAudit> getPrescriptionAudit() {
        return this.prescriptionaudit;
    }

    public List<EfaxIncoming> getEfaxIncoming() {
        return this.efaxincoming;
    }

    public List<Claims> getClaims() {
        return this.claims;
    }

    public List<PrescriptionItems> getPrescriptionItems() {
        return this.prescriptionitems;
    }

    public List<EfaxJobs> getEfaxJobs() {
        return this.efaxjobs;
    }

    public List<PosTransactions> getPosTransactions() {
        return this.postransactions;
    }

    public List<PrescriptionWorkflowLogs> getPrescriptionWorkflowLogs() {
        return this.prescriptionworkflowlogs;
    }

    public List<PrescriptionTransfers> getPrescriptionTransfers() {
        return this.prescriptiontransfers;
    }

    public List<AwpReclaims> getAwpReclaims() {
        return this.awpreclaims;
    }

    public void setPrescriptionClaims(List<PrescriptionClaims> prescriptionclaims) {
        this.prescriptionclaims = new ArrayList<>(prescriptionclaims);
    }

    public void setPdmpQueries(List<PdmpQueries> pdmpqueries) {
        this.pdmpqueries = new ArrayList<>(pdmpqueries);
    }

    public void setPrescriptionCopays(List<PrescriptionCopays> prescriptioncopays) {
        this.prescriptioncopays = new ArrayList<>(prescriptioncopays);
    }

    public void setPrescriptionAudit(List<PrescriptionAudit> prescriptionaudit) {
        this.prescriptionaudit = new ArrayList<>(prescriptionaudit);
    }

    public void setEfaxIncoming(List<EfaxIncoming> efaxincoming) {
        this.efaxincoming = new ArrayList<>(efaxincoming);
    }

    public void setClaims(List<Claims> claims) {
        this.claims = new ArrayList<>(claims);
    }

    public void setPrescriptionItems(List<PrescriptionItems> prescriptionitems) {
        this.prescriptionitems = new ArrayList<>(prescriptionitems);
    }

    public void setEfaxJobs(List<EfaxJobs> efaxjobs) {
        this.efaxjobs = new ArrayList<>(efaxjobs);
    }

    public void setPosTransactions(List<PosTransactions> postransactions) {
        this.postransactions = new ArrayList<>(postransactions);
    }

    public void setPrescriptionWorkflowLogs(
            List<PrescriptionWorkflowLogs> prescriptionworkflowlogs) {
        this.prescriptionworkflowlogs = new ArrayList<>(prescriptionworkflowlogs);
    }

    public void setPrescriptionTransfers(List<PrescriptionTransfers> prescriptiontransfers) {
        this.prescriptiontransfers = new ArrayList<>(prescriptiontransfers);
    }

    public void setAwpReclaims(List<AwpReclaims> awpreclaims) {
        this.awpreclaims = new ArrayList<>(awpreclaims);
    }
}
