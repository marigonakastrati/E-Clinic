/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Schedule;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author F
 */
public class ScheduleService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<Schedule> scheduleList;

    public ScheduleService() {
        sqlRepository = new SQLRepository();
        inputValidation = new InputValidation();
    }

    public List<Schedule> findDoctorShift(String name, String surname, String statusOfShift, Date dateOfShift) throws Exception {
        scheduleList = (List<Schedule>) (Object) sqlRepository.findAll("Schedule.findAll");

        Predicate<Schedule> scheduleStatusPredicate = (Schedule d) -> d.getStatus().getStatusName().equals(statusOfShift);
        Predicate<Schedule> scheduleDateOfShiftPredicate = (Schedule d) -> d.getDateStart().compareTo(dateOfShift) == 0;

        List<Schedule> a = inputValidation.validateInput(statusOfShift) == true ? filter(scheduleList, scheduleStatusPredicate) : scheduleList;
        List<Schedule> b = dateOfShift != null ? filter(a, scheduleDateOfShiftPredicate) : a;
        List<Schedule> c = new ArrayList<>();

        if (inputValidation.validateInput(name) || inputValidation.validateInput(surname)) {
            for (Schedule schedule : b) {
                if ((inputValidation.validateInput(name) && schedule.getDoctorId().getPersonId().getFirstName().equals(name))
                        || inputValidation.validateInput(surname) && schedule.getDoctorId().getPersonId().getLastName().equals(surname)) {
                    c.add(schedule);
                }
            }
        }

        return inputValidation.validateInput(name) || inputValidation.validateInput(surname) ? c : b;
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        list.stream().filter((s) -> (p.test(s))).forEachOrdered((s) -> {
            result.add(s);
        });
        return result;
    }
}
