package com.ccc.tcapi.entites;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "semesters")
@Table(name = "semesters")
public class SemesterEntity {

    @Id
    @Column(name = "SemRowID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer semRowID;

    @NotBlank(message = "SemName code can not be left blank.")
    @Column(name = "SemName", nullable = false)
    @Size(min = 2, max = 25, message = "SemName must be minimum of 2 and maximum of 25 characters long")
    private String semName;

    public SemesterEntity() {
    }

    @OneToMany(targetEntity = OrgCourseSemEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "SemRowID", referencedColumnName = "semRowID")
    private List<OrgCourseSemEntity> courseSems = new ArrayList<>();

    public List<OrgCourseSemEntity> getCourseSems() {
        return courseSems;
    }

    public void setCourseSems(List<OrgCourseSemEntity> courseSems) {
        this.courseSems = courseSems;
    }

    // @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy =
    // "semesters")
    // private Set<OrgCourseEntity> courses = new HashSet<OrgCourseEntity>();

    // public Set<OrgCourseEntity> getCourses() {
    // return courses;
    // }

    // public void setCourses(Set<OrgCourseEntity> courses) {
    // this.courses = courses;
    // }

    public Integer getSemRowID() {
        return semRowID;
    }

    public void setSemRowID(Integer semRowID) {
        this.semRowID = semRowID;
    }

    public String getSemName() {
        return semName;
    }

    public void setSemName(String semName) {
        this.semName = semName;
    }

}
