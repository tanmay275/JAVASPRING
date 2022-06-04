package com.ccc.tcapi.repository;

import java.util.List;

import com.ccc.tcapi.dto.ResponseCountry;
import com.ccc.tcapi.entites.CountryEntity;

import org.springframework.data.jpa.repository.*;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {

    @Query("SELECT new com.ccc.tcapi.dto.ResponseCountry(c.countryCode, c.countryName, s.stateName) " +
            "FROM countries c JOIN c.states s ")
    List<ResponseCountry> findAllCountries();

}
