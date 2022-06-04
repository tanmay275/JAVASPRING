package com.ccc.tcapi.dto;

public class ResponseOrg {

    public Integer orgRowID;

    public String orgName;

    public String orgCode;

    public Integer estdYear;

    public String orgAddress;

    public ResponseOrg() {
    }

    public ResponseOrg(Integer orgRowID, String orgName, String orgCode, Integer estdYear, String orgAddress) {
        this.orgRowID = orgRowID;
        this.orgName = orgName;
        this.orgCode = orgCode;
        this.estdYear = estdYear;
        this.orgAddress = orgAddress;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public Integer getOrgRowID() {
        return orgRowID;
    }

    public void setOrgRowID(Integer orgRowID) {
        this.orgRowID = orgRowID;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public Integer getEstdYear() {
        return estdYear;
    }

    public void setEstdYear(Integer estdYear) {
        this.estdYear = estdYear;
    }

}
