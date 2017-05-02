/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import java.util.List;

/**
 *
 * @author F
 */
public class LoadTables {

    private SQLRepository userGroupRoleRepo = new SQLRepository();

    public List<Object> fillComboBoxBirthCity() 
    {
        List <Object> obj;
        obj = userGroupRoleRepo.findAll("City.findAll");;
        
        return obj;
    }
    
     public List<Object> fillComboBoxCountry() 
    {
        List <Object> obj;
        obj = userGroupRoleRepo.findAll("Country.findAll");;
        
        return obj;
    }
}
