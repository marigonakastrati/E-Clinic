/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.MartialStatus;
import java.util.List;

/**
 *
 * @author F
 */
public class MartialStatusService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;

    public MartialStatusService() {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
    }

    public MartialStatus findTheMartialStatus(String martialStatus)throws Exception {
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
