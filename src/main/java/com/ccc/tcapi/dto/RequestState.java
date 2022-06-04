package com.ccc.tcapi.dto;

import com.ccc.tcapi.entites.StateEntity;

public class RequestState {

    private StateEntity state;

    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }
    
}
