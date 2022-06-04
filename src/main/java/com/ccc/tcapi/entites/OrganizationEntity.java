package com.ccc.tcapi.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;
    
@Entity(name = "organizations")
@Table(name = "organizations")
public class OrganizationEntity {

    @Id
    @Column(name = "OrgRowID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orgRowID;

    @NotEmpty(message = "Organization name can't be empty.")
    @Size(min = 3, max = 50, message = "Organization name length must be min 3 char and maximum 50 char.")
    @Column(name = "OrgName")
    private String orgName;

    @Size(min = 2, max = 10, message = "Organization name length must be min 2 char and maximum 10 char.")
    @Column(name = "OrgCode", unique = true)
    private String orgCode;

    @NotNull(message = "Organization ESTD can't be empty.")
    @Column(name = "EstdYear")
    private Integer estdYear;

    @NotNull(message = "Organization address can't be empty")
    @Column(name = "OrgAddress")
    private String orgAddress;

    @Column(name = "CreatedDate")
    private String createdDate;

    @Size(min = 2, max = 10)
    @Column(name = "CreatedBy")
    private String createdBy;

    @Size(min = 2, max = 15)
    @Column(name = "UpdatedDate", nullable = true)
    private String updatedDate;

    @Size(min = 2, max = 15)
    @Column(name = "UpdatedBy", nullable = true)
    private String updatedBy;

    @OneToMany(targetEntity = UserEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "OrgRowID", referencedColumnName = "orgRowID")
    private List<UserEntity> users = new ArrayList<>();

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

}
