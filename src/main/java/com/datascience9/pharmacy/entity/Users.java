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

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users implements Serializable {
    private static final long serialVersionUID = 176311132686045706L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: username. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "username")
    private String username;

    /** Description: display_name. */
    @Basic
    @Column(name = "display_name")
    private String displayName;

    /** Description: email. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "email")
    private String email;

    /** Description: role_id. */
    @Basic
    @Column(name = "role_id")
    private Integer roleId;

    /** Description: is_active. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "is_active")
    private Boolean isActive;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    /** Description: last_login_at. */
    @Basic
    @Column(name = "last_login_at")
    private java.time.LocalDateTime lastLoginAt;

    @Transient List<Reports> reports;
    @Transient List<PdmpQueries> pdmpqueries;
    @Transient List<UserPermissions> userpermissions;
    @Transient List<PurchaseOrders> purchaseorders;
    @Transient List<Pharmacists> pharmacists;
    @Transient List<PrescriptionAudit> prescriptionaudit;
    @Transient List<Workflows> workflows;
    @Transient List<PrescriptionWorkflowLogs> prescriptionworkflowlogs;
    @Transient List<EfaxIncoming> efaxincoming;
    @Transient List<UserSso> usersso;
    @Transient List<AccessLogs> accesslogs;
    @Transient List<EfaxJobs> efaxjobs;
    @Transient List<Prescriptions> prescriptions;
    @Transient List<BarcodeLabels> barcodelabels;
    @Transient List<AlertLogs> alertlogs;
    @Transient List<ConsentRecords> consentrecords;
    @Transient List<Tasks> tasks;
    @Transient List<PosSignatures> possignatures;

    public Users() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getEmail() {
        return this.email;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public java.time.LocalDateTime getLastLoginAt() {
        return this.lastLoginAt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastLoginAt(java.time.LocalDateTime lastLoginAt) {
        this.lastLoginAt = lastLoginAt;
    }

    public List<Reports> getReports() {
        return this.reports;
    }

    public List<PdmpQueries> getPdmpQueries() {
        return this.pdmpqueries;
    }

    public List<UserPermissions> getUserPermissions() {
        return this.userpermissions;
    }

    public List<PurchaseOrders> getPurchaseOrders() {
        return this.purchaseorders;
    }

    public List<Pharmacists> getPharmacists() {
        return this.pharmacists;
    }

    public List<PrescriptionAudit> getPrescriptionAudit() {
        return this.prescriptionaudit;
    }

    public List<Workflows> getWorkflows() {
        return this.workflows;
    }

    public List<PrescriptionWorkflowLogs> getPrescriptionWorkflowLogs() {
        return this.prescriptionworkflowlogs;
    }

    public List<EfaxIncoming> getEfaxIncoming() {
        return this.efaxincoming;
    }

    public List<UserSso> getUserSso() {
        return this.usersso;
    }

    public List<AccessLogs> getAccessLogs() {
        return this.accesslogs;
    }

    public List<EfaxJobs> getEfaxJobs() {
        return this.efaxjobs;
    }

    public List<Prescriptions> getPrescriptions() {
        return this.prescriptions;
    }

    public List<BarcodeLabels> getBarcodeLabels() {
        return this.barcodelabels;
    }

    public List<AlertLogs> getAlertLogs() {
        return this.alertlogs;
    }

    public List<ConsentRecords> getConsentRecords() {
        return this.consentrecords;
    }

    public List<Tasks> getTasks() {
        return this.tasks;
    }

    public List<PosSignatures> getPosSignatures() {
        return this.possignatures;
    }

    public void setReports(List<Reports> reports) {
        this.reports = new ArrayList<>(reports);
    }

    public void setPdmpQueries(List<PdmpQueries> pdmpqueries) {
        this.pdmpqueries = new ArrayList<>(pdmpqueries);
    }

    public void setUserPermissions(List<UserPermissions> userpermissions) {
        this.userpermissions = new ArrayList<>(userpermissions);
    }

    public void setPurchaseOrders(List<PurchaseOrders> purchaseorders) {
        this.purchaseorders = new ArrayList<>(purchaseorders);
    }

    public void setPharmacists(List<Pharmacists> pharmacists) {
        this.pharmacists = new ArrayList<>(pharmacists);
    }

    public void setPrescriptionAudit(List<PrescriptionAudit> prescriptionaudit) {
        this.prescriptionaudit = new ArrayList<>(prescriptionaudit);
    }

    public void setWorkflows(List<Workflows> workflows) {
        this.workflows = new ArrayList<>(workflows);
    }

    public void setPrescriptionWorkflowLogs(
            List<PrescriptionWorkflowLogs> prescriptionworkflowlogs) {
        this.prescriptionworkflowlogs = new ArrayList<>(prescriptionworkflowlogs);
    }

    public void setEfaxIncoming(List<EfaxIncoming> efaxincoming) {
        this.efaxincoming = new ArrayList<>(efaxincoming);
    }

    public void setUserSso(List<UserSso> usersso) {
        this.usersso = new ArrayList<>(usersso);
    }

    public void setAccessLogs(List<AccessLogs> accesslogs) {
        this.accesslogs = new ArrayList<>(accesslogs);
    }

    public void setEfaxJobs(List<EfaxJobs> efaxjobs) {
        this.efaxjobs = new ArrayList<>(efaxjobs);
    }

    public void setPrescriptions(List<Prescriptions> prescriptions) {
        this.prescriptions = new ArrayList<>(prescriptions);
    }

    public void setBarcodeLabels(List<BarcodeLabels> barcodelabels) {
        this.barcodelabels = new ArrayList<>(barcodelabels);
    }

    public void setAlertLogs(List<AlertLogs> alertlogs) {
        this.alertlogs = new ArrayList<>(alertlogs);
    }

    public void setConsentRecords(List<ConsentRecords> consentrecords) {
        this.consentrecords = new ArrayList<>(consentrecords);
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    public void setPosSignatures(List<PosSignatures> possignatures) {
        this.possignatures = new ArrayList<>(possignatures);
    }
}
