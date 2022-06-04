package com.ccc.tcapi.dto;

import com.ccc.tcapi.entites.OrgSubjectMappingEntity;

public class RequestOrgSubjectMapping {

    private OrgSubjectMappingEntity subject;

    public OrgSubjectMappingEntity getSubject() {
        return subject;
    }

    public void setSubject(OrgSubjectMappingEntity subject) {
        this.subject = subject;
    }

}
