/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.entity;

import com.ubt.healthcare.dao.SQLRepository;
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
public class AdminClinicTest {
    
    public AdminClinicTest() {
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
     * Test of getAdminClinicId method, of class AdminClinic.
     */
    @Test
    public void testGetAdminClinicId() {
        System.out.println("getAdminClinicId");
        AdminClinic instance = new AdminClinic();
        Integer expResult = null;
        Integer result = instance.getAdminClinicId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdminClinicId method, of class AdminClinic.
     */
    @Test
    public void testSetAdminClinicId() {
        System.out.println("setAdminClinicId");
        Integer adminClinicId = null;
        AdminClinic instance = new AdminClinic();
        instance.setAdminClinicId(adminClinicId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassCode method, of class AdminClinic.
     */
    @Test
    public void testGetPassCode() {
        System.out.println("getPassCode");
        AdminClinic instance = new AdminClinic();
        String expResult = "";
        String result = instance.getPassCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassCode method, of class AdminClinic.
     */
    @Test
    public void testSetPassCode() {
        System.out.println("setPassCode");
        String passCode = "";
        AdminClinic instance = new AdminClinic();
        instance.setPassCode(passCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersonId method, of class AdminClinic.
     */
    @Test
    public void testGetPersonId() {
        System.out.println("getPersonId");
        AdminClinic instance = new AdminClinic();
        Person expResult = null;
        Person result = instance.getPersonId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonId method, of class AdminClinic.
     */
    @Test
    public void testSetPersonId() {
        System.out.println("setPersonId");
        Person personId = null;
        AdminClinic instance = new AdminClinic();
        instance.setPersonId(personId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class AdminClinic.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        AdminClinic instance = new AdminClinic();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class AdminClinic.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        AdminClinic instance = new AdminClinic();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class AdminClinic.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        AdminClinic instance = new AdminClinic();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
     @Test
    public void testLogin() {
         AdminClinic admin = new AdminClinic();
         SQLRepository sqlrepo = new SQLRepository();
         AdminClinic a = (AdminClinic)sqlrepo.findById(50500000);
         
    }
    
}
