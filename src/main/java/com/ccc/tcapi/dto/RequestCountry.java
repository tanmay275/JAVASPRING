package com.ccc.tcapi.dto;

import com.ccc.tcapi.entites.CountryEntity;

public class RequestCountry {
    
    private CountryEntity country;

    public RequestCountry(CountryEntity country) {
        this.country = country;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

}
