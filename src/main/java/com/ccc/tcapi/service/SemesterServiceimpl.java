package com.ccc.tcapi.service;

import java.util.List;

import com.ccc.tcapi.dto.RequestSemester;
import com.ccc.tcapi.entites.SemesterEntity;
import com.ccc.tcapi.repository.SemesterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SemesterServiceimpl implements SemesterService {

    @Autowired
    SemesterRepository semesterRepo;

    @Override
    public List<SemesterEntity> GetAllSemesterList() {
        return semesterRepo.findAll();
    }

    @Override
    public Integer SaveSemester(RequestSemester semester) {
        SemesterEntity response = semesterRepo.save(semester.getSemester());
        return response.getSemRowID();
    }

    // @Override
    // public Integer SaveSemesters(List<RequestSemester> semester) {

    //     Iterable<List<RequestSemester>> = semester;

    //     SemesterEntity response = semesterRepo.saveAll(semester);
    //     return 1;
    // }

}
