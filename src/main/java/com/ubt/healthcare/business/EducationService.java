/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Education;
import com.ubt.healthcare.dto.PersonEducation;
import java.util.List;

/**
 *
 * @author F
 */
public class EducationService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<PersonEducation> personEducation;
    private List<Doctor> doctorRepo;
    private boolean personEducationChanged;//use it as synchronization mechanizm...
    private boolean doctorRepoChanged;

    public EducationService() {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
    }

    public Education findTheEducation(String institutionName, String programName, String educationType) {
        List<Object> docs = (List<Object>) sqlRepository.findAll("Education.findAll");
        for (Object o : docs) {
            if (((Education) o).getInstitutionName().equals(institutionName) && ((Education) o).getEducationProgramId().getProgramName().equals(programName)
                         && ((Education) o).getEucationTypeId().getEducationName().equals(educationType)) {
                return (Education) o;
            }
        }

        return null;
    }

    public void persistEducation(Education education) {
        sqlRepository.add(education);
    }
}
