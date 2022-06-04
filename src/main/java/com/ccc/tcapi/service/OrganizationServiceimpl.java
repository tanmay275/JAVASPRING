package com.ccc.tcapi.service;

import java.util.List;
import java.util.Optional;

import com.ccc.tcapi.dto.RequestOrganization;
import com.ccc.tcapi.dto.ResponseOrg;
import com.ccc.tcapi.entites.OrganizationEntity;
import com.ccc.tcapi.repository.OrganizationRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrganizationServiceimpl implements OrganizationService {
   
    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @todo get organization list
     * @return List<OrganizationEntity>
     */
    @Override
    public List<OrganizationEntity> GetOrgList() {
        return this.organizationRepository.findAll();
    }

    /**
     * @todo save organization
     * @return orgRowID
     */
    @Override
    public Integer saveOrganizaton(RequestOrganization org) {
        OrganizationEntity newOrg = this.organizationRepository.save(org.getOrgEntity());
        return newOrg.getOrgRowID();
    }

    /**
     * @todo delete organization by id
     */
    @Override
    public void DeleteOrganizatonById(Integer orgRowId) {
        this.organizationRepository.deleteById(orgRowId);
    }

    /**
     * @todo get organization by
     * @return orgRowID
     */
    @Override
    public ResponseOrg GetOrgByID(Integer orgRowID) {
        Optional<OrganizationEntity> optionalEntity = this.organizationRepository.findById(orgRowID);
        OrganizationEntity organizationEntity = optionalEntity.get();
        return this.orgToResponseOrg(organizationEntity);
    }

    private ResponseOrg orgToResponseOrg(OrganizationEntity organizationEntity) {
        ResponseOrg responseOrg = this.modelMapper.map(organizationEntity, ResponseOrg.class);
        return responseOrg;
    }

}
