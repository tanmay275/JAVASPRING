package com.ccc.tcapi.repository;

import com.ccc.tcapi.dto.ResponseUser;
import com.ccc.tcapi.entites.UserEntity;

import org.springframework.data.jpa.repository.*;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    
    @Query("SELECT new com.ccc.tcapi.dto.ResponseUser(u.userCode, u.firstName, u.middleName, u.lastName, u.email, o.orgName, o.orgCode) FROM users u JOIN organizations o WHERE u.userCode = ?1")
    public ResponseUser findByUserCode(String userCode);

}
