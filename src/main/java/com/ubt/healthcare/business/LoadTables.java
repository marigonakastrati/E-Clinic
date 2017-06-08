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

    private SQLRepository sqlRepository = new SQLRepository();

    public List<Object> fillComboBoxBirthCity()throws Exception {
        List<Object> obj;
        obj = sqlRepository.findAll("City.findAll");;

        return obj;
    }

    public List<Object> fillComboBoxCountry()throws Exception {
        List<Object> obj;
        obj = sqlRepository.findAll("Country.findAll");;

        return obj;
    }

    public List<Object> fillComboBoxGender() throws Exception{
        List<Object> obj;
        obj = sqlRepository.findAll("Gender.findAll");;

        return obj;
    }

    public List<Object> fillComboBoxMartialStatus() throws Exception{
        List<Object> obj;
        obj = sqlRepository.findAll("MartialStatus.findAll");;

        return obj;
    }

    public List<Object> fillComboBoxEducationType()throws Exception {
        List<Object> obj;
        obj = sqlRepository.findAll("EducationType.findAll");;

        return obj;
    }
    
    public List<Object> fillComboBoxReligion()throws Exception {
        List<Object> obj;
        obj = sqlRepository.findAll("Religion.findAll");;

        return obj;
    }

}
