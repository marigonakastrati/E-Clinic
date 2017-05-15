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

    public CityService() 
    {
        sqlRepository = new SQLRepository();
    }
    
    public List<City> findAllCity()
    {

        return  city == null? (List<City>)(Object)sqlRepository.findAll("City.findAll") : city;
    }

}
