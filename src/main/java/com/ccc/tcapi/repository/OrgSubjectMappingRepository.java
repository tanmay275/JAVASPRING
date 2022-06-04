package com.ccc.tcapi.repository;

import java.util.List;

import com.ccc.tcapi.entites.OrgSubjectMappingEntity;

// import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgSubjectMappingRepository extends JpaRepository<OrgSubjectMappingEntity, Integer> {

    // @Query("SELECT c FROM course c WHERE c.OrgRowID = :orgRowID")
    List<OrgSubjectMappingEntity> findByOrgRowID(Integer orgRowID);

    

}

