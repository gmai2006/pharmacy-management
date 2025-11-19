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
@Table(name = "fingerprint_history")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FingerprintHistory implements Serializable {
    private static final long serialVersionUID = 176353437009944749L;

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

    /** Description: old_fingerprint_hash. */
    @Basic
    @Column(name = "old_fingerprint_hash")
    private String oldFingerprintHash;

    /** Description: new_fingerprint_hash. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "new_fingerprint_hash")
    private String newFingerprintHash;

    /** Description: change_date. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "change_date")
    private java.time.LocalDateTime changeDate;

    /** Description: reason. */
    @Basic
    @Column(name = "reason")
    private String reason;

    /** Description: similarity_percentage. */
    @Basic
    @Column(name = "similarity_percentage")
    private java.math.BigDecimal similarityPercentage;

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

    /** Description: notes. */
    @Basic
    @Column(name = "notes")
    private String notes;

    /** Description: verified_by. */
    @Basic
    @Column(name = "verified_by")
    private String verifiedBy;

    public FingerprintHistory() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public Integer getStationId() {
        return this.stationId;
    }

    public String getOldFingerprintHash() {
        return this.oldFingerprintHash;
    }

    public String getNewFingerprintHash() {
        return this.newFingerprintHash;
    }

    public java.time.LocalDateTime getChangeDate() {
        return this.changeDate;
    }

    public String getReason() {
        return this.reason;
    }

    public java.math.BigDecimal getSimilarityPercentage() {
        return this.similarityPercentage;
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

    public String getNotes() {
        return this.notes;
    }

    public String getVerifiedBy() {
        return this.verifiedBy;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public void setOldFingerprintHash(String oldFingerprintHash) {
        this.oldFingerprintHash = oldFingerprintHash;
    }

    public void setNewFingerprintHash(String newFingerprintHash) {
        this.newFingerprintHash = newFingerprintHash;
    }

    public void setChangeDate(java.time.LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setSimilarityPercentage(java.math.BigDecimal similarityPercentage) {
        this.similarityPercentage = similarityPercentage;
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

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setVerifiedBy(String verifiedBy) {
        this.verifiedBy = verifiedBy;
    }
}
