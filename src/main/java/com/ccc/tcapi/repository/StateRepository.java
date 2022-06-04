package com.ccc.tcapi.repository;

import java.util.*;

import com.ccc.tcapi.entites.StateEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<StateEntity, Integer> {
    
    // @Query("SELECT s FROM states s WHERE s.CountryRowID=?1")
    // List<StateEntity> findByCountryCode(String countryCode);
    List<StateEntity> findByCountryRowID(Integer countryRowID);

    List<StateEntity> findByIsActivate(Boolean isActivate);
    
}
