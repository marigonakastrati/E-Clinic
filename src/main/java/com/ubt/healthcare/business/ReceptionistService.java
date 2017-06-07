/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Nurse;
import com.ubt.healthcare.dto.Person;
import com.ubt.healthcare.dto.Receptionist;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author F
 */
public class ReceptionistService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<Receptionist> receptionistList;

    public ReceptionistService() {
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
    public List<Receptionist> findDoctorsByParameters(String name, String surname, String city)throws Exception {
        receptionistList = (List<Receptionist>) (Object) sqlRepository.findAll("Receptionist.findAll");
        List<Receptionist> recptionistList = new ArrayList<>();
        List<Receptionist> surNameList = new ArrayList<>();
        List<Receptionist> cityList = new ArrayList<>();

        if (inputValidation.validateInput(name)) {
            receptionistList.stream().filter((doctor) -> (doctor.getPersonId().getFirstName().equals(name)))
                    .forEachOrdered((doctor) -> {
                        recptionistList.add(doctor);
                    });
            if (inputValidation.validateInput(surname)) {

                recptionistList.stream().filter((doctor) -> (doctor.getPersonId().getLastName().equals(surname)))
                        .forEachOrdered((doctor) -> {
                            surNameList.add(doctor);
                        });

                if (inputValidation.validateInput(city)) {
                    recptionistList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                            .getCityId().getCityName().equals(city)))
                            .forEachOrdered((doctor) -> {
                                cityList.add(doctor);
                            });
                    return cityList;
                }
                return surNameList;
            } else if (inputValidation.validateInput(city)) {

                recptionistList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                        .getCityId().getCityName().equals(city)))
                        .forEachOrdered((doctor) -> {
                            cityList.add(doctor);
                        });
                return cityList;
            }
            return recptionistList;
        } else if (inputValidation.validateInput(surname)) {
            receptionistList.stream().filter((doctor) -> (doctor.getPersonId().getLastName().equals(surname)))
                    .forEachOrdered((doctor) -> {
                        recptionistList.add(doctor);
                    });
            if (inputValidation.validateInput(city)) {
                recptionistList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                        .getCityId().getCityName().equals(city)))
                        .forEachOrdered((doctor) -> {
                            cityList.add(doctor);
                        });
                return cityList;
            }
            return recptionistList;

        } else {
            receptionistList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                    .getCityId().getCityName().equals(city)))
                    .forEachOrdered((doctor) -> {
                        recptionistList.add(doctor);
                    });

        }

        return recptionistList;
    }

    public String persistReceptionist(Receptionist receptionist)throws Exception {

        String doctorMsg = null;

        Person person = receptionist.getPersonId();

        doctorMsg = checkIfReceptionistExists(receptionist);

        if ("Save".equals(doctorMsg)) {
            sqlRepository.add(person);

        }

        return doctorMsg;
    }

    public String editReceptionist(Receptionist receptionist) throws Exception{

        String doctorMsg = null;

        doctorMsg = checkIfReceptionistExists(receptionist);

        if ("Exist".equals(doctorMsg)) {
            sqlRepository.update(receptionist.getPersonId());

        }

        return doctorMsg;
    }

       private String checkIfReceptionistExists(Receptionist receptionist)throws Exception {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlRepository.findAll("Receptionist.findAll");
        for (Object o : docs) {
            if (((Nurse) o).getPersonId().getPersonId().equals(receptionist.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }
}
