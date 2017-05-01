/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.UserGroup;

/**
 *
 * @author F
 */
public class UserGroupAuthorization {

    private SQLRepository userGroupRoleRepo = new SQLRepository();
    
    // if user i found the the UserGroupRole table
    public String authorization(String user)
    {
        final String entiy = "UserGroup.findByUserId";
        final String attribute = "userId";
        UserGroup userGroup = (UserGroup)userGroupRoleRepo.findById(Integer.parseInt(user),entiy,attribute);
        
        return userGroup.getGroupId().getGroupName();
    }
}
