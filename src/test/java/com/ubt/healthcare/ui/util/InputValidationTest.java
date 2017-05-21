/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.util;

import java.util.Calendar;
import java.util.Date;
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
public class InputValidationTest {
    
    public InputValidationTest() {
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
     * Test of validateInput method, of class InputValidation.
     */
    @Test
    public void testValidateInput() {
        System.out.println("validateInput");
        String msg = "";
        InputValidation instance = new InputValidation();
        boolean expResult = false;
        boolean result = instance.validateInput(msg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validatePersonID method, of class InputValidation.
     */
    @Test
    public void testValidatePersonID() {
        System.out.println("validatePersonID");
        String personId = "";
        InputValidation instance = new InputValidation();
        String expResult = "";
        String result = instance.validatePersonID(personId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validatePersonFirstName method, of class InputValidation.
     */
    @Test
    public void testValidatePersonFirstName() {
        System.out.println("validatePersonFirstName");
        String firstName = "";
        InputValidation instance = new InputValidation();
        String expResult = "";
        String result = instance.validatePersonFirstName(firstName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validatePersonLastName method, of class InputValidation.
     */
    @Test
    public void testValidatePersonLastName() {
        System.out.println("validatePersonLastName");
        String lastName = "";
        InputValidation instance = new InputValidation();
        String expResult = "";
        String result = instance.validatePersonLastName(lastName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validatePersonDateOfBirth method, of class InputValidation.
     */
    @Test
    public void testValidatePersonDateOfBirth() {
        Calendar calendar =  Calendar.getInstance();
        calendar.set(2017, 4, 21);
        InputValidation instance = new InputValidation();
        String result = instance.validatePersonDateOfBirth(calendar.getTime());
        System.out.println(result);
    }

    /**
     * Test of validateEducationDateStartEnd method, of class InputValidation.
     */
    @Test
    public void testValidateEducationDateStartEnd() {
        System.out.println("validateEducationDateStartEnd");
        Date dateStart = null;
        Date dateEnd = null;
        InputValidation instance = new InputValidation();
        String expResult = "";
        String result = instance.validateEducationDateStartEnd(dateStart, dateEnd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
