package com.ccc.tcapi.service;

import java.util.List;

import com.ccc.tcapi.dto.RequestOrgCourse;
import com.ccc.tcapi.entites.OrgCourseEntity;

public interface OrgCourseService {
    
    public List<OrgCourseEntity> GetAllOrgCourse();

    public Integer SaveOrgCourse(RequestOrgCourse course);

    public List<OrgCourseEntity> GetCourseByOrgRowId(Integer orgRowId);


}
