/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Address;
import com.ubt.healthcare.dto.City;
import com.ubt.healthcare.dto.Country;
import java.util.List;

/**
 *
 * @author F
 */
public class CountryService {

    private SQLRepository sqlRepository;

    public CountryService() {
        sqlRepository = new SQLRepository();
    }

    public Country findTheCountry(String country) {
        Country msg = null;
        List<Object> docs = (List<Object>) sqlRepository.findAll("Country.findAll");
        for (Object o : docs) {
            if (((Country) o).getCountryName().equals(country)) {
                msg = (Country) o;
            }
        }

        return msg;
    }

    public String checkIfCountryExists(String country) {
        String msg = "Save";
        List<Object> countryList = (List<Object>) sqlRepository.findAll("Country.findAll");
        for (Object o : countryList) {
            if (((Country) o).getCountryName().equals(country)) {
                return "Exist";
            }
        }

        return msg;
    }

    public void persistCountry(Country country) {
        sqlRepository.add(country);
    }
}
