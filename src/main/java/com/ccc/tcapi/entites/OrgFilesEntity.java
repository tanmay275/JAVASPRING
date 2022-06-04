package com.ccc.tcapi.entites;

import java.util.Date;

import javax.persistence.*;

@Entity(name = "org_files")
@Table(name = "org_files")
public class OrgFilesEntity {
    @Id
    @Column(name = "OrgFileRowID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orgFileRowID;

    @Column(name = "OrgRowID")
    private Integer orgRowID;

    @Column(name = "FileName", nullable = false, length = 50)
    private String fileName;

    @Column(name = "FilePath", nullable = false, length = 100)
    private String filePath;

    @Column(name = "FileSize", nullable = false)
    private Float fileSize;

    @Column(name = "FileExt", nullable = false, length = 10)
    private String fileExt;

    @Column(name = "IsActivate", nullable = false)
    private Boolean isActivate;

    // @Basic(optional = false)
    @Column(name = "CreatedDate", insertable = false, updatable = false)
    // @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate = new Date();

    @Column(name = "CreatedBy", nullable = false, length = 15)
    private String createdBy;

    @Column(name = "UpdatedDate", nullable = true, length = 15)
    private String updatedDate;

    @Column(name = "UpdatedBy", nullable = true, length = 15)
    private String updatedBy;

    public Integer getOrgFileRowID() {
        return orgFileRowID;
    }

    public void setOrgFileRowID(Integer orgFileRowID) {
        this.orgFileRowID = orgFileRowID;
    }

    public Integer getOrgRowID() {
        return orgRowID;
    }

    public void setOrgRowID(Integer orgRowID) {
        this.orgRowID = orgRowID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Float getFileSize() {
        return fileSize;
    }

    public void setFileSize(Float fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public Boolean getIsActivate() {
        return isActivate;
    }

    public void setIsActivate(Boolean isActivate) {
        this.isActivate = isActivate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}
