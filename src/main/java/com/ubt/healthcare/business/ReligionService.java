/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Religion;
import java.util.List;

/**
 *
 * @author F
 */
public class ReligionService {

    private SQLRepository sqlRepository;

    public ReligionService() {
        sqlRepository = new SQLRepository();
    }


    public Religion findTheReligion(String religion)throws Exception {
        Religion msg = null;
        List<Object> docs = (List<Object>) sqlRepository.findAll("Religion.findAll");
        for (Object o : docs) {
            if (((Religion) o).getName().equals(religion)) {
                msg = (Religion) o;
            }
        }

        return msg;
    }
}
