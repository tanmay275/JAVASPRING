package com.ccc.tcapi.entites;

import javax.persistence.*;

@Entity(name = "user_type")
@Table(name = "user_type")
public class UserType {

    @Id
    @Column(name = "UserTypeRowID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userTypeRowID;

    @Column(name = "UserType")
    private String userType;

    @Column(name = "UserTypeCode")
    private String userTypeCode;

    public Integer getUserTypeRowID() {
        return userTypeRowID;
    }

    public void setUserTypeRowID(Integer userTypeRowID) {
        this.userTypeRowID = userTypeRowID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(String userTypeCode) {
        this.userTypeCode = userTypeCode;
    }

}
