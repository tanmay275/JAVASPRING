package com.ccc.tcapi.service;

import java.util.ArrayList;
import java.util.List;

import com.ccc.tcapi.dto.RequestCountry;
import com.ccc.tcapi.dto.ResponseCountry;
import com.ccc.tcapi.entites.CountryEntity;
import com.ccc.tcapi.entites.StateEntity;
import com.ccc.tcapi.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryServiceimpl implements CountryService {

    @Autowired
    CountryRepository countryRepo;

    @Override
    public List<CountryEntity> GetCountryList() {
        return countryRepo.findAll();
    }

    @Override
    public Integer SaveCountry(RequestCountry country) {

        // #region Dumy data, can be deleted
        List<CountryEntity> countries = new ArrayList<CountryEntity>();
        for (int i = 0; i < 100; i++) {
            CountryEntity cEntity = new CountryEntity();
            cEntity.setCountryCode("IN" + i + 1);
            cEntity.setCountryName("India" + i + 1);
            cEntity.setPhoneCode("9" + i + 1);

            List<StateEntity> sEntites = new ArrayList<StateEntity>();
            for (int j = 0; j < 1000; j++) {
                StateEntity sEntity = new StateEntity();
                sEntity.setStateName("Sample state " + i + 1);
                sEntity.setIsActivate(true);
                sEntites.add(sEntity);
            }
            cEntity.setStates(sEntites);

            countries.add(cEntity);
        }
        Iterable<CountryEntity> cIterator = countries;
        List<CountryEntity> countryEntity1 = countryRepo.saveAll(cIterator);
        // #endregion

        // CountryEntity countryEntity = countryRepo.save(country.getCountry());
        // return countryEntity.getCountryRowID();

        return countryEntity1.size();
    }

    @Override
    public List<ResponseCountry> GetCountryListWithCustomResponse() {
        return countryRepo.findAllCountries();
    }

}
