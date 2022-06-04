package com.ccc.tcapi.entites;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "teachers")
@Table(name = "teachers")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TeacherRowID ")
    private Integer teacherRowId;

    // @NotNull
    // @OneToOne(targetEntity = UserEntity.class, cascade = CascadeType.ALL, fetch =
    // FetchType.LAZY)
    // @JoinColumn(name = "UserRowID", referencedColumnName = "userRowID")
    // private Integer userRowID;

    @NotEmpty(message = "Primary phone number can't be empty")
    @Column(name = "PPhone", unique = true, length = 10)
    private String pPhone;

    
    @Column(name = "SPhone", unique = true, length = 10)
    private String sPhone;

  
    @Column(name = "SEmail", unique = true, length = 50)
    private String sEmail;

    @NotEmpty(message = "Qualification can't be empty")
    @Column(name = "Qualification", length = 50)
    private String qualification;

    @NotNull
    @Column(name = "StateRowID")
    private Integer stateRowId;

    @NotNull
    @Column(name = "DistRowID")
    private Integer distRowId;

    @NotNull(message = "City name can't be empty")
    @Size(min = 3, max = 50, message = "City name is must be min of 3 char and maximum of 50 char")
    @Column(name = "CityName", length = 50)
    private String cityName;

    @NotNull(message = "PIN code can't be empty")
    @Column(name = "PINCode", length = 6)
    private Integer pinCode;


    @Column(name = "VillageName", length = 50)
    private String villageName;

    @NotEmpty(message = "HouseLandMark can't be empty")
    @Column(name = "HouseLandMark", length = 50)
    private String houseLandMark;


    @Column(name = "Address", length = 200)
    private String address;

    @NotEmpty(message = "CreatedDate can't be empty")
    @Column(name = "CreatedDate")
    private String createdDate;

    @NotEmpty(message = "CreatedDate can't be empty")
    @Column(name = "CreatedBy")
    private String createdBy;

  
    @Column(name = "UpdatedDate")
    private String updatedDate;

  
    @Column(name = "UpdatedBy")
    private String updatedBy;

    // @OneToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "UserRowID", nullable = false, insertable = false,
    // updatable = false)
    // private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "UserRowID")
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Integer getTeacherRowId() {
        return teacherRowId;
    }

    public void setTeacherRowId(Integer teacherRowId) {
        this.teacherRowId = teacherRowId;
    }

    public String getpPhone() {
        return pPhone;
    }

    public void setpPhone(String pPhone) {
        this.pPhone = pPhone;
    }

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Integer getStateRowId() {
        return stateRowId;
    }

    public void setStateRowId(Integer stateRowId) {
        this.stateRowId = stateRowId;
    }

    public Integer getDistRowId() {
        return distRowId;
    }

    public void setDistRowId(Integer distRowId) {
        this.distRowId = distRowId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getPinCode() {
        return pinCode;
    }

    public void setPinCode(Integer pinCode) {
        this.pinCode = pinCode;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getHouseLandMark() {
        return houseLandMark;
    }

    public void setHouseLandMark(String houseLandMark) {
        this.houseLandMark = houseLandMark;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
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
