/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.EducationProgram;
import com.ubt.healthcare.dto.PersonEducation;
import java.util.List;

/**
 *
 * @author F
 */
public class EducationProgramService {
    
    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<PersonEducation> personEducation;
    
    public EducationProgramService() {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
    }
    
    public EducationProgram findTheEducationProgram(String educationProgram) {
        EducationProgram msg = null;
        List<Object> docs = (List<Object>) sqlRepository.findAll("EducationProgram.findAll");
        for (Object o : docs) {
            if (((EducationProgram) o).getProgramName().equals(educationProgram)) {
                msg = (EducationProgram) o;
            }
        }
        
        return msg;
    }
    
    public void persistEducationProgram(EducationProgram educationProgram) {
        sqlRepository.add(educationProgram);
    }
    
}
