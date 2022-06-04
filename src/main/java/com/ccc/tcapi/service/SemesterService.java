package com.ccc.tcapi.service;

import java.util.List;

import com.ccc.tcapi.dto.RequestSemester;
import com.ccc.tcapi.entites.SemesterEntity;

public interface SemesterService {

    public List<SemesterEntity> GetAllSemesterList();

    public Integer SaveSemester(RequestSemester semester);

    // public Integer SaveSemesters(List<RequestSemester> semester);
}
