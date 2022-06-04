package com.ccc.tcapi.controller;

import com.ccc.tcapi.dto.RequestState;
import com.ccc.tcapi.service.StateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/state")
public class StateController {
    
    @Autowired
    StateService stateContext;

    @PostMapping(value = "/save")
    public ResponseEntity<String> SaveCountry(@RequestBody RequestState state) {
        Integer response = stateContext.SaveState(state);
        if (response > 0) {
            return ResponseEntity.ok("State saved successfully");
        }
        return ResponseEntity.ok("OPPS: Something went wrong.");
    }
}
