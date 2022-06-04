package com.ccc.tcapi.dto;

import com.ccc.tcapi.entites.SemesterEntity;

public class RequestSemester {

    private SemesterEntity semester;

    public SemesterEntity getSemester() {
        return semester;
    }

    public void setSemester(SemesterEntity semester) {
        this.semester = semester;
    }


    
}
