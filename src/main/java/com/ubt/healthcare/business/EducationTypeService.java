/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.EducationType;
import java.util.List;

/**
 *
 * @author F
 */
public class EducationTypeService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;

    public EducationTypeService() {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
    }


    public EducationType findTheEducationType(String educationType)throws Exception {
        EducationType msg = null;
        List<Object> docs = (List<Object>) sqlRepository.findAll("EducationType.findAll");
        for (Object o : docs) {
            if (((EducationType) o).getEducationName().equals(educationType)) {
                msg = (EducationType) o;
            }
        }

        return msg;
    }

}
