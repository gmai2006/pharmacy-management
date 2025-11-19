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
@Table(name = "stations")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Stations implements Serializable {
    private static final long serialVersionUID = 176351898745915220L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(name = "id")
    private Integer id;

    /** Description: station_prefix. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "station_prefix")
    private String stationPrefix;

    /** Description: department. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "department")
    private String department;

    /** Description: location. */
    @Basic
    @Column(name = "location")
    private String location;

    /** Description: starting_number. */
    @Basic
    @Column(name = "starting_number")
    private Integer startingNumber;

    /** Description: current_number. */
    @Basic
    @Column(name = "current_number")
    private Integer currentNumber;

    /** Description: max_stations. */
    @Basic
    @Column(name = "max_stations")
    private Integer maxStations;

    /** Description: created_date. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "created_date")
    private java.time.LocalDateTime createdDate;

    /** Description: updated_date. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "updated_date")
    private java.time.LocalDateTime updatedDate;

    public Stations() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationPrefix() {
        return this.stationPrefix;
    }

    public String getDepartment() {
        return this.department;
    }

    public String getLocation() {
        return this.location;
    }

    public Integer getStartingNumber() {
        return this.startingNumber;
    }

    public Integer getCurrentNumber() {
        return this.currentNumber;
    }

    public Integer getMaxStations() {
        return this.maxStations;
    }

    public java.time.LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public java.time.LocalDateTime getUpdatedDate() {
        return this.updatedDate;
    }

    public void setStationPrefix(String stationPrefix) {
        this.stationPrefix = stationPrefix;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStartingNumber(Integer startingNumber) {
        this.startingNumber = startingNumber;
    }

    public void setCurrentNumber(Integer currentNumber) {
        this.currentNumber = currentNumber;
    }

    public void setMaxStations(Integer maxStations) {
        this.maxStations = maxStations;
    }

    public void setCreatedDate(java.time.LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(java.time.LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
