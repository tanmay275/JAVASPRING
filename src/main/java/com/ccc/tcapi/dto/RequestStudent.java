package com.ccc.tcapi.dto;

import com.ccc.tcapi.entites.StudentEntity;

public class RequestStudent {

    private StudentEntity student;

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

}
