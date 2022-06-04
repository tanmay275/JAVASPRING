package com.ccc.tcapi.service;

import java.util.List;

import com.ccc.tcapi.dto.RequestOrgCourse;
import com.ccc.tcapi.entites.OrgCourseEntity;
import com.ccc.tcapi.repository.OrgCourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrgCourseServiceimpl implements OrgCourseService {

    @Autowired
    OrgCourseRepository courseRepo;

    @Override
    public List<OrgCourseEntity> GetAllOrgCourse() {
        return courseRepo.findAll();
    }

    @Override
    public Integer SaveOrgCourse(RequestOrgCourse course) {
        OrgCourseEntity response = courseRepo.save(course.getCourse());
        return response.getCourseRowID();
    }

    @Override
    public List<OrgCourseEntity> GetCourseByOrgRowId(Integer orgRowId) {
        return courseRepo.findByOrgRowID(orgRowId);
    }

}
