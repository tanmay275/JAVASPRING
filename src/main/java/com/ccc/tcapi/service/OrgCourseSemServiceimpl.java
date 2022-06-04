package com.ccc.tcapi.service;

import com.ccc.tcapi.dto.RequestOrgCourseSem;
import com.ccc.tcapi.entites.OrgCourseSemEntity;
import com.ccc.tcapi.repository.OrgCourseSemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrgCourseSemServiceimpl implements OrgCourseSemService {

    @Autowired
    OrgCourseSemRepository courseSemRepo;

    @Override
    public Integer SaveCourseSem(RequestOrgCourseSem courseSem) {
        OrgCourseSemEntity response = courseSemRepo.save(courseSem.getCourseSem());
        return response.getOrgCourseSemID();
    }

}
