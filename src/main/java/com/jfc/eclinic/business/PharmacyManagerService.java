/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.PharmacyManager;
import com.ubt.healthcare.dto.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marigona
 */
public class PharmacyManagerService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<PharmacyManager> pharmacyManagerRepo;

    public PharmacyManagerService() {
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
    public List<PharmacyManager> findPharmacyManagersByParameters(String name, String surname, String city)throws Exception {
        pharmacyManagerRepo = (List<PharmacyManager>) (Object) sqlRepository.findAll("PharmacyManager.findAll");
        List<PharmacyManager> pharmacyManagerList = new ArrayList<>();
        List<PharmacyManager> surNameList = new ArrayList<>();
        List<PharmacyManager> cityList = new ArrayList<>();

        if (inputValidation.validateInput(name)) {
            pharmacyManagerRepo.stream().filter((pharmacyManager) -> (pharmacyManager.getPersonId().getFirstName().equals(name)))
                    .forEachOrdered((pharmacyManager) -> {
                        pharmacyManagerList.add(pharmacyManager);
                    });
            if (inputValidation.validateInput(surname)) {

                pharmacyManagerList.stream().filter((pharmacyManager) -> (pharmacyManager.getPersonId().getLastName().equals(surname)))
                        .forEachOrdered((pharmacyManager) -> {
                            surNameList.add(pharmacyManager);
                        });

                if (inputValidation.validateInput(city)) {
                    pharmacyManagerList.stream().filter((pharmacyManager) -> (pharmacyManager.getPersonId().getAddressId()
                            .getCityId().getCityName().equals(city)))
                            .forEachOrdered((pharmacyManager) -> {
                                cityList.add(pharmacyManager);
                            });
                    return cityList;
                }
                return surNameList;
            } else if (inputValidation.validateInput(city)) {

                pharmacyManagerList.stream().filter((pharmacyManager) -> (pharmacyManager.getPersonId().getAddressId()
                        .getCityId().getCityName().equals(city)))
                        .forEachOrdered((pharmacyManager) -> {
                            cityList.add(pharmacyManager);
                        });
                return cityList;
            }
            return pharmacyManagerList;
        } else if (inputValidation.validateInput(surname)) {
            pharmacyManagerRepo.stream().filter((pharmacyManager) -> (pharmacyManager.getPersonId().getLastName().equals(surname)))
                    .forEachOrdered((pharmacyManager) -> {
                        pharmacyManagerList.add(pharmacyManager);
                    });
            if (inputValidation.validateInput(city)) {
                pharmacyManagerList.stream().filter((pharmacyManager) -> (pharmacyManager.getPersonId().getAddressId()
                        .getCityId().getCityName().equals(city)))
                        .forEachOrdered((pharmacyManager) -> {
                            cityList.add(pharmacyManager);
                        });
                return cityList;
            }
            return pharmacyManagerList;

        } else {
            pharmacyManagerRepo.stream().filter((pharmacyManager) -> (pharmacyManager.getPersonId().getAddressId()
                    .getCityId().getCityName().equals(city)))
                    .forEachOrdered((pharmacyManager) -> {
                        pharmacyManagerList.add(pharmacyManager);
                    });

        }

        return pharmacyManagerList;
    }

    public String persistPharmacyManager(PharmacyManager pharmacyManager)throws Exception {

        String pharmacyManagerMsg = null;

        Person person = pharmacyManager.getPersonId();

        pharmacyManagerMsg = checkIfPharmacyManagerExists(pharmacyManager);

        if ("Save".equals(pharmacyManagerMsg)) {
            sqlRepository.add(person);

        }

        return pharmacyManagerMsg;
    }

    public String editPharmacyManager(PharmacyManager pharmacyManager)throws Exception {

        String pharmacyManagerMsg = null;

        pharmacyManagerMsg = checkIfPharmacyManagerExists(pharmacyManager);

        if ("Exist".equals(pharmacyManagerMsg)) {
            sqlRepository.update(pharmacyManager.getPersonId());

        }

        return pharmacyManagerMsg;
    }

    private String checkIfPharmacyManagerExists(PharmacyManager pharmacyManager)throws Exception {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlRepository.findAll("PharmacyManager.findAll");
        for (Object o : docs) {
            if (((PharmacyManager) o).getPersonId().getPersonId().equals(pharmacyManager.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }
}
