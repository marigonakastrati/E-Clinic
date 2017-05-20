/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.City;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.UserGroup;
import java.util.List;

/**
 *
 * @author F
 */
public class UserGroupService {

    private SQLRepository sqlRepository;
    private List<City> city; // caching machanisim 

    public UserGroupService() {
        sqlRepository = new SQLRepository();
    }

    public String checkIfUserGroupExists(Doctor p) {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlRepository.findAll("UserGroup.findAll");
        for (Object o : docs) {
            if (((UserGroup) o).getUserId() == p.getDoctorId()) {
                return "Exist";
            }
        }

        return msg;
    }

    public void persistUserInUserGroup(UserGroup userGroup) {
        sqlRepository.add(userGroup);
    }
}
