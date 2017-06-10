/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Pharmacist;
import com.ubt.healthcare.dto.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author F
 */
public class PharmacistService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<Pharmacist> pharmacistRepo;

    public PharmacistService() {
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
    public List<Pharmacist> findPharmacistsByParameters(String name, String surname, String city)throws Exception {
        pharmacistRepo = (List<Pharmacist>) (Object) sqlRepository.findAll("Pharmacist.findAll");
        List<Pharmacist> pharmacistList = new ArrayList<>();
        List<Pharmacist> surNameList = new ArrayList<>();
        List<Pharmacist> cityList = new ArrayList<>();

        if (inputValidation.validateInput(name)) {
            pharmacistRepo.stream().filter((pharmacist) -> (pharmacist.getPersonId().getFirstName().equals(name)))
                    .forEachOrdered((pharmacist) -> {
                        pharmacistList.add(pharmacist);
                    });
            if (inputValidation.validateInput(surname)) {

                pharmacistList.stream().filter((pharmacist) -> (pharmacist.getPersonId().getLastName().equals(surname)))
                        .forEachOrdered((pharmacist) -> {
                            surNameList.add(pharmacist);
                        });

                if (inputValidation.validateInput(city)) {
                    pharmacistList.stream().filter((pharmacist) -> (pharmacist.getPersonId().getAddressId()
                            .getCityId().getCityName().equals(city)))
                            .forEachOrdered((pharmacist) -> {
                                cityList.add(pharmacist);
                            });
                    return cityList;
                }
                return surNameList;
            } else if (inputValidation.validateInput(city)) {

                pharmacistList.stream().filter((pharmacist) -> (pharmacist.getPersonId().getAddressId()
                        .getCityId().getCityName().equals(city)))
                        .forEachOrdered((pharmacist) -> {
                            cityList.add(pharmacist);
                        });
                return cityList;
            }
            return pharmacistList;
        } else if (inputValidation.validateInput(surname)) {
            pharmacistRepo.stream().filter((pharmacist) -> (pharmacist.getPersonId().getLastName().equals(surname)))
                    .forEachOrdered((pharmacist) -> {
                        pharmacistList.add(pharmacist);
                    });
            if (inputValidation.validateInput(city)) {
                pharmacistList.stream().filter((pharmacist) -> (pharmacist.getPersonId().getAddressId()
                        .getCityId().getCityName().equals(city)))
                        .forEachOrdered((pharmacist) -> {
                            cityList.add(pharmacist);
                        });
                return cityList;
            }
            return pharmacistList;

        } else {
            pharmacistRepo.stream().filter((pharmacist) -> (pharmacist.getPersonId().getAddressId()
                    .getCityId().getCityName().equals(city)))
                    .forEachOrdered((pharmacist) -> {
                        pharmacistList.add(pharmacist);
                    });

        }

        return pharmacistList;
    }

    public String persistPharmacist(Pharmacist pharmacist)throws Exception {

        String pharmacistMsg = null;

        Person person = pharmacist.getPersonId();

        pharmacistMsg = checkIfPharmacistExists(pharmacist);

        if ("Save".equals(pharmacistMsg)) {
            sqlRepository.add(person);

        }

        return pharmacistMsg;
    }

    public String editPharmacist(Pharmacist pharmacist)throws Exception {

        String pharmacistMsg = null;

        pharmacistMsg = checkIfPharmacistExists(pharmacist);

        if ("Exist".equals(pharmacistMsg)) {
            sqlRepository.update(pharmacist.getPersonId());

        }

        return pharmacistMsg;
    }

    private String checkIfPharmacistExists(Pharmacist pharmacist)throws Exception {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlRepository.findAll("Pharmacist.findAll");
        for (Object o : docs) {
            if (((Pharmacist) o).getPersonId().getPersonId().equals(pharmacist.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }
}
