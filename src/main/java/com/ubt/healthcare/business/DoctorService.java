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
import java.util.Objects;

/**
 *
 * @author F
 */
public class DoctorService {
    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<PersonEducation> personEducation;
    private List<Doctor> doctorRepo;
    private boolean personEducationChanged;//use it as synchronization mechanizim...
    private boolean doctorRepoChanged;

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
            if(Objects.equals(perEducation.getPersonId().getPersonId(), doctor.getPersonId().getPersonId()))
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
        List<Doctor> surNameList= new ArrayList<>();
        List<Doctor> cityList= new ArrayList<>();
        
        if(inputValidation.validateInput(name))
        {
            doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getFirstName().equals(name)))
                                         .forEachOrdered((doctor) -> {
                                             doctorList.add(doctor);});
            if(inputValidation.validateInput(surname))
            {
                
                doctorList.stream().filter((doctor) -> (doctor.getPersonId().getLastName().equals(surname)))
                                         .forEachOrdered((doctor) -> {
                                             surNameList.add(doctor);});
                
                if(inputValidation.validateInput(city))
                {
                   doctorList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                                            .getCityId().getCityName().equals(city)))
                                            .forEachOrdered((doctor) -> {
                                             cityList.add(doctor);});
                   return cityList;
                }
                 return surNameList;
            }
            else if (inputValidation.validateInput(city))
            {
                
                 doctorList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                                            .getCityId().getCityName().equals(city)))
                                            .forEachOrdered((doctor) -> {
                                             cityList.add(doctor);});  
                 return cityList;
            }
            return doctorList;
        }
        else if (inputValidation.validateInput(surname))
        {
            doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getLastName().equals(surname)))
                                         .forEachOrdered((doctor) -> {
                                             doctorList.add(doctor);});
            if(inputValidation.validateInput(city))
            {
                 doctorList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                                            .getCityId().getCityName().equals(city)))
                                            .forEachOrdered((doctor) -> {
                                             cityList.add(doctor);});  
                 return cityList;
            }
            return doctorList;
            
        }
        else {
            doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                    .getCityId().getCityName().equals(city)))
                    .forEachOrdered((doctor) -> {
                        doctorList.add(doctor);
                    });

        }
        
        return doctorList;
    }
    
   
    public void persistDoctor(Doctor doctor, String sex, String martialStatus,String birthPlace, String address, 
            String city, String country, String buildingNumber, String mobilePhone, 
            String workPhone, String homePhone,String email, List<PersonEducation> personEducation )
    {
        
        for (PersonEducation personEducation1 : personEducation) {
            // save the education data on database...
             // link the person education with education data
            
        }
        //math the combobox values and get the actual orm 
        // save the related objects with person 
        //e. i City has relation with person 
        
       
    }

}
