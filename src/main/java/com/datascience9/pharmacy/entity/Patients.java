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
@Table(name = "patients")
public class Patients implements Serializable {
    private static final long serialVersionUID = 176284555404014387L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @jakarta.persistence.Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: mrn. */
    @Basic
    @Column(name = "mrn")
    private java.lang.String mrn;

    /** Description: first_name. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "first_name")
    private java.lang.String firstName;

    /** Description: last_name. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "last_name")
    private java.lang.String lastName;

    /** Description: dob. */
    @Basic
    @Column(name = "dob")
    private java.util.Date dob;

    /** Description: gender. */
    @Basic
    @Column(name = "gender")
    private java.lang.String gender;

    /** Description: contact. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "contact")
    private Map<String, Object> contact;

    /** Description: sensitive_data. */
    @Basic
    @Column(name = "sensitive_data")
    private byte[] sensitiveData;

    /** Description: is_student_record. */
    @Basic
    @Column(name = "is_student_record")
    private java.lang.Boolean isStudentRecord;

    /** Description: preferred_language. */
    @Basic
    @Column(name = "preferred_language")
    private java.lang.String preferredLanguage;

    /** Description: accessibility_preferences. */
    @Basic
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb", name = "accessibility_preferences")
    private Map<String, Object> accessibilityPreferences;

    /** Description: created_at. */
    @Basic
    @Column(name = "created_at")
    private java.sql.Timestamp createdAt;

    @Transient List<PdmpQueries> pdmpqueries;
    @Transient List<EfaxIncoming> efaxincoming;
    @Transient List<PatientAliases> patientaliases;
    @Transient List<AccessLogs> accesslogs;
    @Transient List<EfaxJobs> efaxjobs;
    @Transient List<Prescriptions> prescriptions;
    @Transient List<AlertLogs> alertlogs;
    @Transient List<ConsentRecords> consentrecords;
    @Transient List<PosTransactions> postransactions;

    public Patients() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.lang.String getMrn() {
        return this.mrn;
    }

    public java.lang.String getFirstName() {
        return this.firstName;
    }

    public java.lang.String getLastName() {
        return this.lastName;
    }

    public java.util.Date getDob() {
        return this.dob;
    }

    public java.lang.String getGender() {
        return this.gender;
    }

    public java.util.Map<String, Object> getContact() {
        return this.contact;
    }

    public byte[] getSensitiveData() {
        return this.sensitiveData;
    }

    public java.lang.Boolean getIsStudentRecord() {
        return this.isStudentRecord;
    }

    public java.lang.String getPreferredLanguage() {
        return this.preferredLanguage;
    }

    public java.util.Map<String, Object> getAccessibilityPreferences() {
        return this.accessibilityPreferences;
    }

    public java.sql.Timestamp getCreatedAt() {
        return this.createdAt;
    }

    public void setMrn(java.lang.String mrn) {
        this.mrn = mrn;
    }

    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    public void setDob(java.util.Date dob) {
        this.dob = dob;
    }

    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }

    public void setContact(java.util.Map<String, Object> contact) {
        this.contact = contact;
    }

    public void setSensitiveData(byte[] sensitiveData) {
        this.sensitiveData = sensitiveData;
    }

    public void setIsStudentRecord(java.lang.Boolean isStudentRecord) {
        this.isStudentRecord = isStudentRecord;
    }

    public void setPreferredLanguage(java.lang.String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public void setAccessibilityPreferences(
            java.util.Map<String, Object> accessibilityPreferences) {
        this.accessibilityPreferences = accessibilityPreferences;
    }

    public void setCreatedAt(java.sql.Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<PdmpQueries> getPdmpQueries() {
        return this.pdmpqueries;
    }

    public List<EfaxIncoming> getEfaxIncoming() {
        return this.efaxincoming;
    }

    public List<PatientAliases> getPatientAliases() {
        return this.patientaliases;
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

    public List<AlertLogs> getAlertLogs() {
        return this.alertlogs;
    }

    public List<ConsentRecords> getConsentRecords() {
        return this.consentrecords;
    }

    public List<PosTransactions> getPosTransactions() {
        return this.postransactions;
    }

    public void setPdmpQueries(List<PdmpQueries> pdmpqueries) {
        this.pdmpqueries = new ArrayList<>(pdmpqueries);
    }

    public void setEfaxIncoming(List<EfaxIncoming> efaxincoming) {
        this.efaxincoming = new ArrayList<>(efaxincoming);
    }

    public void setPatientAliases(List<PatientAliases> patientaliases) {
        this.patientaliases = new ArrayList<>(patientaliases);
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

    public void setAlertLogs(List<AlertLogs> alertlogs) {
        this.alertlogs = new ArrayList<>(alertlogs);
    }

    public void setConsentRecords(List<ConsentRecords> consentrecords) {
        this.consentrecords = new ArrayList<>(consentrecords);
    }

    public void setPosTransactions(List<PosTransactions> postransactions) {
        this.postransactions = new ArrayList<>(postransactions);
    }
}
