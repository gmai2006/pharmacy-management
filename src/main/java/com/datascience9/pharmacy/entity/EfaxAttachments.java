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
@Table(name = "efax_attachments")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EfaxAttachments implements Serializable {
    private static final long serialVersionUID = 176351898745556264L;

    /** Description: id. */
    @jakarta.validation.constraints.NotNull
    @Id
    @Column(columnDefinition = "UUID", name = "id")
    private java.util.UUID id;

    /** Description: efax_job_id. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(columnDefinition = "UUID", name = "efax_job_id")
    private java.util.UUID efaxJobId;

    /** Description: file_name. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "file_name")
    private String fileName;

    /** Description: file_type. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "file_type")
    private String fileType;

    /** Description: file_size_bytes. */
    @Basic
    @Column(name = "file_size_bytes")
    private Long fileSizeBytes;

    /** Description: encrypted_path. */
    @jakarta.validation.constraints.NotNull
    @Basic
    @Column(name = "encrypted_path")
    private String encryptedPath;

    /** Description: checksum. */
    @Basic
    @Column(name = "checksum")
    private String checksum;

    /** Description: page_number. */
    @Basic
    @Column(name = "page_number")
    private Integer pageNumber;

    /** Description: created_at. */
    @Basic
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    public EfaxAttachments() {}

    public java.util.UUID getId() {
        return this.id;
    }

    public void setId(java.util.UUID id) {
        this.id = id;
    }

    public java.util.UUID getEfaxJobId() {
        return this.efaxJobId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileType() {
        return this.fileType;
    }

    public Long getFileSizeBytes() {
        return this.fileSizeBytes;
    }

    public String getEncryptedPath() {
        return this.encryptedPath;
    }

    public String getChecksum() {
        return this.checksum;
    }

    public Integer getPageNumber() {
        return this.pageNumber;
    }

    public java.time.LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setEfaxJobId(java.util.UUID efaxJobId) {
        this.efaxJobId = efaxJobId;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setFileSizeBytes(Long fileSizeBytes) {
        this.fileSizeBytes = fileSizeBytes;
    }

    public void setEncryptedPath(String encryptedPath) {
        this.encryptedPath = encryptedPath;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
