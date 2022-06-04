package com.ccc.tcapi.entites;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "org_course_sem")
@Table(name = "org_course_sem")
public class OrgCourseSemEntity {

    @Id
    @Column(name = "OrgCourseSemID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer OrgCourseSemID;

    @Column(name = "CourseRowID", nullable = false)
    private Integer courseRowID;

    @Column(name = "SemRowID", nullable = false)
    private Integer semRowID;

    @Column(name = "FromDate", nullable = false)
    private Date fromDate;

    @Column(name = "ToDate", nullable = true)
    private Date toDate;

    @Column(name = "CreatedDate", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @NotBlank(message = "CreatedBy can not be left blank.")
    @Column(name = "CreatedBy", nullable = false)
    @Size(min = 2, max = 15, message = "CreatedBy must be minimum of 2 and maximum of 15 characters long")
    private String createdBy;

    @Size(min = 2, max = 15)
    @Column(name = "UpdatedDate", nullable = true)
    private String updatedDate;

    @Size(min = 2, max = 15)
    @Column(name = "UpdatedBy", nullable = true)
    private String updatedBy;

    public OrgCourseSemEntity() {

    }

    public Integer getOrgCourseSemID() {
        return OrgCourseSemID;
    }

    public void setOrgCourseSemID(Integer orgCourseSemID) {
        OrgCourseSemID = orgCourseSemID;
    }

    public Integer getCourseRowID() {
        return courseRowID;
    }

    public void setCourseRowID(Integer courseRowID) {
        this.courseRowID = courseRowID;
    }

    public Integer getSemRowID() {
        return semRowID;
    }

    public void setSemRowID(Integer semRowID) {
        this.semRowID = semRowID;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
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
