/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dto.Doctor;
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
     * Test of findDoctorsByParameters method, of class DoctorService.
     */
    @Test
    public void testFindDoctorsByParameters() {
        System.out.println("findDoctorsByParameters");
        String name = "";
        String surname = "";
        String city = "";
        DoctorService instance = new DoctorService();
        List<Doctor> expResult = null;
        List<Doctor> result = instance.findDoctorsByParameters(name, surname, city);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of persistDoctor method, of class DoctorService.
     */
    @Test
    public void testPersistDoctor() {
        System.out.println("persistDoctor");
        Doctor doctor = null;
        DoctorService instance = new DoctorService();
        String expResult = "";
        String result = instance.persistDoctor(doctor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editDoctor method, of class DoctorService.
     */
    @Test
    public void testEditDoctor() {
        Doctor doctor = null;
        
        DoctorService instance = new DoctorService();
        List<Doctor> list = instance.findDoctorsByParameters("Blerim", "Zylfiu", "Prishtina");
        for (Doctor doctor1 : list) {
            if(doctor1.getPersonId().getFirstName().equals("Blerim"))
                doctor = doctor1;
        }
        doctor.getPersonId().setMiddleName("Blerim");
        String result = instance.editDoctor(doctor);
        

    }
    
}
