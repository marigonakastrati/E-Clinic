/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Nurse;
import com.ubt.healthcare.dto.Receptionist;
import com.ubt.healthcare.dto.UserGroup;
import java.util.List;

/**
 *
 * @author F
 */
public class UserGroupService {

    private SQLRepository sqlRepository;

    public UserGroupService() {
        sqlRepository = new SQLRepository();
    }

    public String checkIfUserGroupExists(Doctor p) throws Exception {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlRepository.findAll("UserGroup.findAll");
        for (Object o : docs) {
            if (((UserGroup) o).getUserId() == p.getDoctorId()) {
                return "Exist";
            }
        }
        return msg;
    }

    public String checkIfUserGroupExists(Nurse p) throws Exception {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlRepository.findAll("UserGroup.findAll");
        for (Object o : docs) {
            if (((UserGroup) o).getUserId() == p.getNurseId()) {
                return "Exist";
            }
        }

        return msg;
    }

    public void persistUserInUserGroup(UserGroup userGroup) throws Exception {
        sqlRepository.add(userGroup);
    }

    // if user i found the the UserGroupRole table
    public String authorization(String user) throws Exception {
        UserGroup userGroup = (UserGroup) sqlRepository.findById(Integer.parseInt(user), "UserGroup.findByUserId", "userId");
        return userGroup.getGroupId().getGroupName();
    }

    public String checkIfUserGroupExists(Receptionist p) throws Exception {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlRepository.findAll("UserGroup.findAll");
        for (Object o : docs) {
            if (((UserGroup) o).getUserId() == p.getReceptionistId()) {
                return "Exist";
            }
        }
        return msg;
    }

    public String checkIfUserxists(String user) throws Exception {
        String msg = "Wrong";
        List<Object> docs = (List<Object>) sqlRepository.findAll("UserGroup.findAll");
        for (Object o : docs) {
            if (((UserGroup) o).getUserId() == Integer.parseInt(user)) {
                return "Valid";
            }
        }

        return msg;
    }

}
