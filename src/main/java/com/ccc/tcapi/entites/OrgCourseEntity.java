package com.ccc.tcapi.entites;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "org_course")
@Table(name = "org_course")
public class OrgCourseEntity {

    @Id
    @Column(name = "CourseRowID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseRowID;

    @NotBlank(message = "CourseName can not be left blank.")
    @Column(name = "CourseName", nullable = false)
    @Size(min = 2, max = 50, message = "CourseName must be minimum of 2 and maximum of 10 characters long")
    private String courseName;

    @NotBlank(message = "CourseCode can not be left blank.")
    @Column(name = "CourseCode", nullable = false)
    @Size(min = 2, max = 15, message = "Course Code must be minimum of 2 and maximum of 15 characters long")
    private String courseCode;

    @NotNull()
    @Column(name = "DurationInMonths", nullable = false)
    // @Size(min = 2, max = 11, message = "DurationInMonths must be minimum of 2 and
    // maximum of 11 characters long")
    private Integer durationInMonths;

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



    public OrgCourseEntity() {

    }

    @OneToMany(targetEntity = OrgCourseSemEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "CourseRowID", referencedColumnName = "courseRowID")
    private List<OrgCourseSemEntity> courseSems = new ArrayList<>();

    public List<OrgCourseSemEntity> getCourseSems() {
        return courseSems;
    }

    public void setCourseSems(List<OrgCourseSemEntity> courseSems) {
        this.courseSems = courseSems;
    }

    // @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    // @JoinTable(name = "course_sem", joinColumns = { @JoinColumn(name =
    // "CourseRowID") }, inverseJoinColumns = {
    // @JoinColumn(name = "SemRowID") })
    // Set<SemesterEntity> semesters = new HashSet<SemesterEntity>();

    // public Set<SemesterEntity> getSemesters() {
    // return semesters;
    // }

    // public void setSemesters(Set<SemesterEntity> semesters) {
    // this.semesters = semesters;
    // }

    public Integer getCourseRowID() {
        return courseRowID;
    }

    public void setCourseRowID(Integer courseRowID) {
        this.courseRowID = courseRowID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(Integer durationInMonths) {
        this.durationInMonths = durationInMonths;
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
