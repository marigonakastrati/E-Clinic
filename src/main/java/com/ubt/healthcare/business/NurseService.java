/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Nurse;
import com.ubt.healthcare.dto.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author F
 */
public class NurseService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<Nurse> nurseRepo;

    public NurseService() {
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
    public List<Nurse> findDoctorsByParameters(String name, String surname, String city)throws Exception {
        nurseRepo = (List<Nurse>) (Object) sqlRepository.findAll("Nurse.findAll");
        List<Nurse> doctorList = new ArrayList<>();
        List<Nurse> surNameList = new ArrayList<>();
        List<Nurse> cityList = new ArrayList<>();

        if (inputValidation.validateInput(name)) {
            nurseRepo.stream().filter((doctor) -> (doctor.getPersonId().getFirstName().equals(name)))
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
            nurseRepo.stream().filter((doctor) -> (doctor.getPersonId().getLastName().equals(surname)))
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
            nurseRepo.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                    .getCityId().getCityName().equals(city)))
                    .forEachOrdered((doctor) -> {
                        doctorList.add(doctor);
                    });

        }

        return doctorList;
    }

    public String persistNurse(Nurse nurse)throws Exception {

        String doctorMsg = null;

        Person person = nurse.getPersonId();

        doctorMsg = checkIfNurseExists(nurse);

        if ("Save".equals(doctorMsg)) {
            sqlRepository.add(person);

        }

        return doctorMsg;
    }

    public String editDoctor(Nurse nurse) throws Exception{

        String doctorMsg = null;

        doctorMsg = checkIfNurseExists(nurse);

        if ("Exist".equals(doctorMsg)) {
            sqlRepository.update(nurse.getPersonId());

        }

        return doctorMsg;
    }

    private String checkIfNurseExists(Nurse nurse)throws Exception {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlRepository.findAll("Nurse.findAll");
        for (Object o : docs) {
            if (((Nurse) o).getPersonId().getPersonId().equals(nurse.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }
}
