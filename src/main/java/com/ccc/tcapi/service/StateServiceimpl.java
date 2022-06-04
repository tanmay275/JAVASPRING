package com.ccc.tcapi.service;

import java.util.List;

import com.ccc.tcapi.dto.RequestState;
import com.ccc.tcapi.entites.StateEntity;
import com.ccc.tcapi.repository.StateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateServiceimpl implements StateService {

    @Autowired
    StateRepository stateRepo;


    @Override
    public List<StateEntity> GetAllStateList() {
        return stateRepo.findAll();
    }

    @Override
    public List<StateEntity> GetStateByCountryCode(String countryCode) {
        return stateRepo.findByCountryRowID(1);
    }

    @Override
    public List<StateEntity> GetStateByIsActive(Boolean isActive) {
        return stateRepo.findByIsActivate(isActive);
    }

    @Override
    public Integer SaveState(RequestState state) {
        StateEntity response = stateRepo.save(state.getState());
        return response.getStateRowID();
    }
    
}
