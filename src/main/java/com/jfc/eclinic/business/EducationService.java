/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Education;
import java.util.List;

/**
 *
 * @author F
 */
public class EducationService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    
    public EducationService() {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
    }

    public Education findTheEducation(String institutionName, String programName, String educationType)throws Exception {
        List<Object> docs = (List<Object>) sqlRepository.findAll("Education.findAll");
        for (Object o : docs) {
            if (((Education) o).getInstitutionName().equals(institutionName) && ((Education) o).getEducationProgramId().getProgramName().equals(programName)
                         && ((Education) o).getEucationTypeId().getEducationName().equals(educationType)) {
                return (Education) o;
            }
        }

        return null;
    }

    public void persistEducation(Education education)throws Exception {
        sqlRepository.add(education);
    }
}
