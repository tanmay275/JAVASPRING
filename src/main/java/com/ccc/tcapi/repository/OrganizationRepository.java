package com.ccc.tcapi.repository;

import java.util.List;

import com.ccc.tcapi.dto.ResponseUser;
import com.ccc.tcapi.entites.OrganizationEntity;

import org.springframework.data.jpa.repository.*;
    
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Integer> {
    @Query("SELECT new com.ccc.tcapi.dto.ResponseUser(u.userCode, u.firstName, u.middleName, u.lastName, u.email, o.orgName, o.orgCode) "
            +
            "FROM  organizations o JOIN o.users u WHERE o.orgRowID =?1")
    List<ResponseUser> findByOrgRowID(Integer orgRowID);
}
