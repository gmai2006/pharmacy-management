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

/** Auto generated from a schema generated on $date$ */
@Entity
@Table(name = "device_fingerprints")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceFingerprints implements Serializable {
    private static final long serialVersionUID = 176353437009887463L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: station_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "station_id")
    private Integer stationId;

    /** Description: fingerprint_hash. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "fingerprint_hash")
    private String fingerprintHash;

    /** Description: browser_user_agent. */
    @Basic
    @Column(name = "browser_user_agent")
    private String browserUserAgent;

    /** Description: screen_resolution. */
    @Basic
    @Column(name = "screen_resolution")
    private String screenResolution;

    /** Description: timezone. */
    @Basic
    @Column(name = "timezone")
    private String timezone;

    /** Description: language. */
    @Basic
    @Column(name = "language")
    private String language;

    /** Description: canvas_fingerprint. */
    @Basic
    @Column(name = "canvas_fingerprint")
    private String canvasFingerprint;

    /** Description: webgl_fingerprint. */
    @Basic
    @Column(name = "webgl_fingerprint")
    private String webglFingerprint;

    /** Description: department. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "department")
    private String department;

    /** Description: location. */
    @Basic
    @Column(name = "location")
    private String location;

    /** Description: assigned_date. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "assigned_date")
    private java.time.LocalDateTime assignedDate;

    /** Description: last_seen. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "last_seen")
    private java.time.LocalDateTime lastSeen;

    /** Description: is_active. */
    @Basic
    @Column(name = "is_active")
    private Boolean isActive;

    /** Description: access_count. */
    @Basic
    @Column(name = "access_count")
    private Integer accessCount;

    public DeviceFingerprints() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public Integer getStationId() {
        return this.stationId;
    }

    public String getFingerprintHash() {
        return this.fingerprintHash;
    }

    public String getBrowserUserAgent() {
        return this.browserUserAgent;
    }

    public String getScreenResolution() {
        return this.screenResolution;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getCanvasFingerprint() {
        return this.canvasFingerprint;
    }

    public String getWebglFingerprint() {
        return this.webglFingerprint;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getLocation() {
        return this.location;
    }

    public java.time.LocalDateTime getAssignedDate() {
        return this.assignedDate;
    }

    public java.time.LocalDateTime getLastSeen() {
        return this.lastSeen;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public Integer getAccessCount() {
        return this.accessCount;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public void setFingerprintHash(String fingerprintHash) {
        this.fingerprintHash = fingerprintHash;
    }

    public void setBrowserUserAgent(String browserUserAgent) {
        this.browserUserAgent = browserUserAgent;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCanvasFingerprint(String canvasFingerprint) {
        this.canvasFingerprint = canvasFingerprint;
    }

    public void setWebglFingerprint(String webglFingerprint) {
        this.webglFingerprint = webglFingerprint;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAssignedDate(java.time.LocalDateTime assignedDate) {
        this.assignedDate = assignedDate;
    }

    public void setLastSeen(java.time.LocalDateTime lastSeen) {
        this.lastSeen = lastSeen;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public void setAccessCount(Integer accessCount) {
        this.accessCount = accessCount;
    }
}
