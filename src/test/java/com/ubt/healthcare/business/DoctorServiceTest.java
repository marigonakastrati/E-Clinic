/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Schedule;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author F
 */
public class DoctorServiceTest {

    public DoctorServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of editDoctor method, of class DoctorService.
     */
    @Test
    public void testEditDoctor() {
        try {
            Doctor doctor = null;
            DoctorService instance = new DoctorService();
            List<Doctor> list = instance.findDoctorsByParameters("Blerim", "Zylfiu", "Prishtina");
            for (Doctor doctor1 : list) {
                if (doctor1.getPersonId().getFirstName().equals("Blerim")) {
                    doctor = doctor1;
                }
            }
            doctor.getPersonId().setMiddleName("Blerim");
            String result = instance.editDoctor(doctor);
        } catch (Exception ex) {
        }

    }

    @Test
    public void testFindDoctorByParameters() {
        DoctorService doctorService = new DoctorService();
        List<Doctor> doctorList = null;
        try {
            doctorList = doctorService.findDoctorByParametersLambda("Fatlonder", "", "");
        } catch (Exception ex) {
        }
        assertNotNull(doctorList);
    }


}
