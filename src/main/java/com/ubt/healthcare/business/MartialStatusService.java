/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.MartialStatus;
import com.ubt.healthcare.dto.PersonEducation;
import java.util.List;

/**
 *
 * @author F
 */
public class MartialStatusService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<PersonEducation> personEducation;
    private List<Doctor> doctorRepo;
    private UserValidation userValidation;
    private boolean personEducationChanged;//use it as synchronization mechanizm...
    private boolean doctorRepoChanged;

    public MartialStatusService() {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
        userValidation = new UserValidation();
    }

    public MartialStatus findTheMartialStatus(String martialStatus) {
        MartialStatus msg = null;
        List<Object> docs = (List<Object>) sqlRepository.findAll("MartialStatus.findAll");
        for (Object o : docs) {
            if (((MartialStatus) o).getMartialStatusName().equals(martialStatus)) {
                msg = (MartialStatus) o;
            }
        }

        return msg;
    }
}