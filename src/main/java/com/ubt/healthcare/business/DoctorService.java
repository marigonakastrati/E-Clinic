/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.PersonEducation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author F
 */
public class DoctorService {
    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<PersonEducation> personEducation;
    private List<Doctor> doctorRepo;

    public DoctorService() 
    {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
    }
    
    public List<PersonEducation> findEducation(Doctor doctor)
    {
        List<PersonEducation> prsonEduc= new ArrayList<>();
        if(personEducation == null)
        {
             personEducation = (List<PersonEducation>)(Object)sqlRepository.findAll("PersonEducation.findAll");
        }
        for(PersonEducation perEducation : personEducation)
        {
            if(perEducation.getPersonId().getPersonId() == doctor.getPersonId().getPersonId())
            {
                prsonEduc.add(perEducation);
            }
        }
        return prsonEduc;
    }
    /**
     Fix the Validation...
     * @param name
     * @param surname
     * @param city
     * @return List 
     */
    public List<Doctor> findDoctorsByParameters(String name, String surname, String city)
    {    
        if(doctorRepo == null)
        {
            doctorRepo = (List<Doctor>)(Object)sqlRepository.findAll("Doctor.findAll");
        }
        List<Doctor> doctorList= new ArrayList<>();
        
        if(inputValidation.validateInput(name))
        {
            if(inputValidation.validateInput(surname))
            {
                if(inputValidation.validateInput(city))
                {
                    doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getFirstName().equals(name) 
                                        && doctor.getPersonId().getLastName().equals(surname)
                                        && doctor.getPersonId().getAddressId().getCityId()
                                        .getCityName().equals(city))).forEachOrdered((doctor) -> {
                                             doctorList.add(doctor);
                    });
                }
                else
                {
                    doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getFirstName().equals(name) 
                                            && doctor.getPersonId().getLastName().equals(surname))).forEachOrdered((doctor) -> {
                                                    doctorList.add(doctor);
                    });
                    
                }
            }
            else
            {
                doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getFirstName().equals(name)))
                                         .forEachOrdered((doctor) -> {
                                             doctorList.add(doctor);
                });
            }
        }
        else if (inputValidation.validateInput(surname))
        {
            if(inputValidation.validateInput(city))
            {
                if(inputValidation.validateInput(city))
                {
                    doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getLastName()
                                        .equals(surname) && doctor.getPersonId().getAddressId()
                                        .getCityId().getCityName().equals(city)))
                                        .forEachOrdered((doctor) -> {
                                             doctorList.add(doctor);
                    });
                }
            }
            else
            {
                doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getLastName().equals(surname)))
                                        .forEachOrdered((doctor) -> {
                                            doctorList.add(doctor);
                });
                
            }
        }
        else
        {
            doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                                        .getCityId().getCityName().equals(city)))
                                        .forEachOrdered((doctor) -> {
                                             doctorList.add(doctor);
                });
        }
        
        return doctorList;
    }
    
   

}
