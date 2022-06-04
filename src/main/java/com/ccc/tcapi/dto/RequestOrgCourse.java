package com.ccc.tcapi.dto;

import com.ccc.tcapi.entites.OrgCourseEntity;

public class RequestOrgCourse {

    private OrgCourseEntity course;

    public OrgCourseEntity getCourse() {
        return course;
    }

    public void setCourse(OrgCourseEntity course) {
        this.course = course;
    }

}
