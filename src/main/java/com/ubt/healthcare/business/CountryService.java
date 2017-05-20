/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.City;
import com.ubt.healthcare.dto.Country;
import java.util.List;

/**
 *
 * @author F
 */
public class CountryService {

    private SQLRepository sqlRepository;
    private List<City> city; // caching machanisim 

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

}
