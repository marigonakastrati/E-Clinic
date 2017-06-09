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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
     * @throws java.lang.Exception
     */
    @Deprecated
    public List<Nurse> findDoctorsByParameters(String name, String surname, String city) throws Exception {
        nurseRepo = (List<Nurse>) (Object) sqlRepository.findAll("Nurse.findAll");
        List<Nurse> nurseList = new ArrayList<>();
        List<Nurse> surNameList = new ArrayList<>();
        List<Nurse> cityList = new ArrayList<>();

        if (inputValidation.validateInput(name)) {
            nurseRepo.stream().filter((doctor) -> (doctor.getPersonId().getFirstName().equals(name)))
                    .forEachOrdered((doctor) -> {
                        nurseList.add(doctor);
                    });
            if (inputValidation.validateInput(surname)) {

                nurseList.stream().filter((doctor) -> (doctor.getPersonId().getLastName().equals(surname)))
                        .forEachOrdered((doctor) -> {
                            surNameList.add(doctor);
                        });

                if (inputValidation.validateInput(city)) {
                    nurseList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                            .getCityId().getCityName().equals(city)))
                            .forEachOrdered((doctor) -> {
                                cityList.add(doctor);
                            });
                    return cityList;
                }
                return surNameList;
            } else if (inputValidation.validateInput(city)) {

                nurseList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                        .getCityId().getCityName().equals(city)))
                        .forEachOrdered((doctor) -> {
                            cityList.add(doctor);
                        });
                return cityList;
            }
            return nurseList;
        } else if (inputValidation.validateInput(surname)) {
            nurseRepo.stream().filter((doctor) -> (doctor.getPersonId().getLastName().equals(surname)))
                    .forEachOrdered((doctor) -> {
                        nurseList.add(doctor);
                    });
            if (inputValidation.validateInput(city)) {
                nurseList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                        .getCityId().getCityName().equals(city)))
                        .forEachOrdered((doctor) -> {
                            cityList.add(doctor);
                        });
                return cityList;
            }
            return nurseList;

        } else {
            nurseRepo.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                    .getCityId().getCityName().equals(city)))
                    .forEachOrdered((doctor) -> {
                        nurseList.add(doctor);
                    });

        }

        return nurseList;
    }

    public String persistNurse(Nurse nurse) throws Exception {

        String nurseMsg = null;

        Person person = nurse.getPersonId();

        nurseMsg = checkIfNurseExists(nurse);

        if ("Save".equals(nurseMsg)) {
            sqlRepository.add(person);

        }

        return nurseMsg;
    }

    public String editDoctor(Nurse nurse) throws Exception {

        String nurseMsg = null;

        nurseMsg = checkIfNurseExists(nurse);

        if ("Exist".equals(nurseMsg)) {
            sqlRepository.update(nurse.getPersonId());

        }

        return nurseMsg;
    }

    private String checkIfNurseExists(Nurse nurse) throws Exception {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlRepository.findAll("Nurse.findAll");
        for (Object o : docs) {
            if (((Nurse) o).getPersonId().getPersonId().equals(nurse.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }

    public List<Nurse> findNurseByParametersLambda(String name, String surname, String city) throws Exception {
        nurseRepo = (List<Nurse>) (Object) sqlRepository.findAll("Nurse.findAll");

        Predicate<Nurse> doctorFirstNamePredicate = (Nurse d) -> d.getPersonId().getFirstName().equals(name);
        Predicate<Nurse> doctorLastNamePredicate = (Nurse d) -> d.getPersonId().getLastName().equals(surname);
        Predicate<Nurse> doctorCityPredicate = (Nurse d) -> d.getPersonId().getAddressId().getCityId().getCityName().equals(city);

        List<Nurse> a = inputValidation.validateInput(name) == true ? filter(nurseRepo, doctorFirstNamePredicate) : nurseRepo;
        List<Nurse> b = inputValidation.validateInput(surname) == true ? filter(a, doctorLastNamePredicate) : a;
        List<Nurse> c = inputValidation.validateInput(city) == true ? filter(b, doctorCityPredicate) : b;
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
