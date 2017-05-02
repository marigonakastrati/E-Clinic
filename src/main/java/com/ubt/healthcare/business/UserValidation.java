/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Address;
import com.ubt.healthcare.dto.AdminClinic;
import com.ubt.healthcare.dto.City;
import com.ubt.healthcare.dto.Country;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Gender;
import com.ubt.healthcare.dto.MartialStatus;
import com.ubt.healthcare.dto.Nurse;
import com.ubt.healthcare.dto.Patient;
import com.ubt.healthcare.dto.Person;
import com.ubt.healthcare.dto.Pharmacist;
import com.ubt.healthcare.dto.PharmacyManager;
import com.ubt.healthcare.dto.Receptionist;
import com.ubt.healthcare.dto.Religion;
import java.util.List;

/**
 *
 * @author F REGEX
 */
public class UserValidation {

    private SQLRepository sqlrepo;

    public UserValidation() {
        sqlrepo = new SQLRepository();
    }

    public String validateUser(String user) {
        String msg = null;
        if (user.trim().isEmpty()) {
            msg = "The user is empty";
        } else if (user.equals("Some criteria")) {
            // msg = You have typed some wrong text
        } else {
            msg = "Validated";
        }

        return msg;
    }
// validation code
    public String validatePerson(Person person) {
        String msg = null;
        if (person.getPersonId()> 1) {
            return "Validated";
        }

        return msg;
    }

    public String checkIfAddressExists(String streetName, String postCode) {
        String msg = "Save";
        List<Object> address = (List<Object>) sqlrepo.findAll("Address.findAll");
        for (Object o : address) {
            if (((Address) o).getPostCode().equals(postCode) && ((Address) o).getStreetName().equals(streetName)) {
                msg = "Exist";
            }
        }

        return msg;
    }

    public String checkIfUserExists(Person p) {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlrepo.findAll("Person.findAll");
        for (Object o : docs) {
            if (((Person) o).getPersonId().equals(p.getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }

    public String checkIfDoctorExists(Doctor p) {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlrepo.findAll("Doctor.findAll");
        for (Object o : docs) {
            if (((Doctor) o).getPersonId().getPersonId().equals(p.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }

    public String checkIfNurseExists(Nurse p) {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlrepo.findAll("Nurse.findAll");
        for (Object o : docs) {
            if (((Nurse) o).getPersonId().getPersonId().equals(p.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }

    public String checkIfPatientExists(Patient p) {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlrepo.findAll("Patient.findAll");
        for (Object o : docs) {
            if (((Patient) o).getPersonId().getPersonId().equals(p.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }

    public String checkIfPharmacistExists(Pharmacist p) {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlrepo.findAll("Pharmacist.findAll");
        for (Object o : docs) {
            if (((Pharmacist) o).getPersonId().getPersonId().equals(p.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }

    public String checkIfPharmacyManagerExists(PharmacyManager p) {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlrepo.findAll("PharmacyManager.findAll");
        for (Object o : docs) {
            if (((PharmacyManager) o).getPersonId().getPersonId().equals(p.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }

    public String checkIfReceptionistExists(Receptionist p) {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlrepo.findAll("Receptionist.findAll");
        for (Object o : docs) {
            if (((Receptionist) o).getPersonId().getPersonId().equals(p.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }

    public String checkIfAdminClinicExists(AdminClinic p) {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlrepo.findAll("AdminClinic.findAll");
        for (Object o : docs) {
            if (((AdminClinic) o).getPersonId().getPersonId().equals(p.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }

    public MartialStatus findTheMartialStatus() {
        MartialStatus msg = null;
        List<Object> docs = (List<Object>) sqlrepo.findAll("MartialStatus.findAll");
        for (Object o : docs) {
            if (((MartialStatus) o).getMartialStatusName().equals("Single")) {
                msg = (MartialStatus) o;
            }
        }

        return msg;
    }

    public Religion findTheReligion() {
        Religion msg = null;
        List<Object> docs = (List<Object>) sqlrepo.findAll("Religion.findAll");
        for (Object o : docs) {
            if (((Religion) o).getName().equals("Muslim")) {
                msg = (Religion) o;
            }
        }

        return msg;
    }

    public Gender findTheGender() {
        Gender msg = null;
        List<Object> docs = (List<Object>) sqlrepo.findAll("Gender.findAll");
        for (Object o : docs) {
            if (((Gender) o).getGenderName().trim().equals("FEMALE")) {
                msg = (Gender) o;
            }
        }

        return msg;
    }

    public Country findTheCountry(String country) {
        Country msg = null;
        List<Object> docs = (List<Object>) sqlrepo.findAll("Country.findAll");
        for (Object o : docs) {
            if (((Country) o).getCountryName().equals(country)) {
                msg = (Country) o;
            }
        }

        return msg;
    }

    public City findTheCity(String country) {
        City msg = null;
        List<Object> docs = (List<Object>) sqlrepo.findAll("City.findAll");
        for (Object o : docs) {
            if (((City) o).getCityName().equals(country)) {
                msg = (City) o;
            }
        }

        return msg;
    }
}
