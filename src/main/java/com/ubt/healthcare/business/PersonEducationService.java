/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.PersonEducation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author F
 */
public class PersonEducationService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<PersonEducation> personEducation;
    private List<Doctor> doctorRepo;
    private boolean personEducationChanged;//use it as synchronization mechanizm...
    private boolean doctorRepoChanged;

    public PersonEducationService() {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
    }

    public void persistPersonEducation(PersonEducation personEducation) {

        //make the connection between the tables and  save just education pojo
        sqlRepository.add(personEducation);

        // return "Education Saved";
    }

    public void editPersonEducation(PersonEducation personEducation) {

        //make the connection between the tables and  save just education pojo
        sqlRepository.update(personEducation);

        // return "Education Saved";
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
    
    public void forceFetchFromDatabase()
    {
        personEducation = null;
    }
}
