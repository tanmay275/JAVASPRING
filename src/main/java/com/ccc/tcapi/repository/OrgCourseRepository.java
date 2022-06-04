package com.ccc.tcapi.repository;

import java.util.List;

import com.ccc.tcapi.entites.OrgCourseEntity;

// import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgCourseRepository extends JpaRepository<OrgCourseEntity, Integer> {

    // @Query("SELECT c FROM course c WHERE c.OrgRowID = :orgRowID")
    List<OrgCourseEntity> findByOrgRowID(Integer orgRowID);

    

}

