package com.ccc.tcapi.dto;


public class ResponseCountry {

    private String countryCode;

    private String countryName;

    private String stateName;

    public ResponseCountry(String countryCode, String countryName, String stateName) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.stateName = stateName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

}
