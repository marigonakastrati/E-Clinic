/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Address;
import com.ubt.healthcare.dto.City;
import com.ubt.healthcare.dto.Contact;
import com.ubt.healthcare.dto.Country;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Gender;
import com.ubt.healthcare.dto.MartialStatus;
import com.ubt.healthcare.dto.Person;
import com.ubt.healthcare.dto.PersonEducation;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author F
 */
public class DoctorService {
    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<PersonEducation> personEducation;
    private List<Doctor> doctorRepo;
    private UserValidation userValidation;
    private boolean personEducationChanged;//use it as synchronization mechanizm...
    private boolean doctorRepoChanged;

    public DoctorService() 
    {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
        userValidation = new UserValidation();
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
        
        Gender findTheGender = userValidation.findTheGender(sex);
        MartialStatus findTheMartialStatus = userValidation.findTheMartialStatus(martialStatus);
        City birthPlaceObject = userValidation.findTheCity(birthPlace);
        Address addressObject = new Address();
        City findTheCity = userValidation.findTheCity(city);
        Country findTheCountry = userValidation.findTheCountry(country);
        Contact findTheMobileNumber = userValidation.findTheContact(mobilePhone);
        Contact findTheWorkNumber = userValidation.findTheContact(workPhone);
        Contact findTheHomeNumber = userValidation.findTheContact(homePhone);
        Contact findTheEmailNumber = userValidation.findTheContact(email);
        
        findTheCity.setCountryId(findTheCountry);
        
        addressObject.setStreetName(address);
        addressObject.setCityId(findTheCity);
        addressObject.setBuildingNumber(Integer.parseInt(buildingNumber));
        
        doctor.getPersonId().setGenderId(findTheGender);
        doctor.getPersonId().setMartialStatusId(findTheMartialStatus);
        doctor.getPersonId().setAddressId(addressObject);
        doctor.getPersonId().setBirthCityId(birthPlaceObject);

        findTheMobileNumber.setPersonId(doctor.getPersonId());
        findTheWorkNumber.setPersonId(doctor.getPersonId());
        findTheHomeNumber.setPersonId(doctor.getPersonId());
        findTheEmailNumber.setPersonId(doctor.getPersonId());

        int i = 0;
        for ( PersonEducation p : personEducation) 
        {
            
            // save the education data on database...
             // link the person education with education data
             personEducation.get(i++).setPersonId(doctor.getPersonId());
            
        }
        //math the combobox values and get the actual orm 
        // save the related objects with person 
        //e. i City has relation with person 
        String msg = userValidation.validatePerson(doctor.getPersonId());
        if("Validate".equals(msg))
        {
            String persistDoctorMsg, persistEducationMsg = null;
            
            persistDoctorMsg = persistDoctor(doctor);
            persistEducationMsg = persistEducation(personEducation);
            
            if("Saved".equals(persistDoctorMsg))
            {
                JOptionPane.showMessageDialog(null, "User is saved");
                //clear the fields
                // close the internalFrame
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Doctor message: "+persistDoctorMsg + "Education message: "+persistEducationMsg);   
            }
        }
        else if ("You must type your first name".equals(msg))// check for other error messages...
        {
            JOptionPane.showMessageDialog(null, msg);
        } 
        
       
    }
    
    private String persistDoctor(Doctor doctor)
    {
        
        String personMsg = null;
        String addressMsg = null;
        String doctorMsg = null;
        
        Person person = doctor.getPersonId();
        
        Address addressTo = person.getAddressId();
        String streetName = addressTo.getStreetName();
        String buildingNumber = addressTo.getBuildingNumber().toString();
        
        addressMsg = userValidation.checkIfAddressExists(streetName,buildingNumber); // if street name and post code and city and county same dont add new address
        personMsg = userValidation.checkIfUserExists(person);
        doctorMsg = userValidation.checkIfDoctorExists(doctor);
        
        if("Save".equals(personMsg) && "Save".equals(doctorMsg))
        {
            if("Save".equals(addressMsg))
            {
                sqlRepository.add(addressTo);
                sqlRepository.add(person);
                return "Saved";
            }
            else
            {
                sqlRepository.add(person);
                return "Saved";
            }
        }

            return "Save".equals(personMsg)?doctorMsg:personMsg;
    }
    
    private String persistEducation(List<PersonEducation> personEducation)
    {
        String personEducationMsg = null;
        
        for (PersonEducation education : personEducation) 
        {
            sqlRepository.add(education);
            personEducationMsg = "Education Saved";
        }
        
        return personEducationMsg;
        
    }

}
