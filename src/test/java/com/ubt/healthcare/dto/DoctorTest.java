/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dto;

import com.ubt.healthcare.dao.SQLRepository;
import java.util.Collection;
import java.util.Set;
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
public class DoctorTest {
    
    public DoctorTest() {
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
     * Test of getPassCode method, of class Doctor.
     */
    @Test
    public void testGetPassCode() {
        System.out.println("getPassCode");
        Doctor instance = new Doctor();
        String expResult = "";
        String result = instance.getPassCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassCode method, of class Doctor.
     */
    @Test
    public void testSetPassCode() {
        System.out.println("setPassCode");
        String passCode = "";
        Doctor instance = new Doctor();
        instance.setPassCode(passCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDoctorId method, of class Doctor.
     */
    @Test
    public void testGetDoctorId() {
        System.out.println("getDoctorId");
        Doctor instance = new Doctor();
        Integer expResult = null;
        Integer result = instance.getDoctorId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDoctorId method, of class Doctor.
     */
    @Test
    public void testSetDoctorId() {
        System.out.println("setDoctorId");
        Integer doctorId = null;
        Doctor instance = new Doctor();
        instance.setDoctorId(doctorId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonId method, of class Doctor.
     */
    @Test
    public void testGetPersonId() {
        System.out.println("getPersonId");
        Doctor instance = new Doctor();
        Person expResult = null;
        Person result = instance.getPersonId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonId method, of class Doctor.
     */
    @Test
    public void testSetPersonId() {
        System.out.println("setPersonId");
        Person personId = null;
        Doctor instance = new Doctor();
        instance.setPersonId(personId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScheduleCollection method, of class Doctor.
     */
    @Test
    public void testGetScheduleCollection() {
        System.out.println("getScheduleCollection");
        Doctor instance = new Doctor();
        Collection<Schedule> expResult = null;
        Collection<Schedule> result = instance.getScheduleCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScheduleCollection method, of class Doctor.
     */
    @Test
    public void testSetScheduleCollection() {
        System.out.println("setScheduleCollection");
        Set<Schedule> scheduleCollection = null;
        Doctor instance = new Doctor();
        instance.setScheduleCollection(scheduleCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Doctor.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Doctor instance = new Doctor();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Doctor.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Doctor instance = new Doctor();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Doctor.
     */
    @Test
    public void testToString() {
        try
        {
       
        SQLRepository repo = new SQLRepository();
        Doctor doc = (Doctor)repo.findById(1234569788, "Doctor.findByPersonId", "personId");
        System.out.println(doc.getDoctorId());
        }catch(Exception ex)
        {
            
        }
    }
    
}
