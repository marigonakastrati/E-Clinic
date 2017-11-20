/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.services.impl;

import com.jfc.eclinic.dao.CountryRepository;
import com.jfc.eclinic.dto.Country;
import com.jfc.eclinic.services.CountryService;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author jfc
 */
public class CountryServiceImpl implements CountryService {

    private CountryRepository countryRepository;

    @Inject
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryServiceImpl() {
    }

    @Override
    public List<Country> get() throws Exception {
        return countryRepository.findAll();
    }

    @Override
    public Country get(int id) throws Exception {
        return countryRepository.findById(id);
    }

    @Override
    public void update(Country value) throws Exception {
        countryRepository.update(value);
    }

    @Override
    public void create(Country value) throws Exception {
        countryRepository.add(value);
    }

    @Override
    public void delete(int id) throws Exception {
        countryRepository.remove(id);
    }

}
