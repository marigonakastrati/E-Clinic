/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Person;
import com.ubt.healthcare.dto.Receptionist;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
     * @throws java.lang.Exception
     */
    @Deprecated
    public List<Receptionist> findDoctorsByParameters(String name, String surname, String city) throws Exception {
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

    public String persistReceptionist(Receptionist receptionist) throws Exception {

        String receptionistMsg = null;

        Person person = receptionist.getPersonId();

        receptionistMsg = checkIfReceptionistExists(receptionist);

        if ("Save".equals(receptionistMsg)) {
            sqlRepository.add(person);

        }

        return receptionistMsg;
    }

    public String editReceptionist(Receptionist receptionist) throws Exception {

        String receptionistMsg = null;

        receptionistMsg = checkIfReceptionistExists(receptionist);

        if ("Exist".equals(receptionistMsg)) {
            sqlRepository.update(receptionist.getPersonId());

        }

        return receptionistMsg;
    }

    private String checkIfReceptionistExists(Receptionist receptionist) throws Exception {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlRepository.findAll("Receptionist.findAll");
        for (Object o : docs) {
            if (((Receptionist) o).getPersonId().getPersonId().equals(receptionist.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }

    public List<Receptionist> findReceptionistByParametersLambda(String name, String surname, String city) throws Exception {
        receptionistList = (List<Receptionist>) (Object) sqlRepository.findAll("Receptionist.findAll");
        Predicate<Receptionist> doctorFirstNamePredicate = (Receptionist d) -> d.getPersonId().getFirstName().equals(name);
        Predicate<Receptionist> doctorLastNamePredicate = (Receptionist d) -> d.getPersonId().getLastName().equals(surname);
        Predicate<Receptionist> doctorCityPredicate = (Receptionist d) -> d.getPersonId().getAddressId().getCityId().getCityName().equals(city);

        List<Receptionist> a = inputValidation.validateInput(name) == true ? filter(receptionistList, doctorFirstNamePredicate) : receptionistList;
        List<Receptionist> b = inputValidation.validateInput(surname) == true ? filter(a, doctorLastNamePredicate) : a;
        List<Receptionist> c = inputValidation.validateInput(city) == true ? filter(b, doctorCityPredicate) : b;
        return c;
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        list.stream().filter((s) -> (p.test(s))).forEachOrdered((s) -> {
            result.add(s);
        });
        return result;
    }
}
