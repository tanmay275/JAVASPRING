package com.ccc.tcapi.dto;

import com.ccc.tcapi.entites.OrganizationEntity;
    
public class RequestOrganization {
    
    private OrganizationEntity orgEntity;


    public OrganizationEntity getOrgEntity() {
        return orgEntity;
    }

    public void setOrgEntity(OrganizationEntity orgEntity) {
        this.orgEntity = orgEntity;
    }

}
