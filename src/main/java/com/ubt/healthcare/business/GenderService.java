/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Gender;
import java.util.List;

/**
 *
 * @author F
 */
public class GenderService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;

    public GenderService() {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
    }

  
    public Gender findTheGender(String gender) {
        Gender msg = null;
        List<Object> docs = (List<Object>) sqlRepository.findAll("Gender.findAll");
        for (Object o : docs) {
            if (((Gender) o).getGenderName().trim().equals(gender.trim())) {
                msg = (Gender) o;
            }
        }

        return msg;
    }
}
