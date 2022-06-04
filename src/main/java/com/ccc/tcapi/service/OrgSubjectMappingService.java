package com.ccc.tcapi.service;

import java.util.List;

import com.ccc.tcapi.dto.RequestOrgSubjectMapping;
import com.ccc.tcapi.entites.OrgSubjectMappingEntity;

public interface OrgSubjectMappingService {
    
    public List<OrgSubjectMappingEntity> GetAllOrgSubjectMapping();

    public Integer SaveOrgSubjectMapping(RequestOrgSubjectMapping subject);

    public List<OrgSubjectMappingEntity> GetSubjectsByOrgRowId(Integer orgRowId);


}
