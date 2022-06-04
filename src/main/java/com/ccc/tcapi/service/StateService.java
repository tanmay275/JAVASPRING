package com.ccc.tcapi.service;

import java.util.List;

import com.ccc.tcapi.dto.RequestState;
import com.ccc.tcapi.entites.StateEntity;

public interface StateService {
    
    public List<StateEntity> GetAllStateList();

    public List<StateEntity> GetStateByCountryCode(String countryCode);

    public List<StateEntity> GetStateByIsActive(Boolean isActive);

    public Integer SaveState(RequestState state);

}
