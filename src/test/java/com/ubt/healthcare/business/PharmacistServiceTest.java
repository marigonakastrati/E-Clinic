/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dto.Pharmacist;
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
public class PharmacistServiceTest {
    
    public PharmacistServiceTest() {
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
     * Test of findPharmacistsByParameters method, of class PharmacistService.
     */
    @Test
    public void testFindPharmacistsByParameters() throws Exception {
        System.out.println("findPharmacistsByParameters");
        String name = "";
        String surname = "";
        String city = "";
        PharmacistService instance = new PharmacistService();
        List<Pharmacist> expResult = null;
        List<Pharmacist> result = instance.findPharmacistsByParameters(name, surname, city);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of persistPharmacist method, of class PharmacistService.
     * @throws java.lang.Exception
     */
    @Test
    public void testPersistPharmacist() throws Exception {
        System.out.println("persistPharmacist");
        Pharmacist pharmacist = null;
        PharmacistService instance = new PharmacistService();
        String expResult = "";
        String result = instance.persistPharmacist(pharmacist);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editPharmacist method, of class PharmacistService.
     * @throws java.lang.Exception
     */
    @Test
    public void testEditPharmacist() throws Exception {
        System.out.println("editPharmacist");
        Pharmacist pharmacist = null;
        PharmacistService instance = new PharmacistService();
        String expResult = "";
        String result = instance.editPharmacist(pharmacist);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
