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
@Table(name = "prescriptions")
public class Prescriptions implements Serializable {
    private static final long serialVersionUID = 176284555405913344L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: patient_id. */
    @Basic
    @Column(columnDefinition = "UUID", name = "patient_id")
    private java.util.UUID patientId;

    /** Description: prescriber_name. */
    @Basic
    @Column(name = "prescriber_name")
    private java.lang.String prescriberName;

    /** Description: prescriber_dea. */
    @Basic
    @Column(name = "prescriber_dea")
    private java.lang.String prescriberDea;

    /** Description: issue_date. */
    @Basic
    @Column(name = "issue_date")
    private java.sql.Timestamp issueDate;

    /** Description: status. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "status")
    private java.lang.String status;

    /** Description: priority. */
    @Basic
    @Column(name = "priority")
    private java.lang.String priority;

    /** Description: notes. */
    @Basic
    @Column(name = "notes")
    private java.lang.String notes;

    /** Description: metadata. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "metadata")
    private Map<String, Object> metadata;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Transient List<PdmpQueries> pdmpqueries;
    @Transient List<PrescriptionAudit> prescriptionaudit;
    @Transient List<EfaxIncoming> efaxincoming;
    @Transient List<Claims> claims;
    @Transient List<PrescriptionItems> prescriptionitems;
    @Transient List<EfaxJobs> efaxjobs;
    @Transient List<AlertLogs> alertlogs;
    @Transient List<PosTransactions> postransactions;
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

    public java.lang.String getPrescriberName() {
        return this.prescriberName;
    }

    public java.lang.String getPrescriberDea() {
        return this.prescriberDea;
    }

    public java.sql.Timestamp getIssueDate() {
        return this.issueDate;
    }

    public java.lang.String getStatus() {
        return this.status;
    }

    public java.lang.String getPriority() {
        return this.priority;
    }

    public java.lang.String getNotes() {
        return this.notes;
    }

    public java.util.Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setPatientId(java.util.UUID patientId) {
        this.patientId = patientId;
    }

    public void setPrescriberName(java.lang.String prescriberName) {
        this.prescriberName = prescriberName;
    }

    public void setPrescriberDea(java.lang.String prescriberDea) {
        this.prescriberDea = prescriberDea;
    }

    public void setIssueDate(java.sql.Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public void setPriority(java.lang.String priority) {
        this.priority = priority;
    }

    public void setNotes(java.lang.String notes) {
        this.notes = notes;
    }

    public void setMetadata(java.util.Map<String, Object> metadata) {
        this.metadata = metadata;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<PdmpQueries> getPdmpQueries() {
        return this.pdmpqueries;
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

    public List<AlertLogs> getAlertLogs() {
        return this.alertlogs;
    }

    public List<PosTransactions> getPosTransactions() {
        return this.postransactions;
    }

    public List<PrescriptionTransfers> getPrescriptionTransfers() {
        return this.prescriptiontransfers;
    }

    public List<AwpReclaims> getAwpReclaims() {
        return this.awpreclaims;
    }

    public void setPdmpQueries(List<PdmpQueries> pdmpqueries) {
        this.pdmpqueries = new ArrayList<>(pdmpqueries);
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

    public void setAlertLogs(List<AlertLogs> alertlogs) {
        this.alertlogs = new ArrayList<>(alertlogs);
    }

    public void setPosTransactions(List<PosTransactions> postransactions) {
        this.postransactions = new ArrayList<>(postransactions);
    }

    public void setPrescriptionTransfers(List<PrescriptionTransfers> prescriptiontransfers) {
        this.prescriptiontransfers = new ArrayList<>(prescriptiontransfers);
    }

    public void setAwpReclaims(List<AwpReclaims> awpreclaims) {
        this.awpreclaims = new ArrayList<>(awpreclaims);
    }
}
