/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Person;
import com.ubt.healthcare.dto.Schedule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author F
 */
public class DoctorService {

    private SQLRepository sqlRepository;
    private InputValidation inputValidation;
    private List<Doctor> doctorRepo;

    public DoctorService() {
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
    public List<Doctor> findDoctorsByParameters(String name, String surname, String city) throws Exception {
        doctorRepo = (List<Doctor>) (Object) sqlRepository.findAll("Doctor.findAll");
        List<Doctor> doctorList = new ArrayList<>();
        List<Doctor> surNameList = new ArrayList<>();
        List<Doctor> cityList = new ArrayList<>();

        if (inputValidation.validateInput(name)) {
            doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getFirstName().equals(name)))
                    .forEachOrdered((doctor) -> {
                        doctorList.add(doctor);
                    });
            if (inputValidation.validateInput(surname)) {

                doctorList.stream().filter((doctor) -> (doctor.getPersonId().getLastName().equals(surname)))
                        .forEachOrdered((doctor) -> {
                            surNameList.add(doctor);
                        });

                if (inputValidation.validateInput(city)) {
                    doctorList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                            .getCityId().getCityName().equals(city)))
                            .forEachOrdered((doctor) -> {
                                cityList.add(doctor);
                            });
                    return cityList;
                }
                return surNameList;
            } else if (inputValidation.validateInput(city)) {

                doctorList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                        .getCityId().getCityName().equals(city)))
                        .forEachOrdered((doctor) -> {
                            cityList.add(doctor);
                        });
                return cityList;
            }
            return doctorList;
        } else if (inputValidation.validateInput(surname)) {
            doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getLastName().equals(surname)))
                    .forEachOrdered((doctor) -> {
                        doctorList.add(doctor);
                    });
            if (inputValidation.validateInput(city)) {
                doctorList.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                        .getCityId().getCityName().equals(city)))
                        .forEachOrdered((doctor) -> {
                            cityList.add(doctor);
                        });
                return cityList;
            }
            return doctorList;

        } else {
            doctorRepo.stream().filter((doctor) -> (doctor.getPersonId().getAddressId()
                    .getCityId().getCityName().equals(city)))
                    .forEachOrdered((doctor) -> {
                        doctorList.add(doctor);
                    });

        }

        return doctorList;
    }

    public String persistDoctor(Doctor doctor) throws Exception {

        String doctorMsg = null;

        Person person = doctor.getPersonId();

        doctorMsg = checkIfDoctorExists(doctor);

        if ("Save".equals(doctorMsg)) {
            sqlRepository.add(person);

        }

        return doctorMsg;
    }

    public String editDoctor(Doctor doctor) throws Exception {

        String doctorMsg = null;

        doctorMsg = checkIfDoctorExists(doctor);

        if ("Exist".equals(doctorMsg)) {
            sqlRepository.update(doctor.getPersonId());

        }

        return doctorMsg;
    }

    private String checkIfDoctorExists(Doctor doctor) throws Exception {
        String msg = "Save";
        List<Object> docs = (List<Object>) sqlRepository.findAll("Doctor.findAll");
        for (Object o : docs) {
            if (((Doctor) o).getPersonId().getPersonId().equals(doctor.getPersonId().getPersonId())) {
                msg = "Exist";
            }
        }

        return msg;
    }

    public List<Doctor> findDoctorByParametersLambda(String name, String surname, String city) throws Exception {
        doctorRepo = (List<Doctor>) (Object) sqlRepository.findAll("Doctor.findAll");

        Predicate<Doctor> doctorFirstNamePredicate = (Doctor d) -> d.getPersonId().getFirstName().equals(name);
        Predicate<Doctor> doctorLastNamePredicate = (Doctor d) -> d.getPersonId().getLastName().equals(surname);
        Predicate<Doctor> doctorCityPredicate = (Doctor d) -> d.getPersonId().getAddressId().getCityId().getCityName().equals(city);

        List<Doctor> a = inputValidation.validateInput(name) == true ? filter(doctorRepo, doctorFirstNamePredicate) : doctorRepo;
        List<Doctor> b = inputValidation.validateInput(surname) == true ? filter(a, doctorLastNamePredicate) : a;
        List<Doctor> c = inputValidation.validateInput(city) == true ? filter(b, doctorCityPredicate) : b;
        return c;
    }

    public List<Doctor> findDoctorShift(String name, String surname, String statusOfShift, Date dateOfShift) throws Exception {
        
        doctorRepo = (List<Doctor>) (Object) sqlRepository.findAll("Doctor.findAll");

        Predicate<Doctor> doctorFirstNamePredicate = (Doctor d) -> d.getPersonId().getFirstName().equals(name);
        Predicate<Doctor> doctorLastNamePredicate = (Doctor d) -> d.getPersonId().getLastName().equals(surname);

        List<Doctor> a = inputValidation.validateInput(name) == true ? filter(doctorRepo, doctorFirstNamePredicate) : doctorRepo;
        List<Doctor> b = inputValidation.validateInput(surname) == true ? filter(a, doctorLastNamePredicate) : a;
        List<Doctor> c = new ArrayList<>();

        if (inputValidation.validateInput(statusOfShift) || dateOfShift != null) {
            for (Doctor doctor : b) {
                for (Schedule schedule : doctor.getScheduleCollection()) {
                    if (statusOfShift != null && (schedule.getStatus().getStatusName().equals(statusOfShift)) || (dateOfShift != null && schedule.getDateStart().compareTo(dateOfShift) == 0)) {
                        c.add(doctor);
                    }
                }
            }
        }
        /*List<Schedule> a = new ArrayList<>();
        Collection<Schedule> scheduleCollection = doctorRepo.getScheduleCollection();
        scheduleCollection.stream().filter(e -> e.getDateStart().equals(e)).forEach(e -> a.add(e));
        for (Schedule schedule : scheduleCollection) {
            schedule.getDateStart().compareTo(dateOfShift);
            schedule.getStatus().getStatusName().equals(statusOfShift);
        }*/
        return inputValidation.validateInput(statusOfShift) && dateOfShift != null ? c : b;
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        list.stream().filter((s) -> (p.test(s))).forEachOrdered((s) -> {
            result.add(s);
        });
        return result;
    }
}
