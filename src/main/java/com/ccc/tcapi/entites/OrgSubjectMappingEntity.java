package com.ccc.tcapi.entites;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "Org_Subject_Mapping")
@Table(name = "Org_Subject_Mapping")
public class OrgSubjectMappingEntity {

    @Id
    @Column(name = "SubjRowID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer subjRowID;

    @NotBlank(message = "CourseName can not be left blank.")
    @Column(name = "SubjectName", nullable = false)
    @Size(min = 2, max = 50, message = "CourseName must be minimum of 2 and maximum of 10 characters long")
    private String subjectName;

    @NotNull()
    @Column(name = "OrgRowID", nullable = false)
    // @Size(min = 2, max = 11, message = "OrgRowID must be minimum of 2 and maximum
    // of 11 characters long")
    private Integer orgRowID;

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

    public Integer getSubjRowID() {
        return subjRowID;
    }

    public void setSubjRowID(Integer subjRowID) {
        this.subjRowID = subjRowID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getOrgRowID() {
        return orgRowID;
    }

    public void setOrgRowID(Integer orgRowID) {
        this.orgRowID = orgRowID;
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
    



    