/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dto.City;
import com.ubt.healthcare.dto.Country;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Gender;
import com.ubt.healthcare.dto.MartialStatus;
import com.ubt.healthcare.dto.Person;
import com.ubt.healthcare.dto.Religion;
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
public class UserValidationTest {
    
    public UserValidationTest() {
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
     * Test of validateUser method, of class UserValidation.
     */
    @Test
    public void testValidateUser() {
        System.out.println("validateUser");
        String user = "";
        UserValidation instance = new UserValidation();
        String expResult = "";
        String result = instance.validateUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validatePerson method, of class UserValidation.
     */
    @Test
    public void testValidateDoctor() {
        System.out.println("validateDoctor");
        Doctor doctor = null;
        UserValidation instance = new UserValidation();
        String expResult = "";
        String result = instance.validatePerson(doctor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIfAddressExists method, of class UserValidation.
     */
    @Test
    public void testCheckIfAddressExists() {
        System.out.println("checkIfAddressExists");
        String streetName = "";
        String postCode = "";
        UserValidation instance = new UserValidation();
        String expResult = "";
        String result = instance.checkIfAddressExists(streetName, postCode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIfUserExists method, of class UserValidation.
     */
    @Test
    public void testCheckIfUserExists() {
        System.out.println("checkIfUserExists");
        Person p = null;
        UserValidation instance = new UserValidation();
        String expResult = "";
        String result = instance.checkIfUserExists(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIfDoctorExists method, of class UserValidation.
     */
    @Test
    public void testCheckIfDoctorExists() {
        System.out.println("checkIfDoctorExists");
        Doctor p = null;
        UserValidation instance = new UserValidation();
        String expResult = "";
        String result = instance.checkIfDoctorExists(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findTheMartialStatus method, of class UserValidation.
     */
    @Test
    public void testFindTheMartialStatus() {
        System.out.println("findTheMartialStatus");
        UserValidation instance = new UserValidation();
        MartialStatus expResult = null;
        MartialStatus result = instance.findTheMartialStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findTheReligion method, of class UserValidation.
     */
    @Test
    public void testFindTheReligion() {
        System.out.println("findTheReligion");
        UserValidation instance = new UserValidation();
        Religion expResult = null;
        Religion result = instance.findTheReligion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findTheGender method, of class UserValidation.
     */
    @Test
    public void testFindTheGender() {
        System.out.println("findTheGender");
        UserValidation instance = new UserValidation();
        Gender expResult = null;
        Gender result = instance.findTheGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findTheCountry method, of class UserValidation.
     */
    @Test
    public void testFindTheCountry() {
        System.out.println("findTheCountry");
        String country = "";
        UserValidation instance = new UserValidation();
        Country expResult = null;
        Country result = instance.findTheCountry(country);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findTheCity method, of class UserValidation.
     */
    @Test
    public void testFindTheCity() {
        System.out.println("findTheCity");
        String country = "";
        UserValidation instance = new UserValidation();
        City expResult = null;
        City result = instance.findTheCity(country);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
