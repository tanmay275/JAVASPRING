package com.ccc.tcapi.controller;

import java.util.List;
import java.util.logging.LogManager;


import com.ccc.tcapi.dto.RequestCountry;
import com.ccc.tcapi.dto.ResponseCountry;
import com.ccc.tcapi.entites.CountryEntity;
import com.ccc.tcapi.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/country")
public class CountryController {

    LogManager logger = LogManager.getLogManager();

    @Autowired
    CountryService countryContext;

    @GetMapping(value = "/list")
    public ResponseEntity<List<CountryEntity>> GetCountryList() {
        List<CountryEntity> countries = countryContext.GetCountryList();
        return ResponseEntity.ok(countries);
    }

    @GetMapping(value = "custom/list")
    public ResponseEntity<List<ResponseCountry>> GetCountryCustomList() {
        List<ResponseCountry> countries =  countryContext.GetCountryListWithCustomResponse();
        return ResponseEntity.ok(countries);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> SaveCountry(@RequestBody RequestCountry country) {
        Integer response = countryContext.SaveCountry(country);
        if (response > 0) {
            return ResponseEntity.ok("Country saved successfully");
        }
        return ResponseEntity.internalServerError().body("OPPS: Something went wrong.");

    }
}
