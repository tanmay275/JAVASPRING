package com.ccc.tcapi.entites;

import javax.persistence.*;

@Entity(name = "states")
@Table(name = "states")
public class StateEntity {

    @Id
    @Column(name = "StateRowID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stateRowID;

    @Column(name = "Name")
    private String stateName;

    @Column(name = "IsActivate")
    private Boolean isActivate;

    @Column(name = "CountryRowID")
    private Integer countryRowID;

    public StateEntity() {
    }

    public Integer getStateRowID() {
        return stateRowID;
    }

    public void setStateRowID(Integer stateRowID) {
        this.stateRowID = stateRowID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Boolean getIsActivate() {
        return isActivate;
    }

    public void setIsActivate(Boolean isActivate) {
        this.isActivate = isActivate;
    }

}
