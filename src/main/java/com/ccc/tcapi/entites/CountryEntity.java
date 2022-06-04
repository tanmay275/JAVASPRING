package com.ccc.tcapi.entites;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "countries")
@Table(name = "countries")
public class CountryEntity {

    @Id
    @Column(name = "CountryRowID", length = 20, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer countryRowID;

    @NotBlank(message = "Country code can not be left blank.")
    @Column(name = "ShortName", nullable = false)
    @Size(min = 2, max = 10, message = "Country code must be minimum of 2 and maximum of 10 characters long")
    private String countryCode;

    @NotBlank(message = "Country name can not be left blank.")
    @Size(min = 3, max = 20, message = "Country name must be minimum of 3 and maximum of 20 characters long")
    @Column(name = "Name", nullable = false)
    private String countryName;

    @NotBlank(message = "Country phone code can not be left blank.")
    @Column(name = "PhoneCode", nullable = false)
    @Size(min = 2, max = 5, message = "Phone code must be minimum of 2 and maximum of 5 characters long")
    private String phoneCode;

    @Column(name = "CreatedDate", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @OneToMany(targetEntity = StateEntity.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "CountryRowID", referencedColumnName = "countryRowID")
    private List<StateEntity> states = new ArrayList<>();

    public List<StateEntity> getStates() {
        return states;
    }

    public void setStates(List<StateEntity> states) {
        this.states = states;
    }

    public CountryEntity() {
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCountryRowID() {
        return countryRowID;
    }

    public void setCountryRowID(Integer countryRowID) {
        this.countryRowID = countryRowID;
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

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

}
