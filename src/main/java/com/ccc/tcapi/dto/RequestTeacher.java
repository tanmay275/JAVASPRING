package com.ccc.tcapi.dto;

import com.ccc.tcapi.entites.TeacherEntity;

public class RequestTeacher {
    private TeacherEntity teacherEntity;

    public TeacherEntity getTeacherEntity() {
        return teacherEntity;
    }

    public void setTeacherEntity(TeacherEntity teacherEntity) {
        this.teacherEntity = teacherEntity;
    }

}
