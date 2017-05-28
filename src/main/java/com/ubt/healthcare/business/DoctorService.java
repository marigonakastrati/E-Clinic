/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author F
 */
public class DoctorService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<Doctor> doctorRepo;

    public DoctorService() {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
    }

    /**
     * Fix the Validation...
     *
     * @param name
     * @param surname
     * @param city
     * @return List
     */
    public List<Doctor> findDoctorsByParameters(String name, String surname, String city) {
        if (doctorRepo == null) {
            doctorRepo = (List<Doctor>) (Object) sqlRepository.findAll("Doctor.findAll");
        }
        List<Doctor> doctorList = new ArrayList<>();
        List<Doctor> surNameList = new ArrayList<>();
        List<Doctor> cityList = new ArrayList<>();

        if (inputValidation.validateInput(name)) {
            doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getFirstName().equals(name)))
                    .forEachOrdered((doctor) -> {
                        doctorList.add(doctor);
                    });
            if (inputValidation.validateInput(surname)) {

                doctorList.stream().filter((doctor) -> (doctor.getPersonId().getLastName().equals(surname)))
                        .forEachOrdered((doctor) -> {
                            surNameList.add(doctor);
                        });

                if (inputValidation.validateInput(city)) {
                    doctorList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                            .getCityId().getCityName().equals(city)))
                            .forEachOrdered((doctor) -> {
                                cityList.add(doctor);
                            });
                    return cityList;
                }
                return surNameList;
            } else if (inputValidation.validateInput(city)) {

                doctorList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                        .getCityId().getCityName().equals(city)))
                        .forEachOrdered((doctor) -> {
                            cityList.add(doctor);
                        });
                return cityList;
            }
            return doctorList;
        } else if (inputValidation.validateInput(surname)) {
            doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getLastName().equals(surname)))
                    .forEachOrdered((doctor) -> {
                        doctorList.add(doctor);
                    });
            if (inputValidation.validateInput(city)) {
                doctorList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                        .getCityId().getCityName().equals(city)))
                        .forEachOrdered((doctor) -> {
                            cityList.add(doctor);
                        });
                return cityList;
            }
            return doctorList;

        } else {
            doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                    .getCityId().getCityName().equals(city)))
                    .forEachOrdered((doctor) -> {
                        doctorList.add(doctor);
                    });

        }

        return doctorList;
    }

    public String persistDoctor(Doctor doctor) {

        String doctorMsg = null;

        Person person = doctor.getPersonId();

        doctorMsg = checkIfDoctorExists(doctor);

        if ("Save".equals(doctorMsg)) {
            sqlRepository.add(person);

        }

        return doctorMsg;
    }

    public String editDoctor(Doctor doctor) {

        String doctorMsg = null;

        Person person = doctor.getPersonId();

        doctorMsg = checkIfDoctorExists(doctor);

        if ("Exist".equals(doctorMsg)) {
            sqlRepository.update(person);

        }

        return doctorMsg;
    }

    private String checkIfDoctorExists(Doctor doctor) {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlRepository.findAll("Doctor.findAll");
        for (Object o : docs) {
            if (((Doctor) o).getPersonId().getPersonId().equals(doctor.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }
}
