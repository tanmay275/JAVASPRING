package com.ccc.tcapi.service;

import java.util.List;

import com.ccc.tcapi.dto.RequestOrganization;
import com.ccc.tcapi.dto.ResponseOrg;
import com.ccc.tcapi.entites.OrganizationEntity;
    
public interface OrganizationService {

    public List<OrganizationEntity> GetOrgList();

    public Integer saveOrganizaton(RequestOrganization org);

    public void DeleteOrganizatonById(Integer orgRowId);

    public ResponseOrg GetOrgByID(Integer orgRowID);

}
