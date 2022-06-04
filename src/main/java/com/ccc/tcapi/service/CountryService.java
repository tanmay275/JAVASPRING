package com.ccc.tcapi.service;

import java.util.List;

import com.ccc.tcapi.dto.RequestCountry;
import com.ccc.tcapi.dto.ResponseCountry;
import com.ccc.tcapi.entites.CountryEntity;

public interface CountryService {
    
    public List<CountryEntity> GetCountryList();

    public List<ResponseCountry> GetCountryListWithCustomResponse();

    public Integer SaveCountry(RequestCountry country);
    
}
