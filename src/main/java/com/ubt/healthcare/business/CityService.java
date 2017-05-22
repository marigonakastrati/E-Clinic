/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.City;
import java.util.List;

/**
 *
 * @author F
 */
public class CityService {

    private SQLRepository sqlRepository;
    private List<City> city; // caching machanisim 

    public CityService() {
        sqlRepository = new SQLRepository();
    }

    public List<City> findAllCity() {

        return city == null ? (List<City>) (Object) sqlRepository.findAll("City.findAll") : city;
    }

    public City findTheCity(String city) {
        City msg = null;
        List<Object> docs = (List<Object>) sqlRepository.findAll("City.findAll");
        for (Object o : docs) {
            if (((City) o).getCityName().equals(city)) {
                msg = (City) o;
            }
        }

        return msg;
    }
    
    public String checkIfCityExists(String cityName) {
        String msg = "Save";
        List<Object> cityList = (List<Object>) sqlRepository.findAll("City.findAll");
        for (Object o : cityList) {
            if (((City) o).getCityName().equals(cityName)) {
                return "Exist";
            }
        }

        return msg;
    }

    public void persistCity(City city) {
        sqlRepository.add(city);
    }

}
