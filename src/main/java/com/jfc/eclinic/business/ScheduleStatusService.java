/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.ScheduleStatus;
import java.util.List;

/**
 *
 * @author F
 */
public class ScheduleStatusService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;

    public ScheduleStatusService() {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
    }

    public ScheduleStatus findTheScheduleStatus(String scheduleStatus)throws Exception {
        ScheduleStatus msg = null;
        List<Object> docs = (List<Object>) sqlRepository.findAll("ScheduleStatus.findAll");
        for (Object o : docs) {
            if (((ScheduleStatus) o).getStatusName().equals(scheduleStatus)) {
                msg = (ScheduleStatus) o;
            }
        }

        return msg;
    }
}
