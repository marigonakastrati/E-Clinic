/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Address;
import com.ubt.healthcare.dto.City;
import com.ubt.healthcare.dto.Country;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Education;
import com.ubt.healthcare.dto.EducationProgram;
import com.ubt.healthcare.dto.EducationType;
import com.ubt.healthcare.dto.Gender;
import com.ubt.healthcare.dto.MartialStatus;
import com.ubt.healthcare.dto.Person;
import com.ubt.healthcare.dto.PersonEducation;
import com.ubt.healthcare.dto.Religion;
import com.ubt.healthcare.dto.UserGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author F
 */
public class EducationTypeService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<PersonEducation> personEducation;
    private List<Doctor> doctorRepo;
    private UserValidation userValidation;
    private boolean personEducationChanged;//use it as synchronization mechanizm...
    private boolean doctorRepoChanged;

    public EducationTypeService() {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
        userValidation = new UserValidation();
    }

    public List<PersonEducation> findEducation(Doctor doctor) {
        List<PersonEducation> prsonEduc = new ArrayList<>();
        if (personEducation == null) {
            personEducation = (List<PersonEducation>) (Object) sqlRepository.findAll("PersonEducation.findAll");
        }
        for (PersonEducation perEducation : personEducation) {
            if (Objects.equals(perEducation.getPersonId().getPersonId(), doctor.getPersonId().getPersonId())) {
                prsonEduc.add(perEducation);
            }
        }
        return prsonEduc;
    }

    private String persistEducation(List<PersonEducation> personEducation) {
        String personEducationMsg = null;

        for (PersonEducation education : personEducation) {
            //make the connection between the tables and  save just education pojo
            sqlRepository.add(education);
            personEducationMsg = "Education Saved";
        }

        return personEducationMsg;

    }

    public EducationType findTheEducationType(String educationType) {
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
