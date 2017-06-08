/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.City;
import com.ubt.healthcare.dto.LoginGroup;
import java.util.List;

/**
 *
 * @author F
 */
public class LoginGroupService {

    private SQLRepository sqlRepository;
    private List<City> city; // caching machanisim 

    public LoginGroupService() {
        sqlRepository = new SQLRepository();
    }

    public LoginGroup findTheLoginGroup(String groupName) throws Exception{
        LoginGroup msg = null;
        List<Object> docs = (List<Object>) sqlRepository.findAll("LoginGroup.findAll");
        for (Object o : docs) {
            if (((LoginGroup) o).getGroupName().equals(groupName)) {
                msg = (LoginGroup) o;
            }
        }

        return msg;
    }
}
