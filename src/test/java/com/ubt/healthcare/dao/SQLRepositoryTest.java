/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dao;

import com.ubt.healthcare.dto.AdminClinic;
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
public class SQLRepositoryTest {
    
    public SQLRepositoryTest() {
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
     * Test of add method, of class SQLRepository.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object student = null;
        SQLRepository instance = new SQLRepository();
        instance.add(student);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class SQLRepository.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Object student = null;
        SQLRepository instance = new SQLRepository();
        instance.update(student);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class SQLRepository.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Object student = null;
        SQLRepository instance = new SQLRepository();
        instance.remove(student);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class SQLRepository.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        String entity = "";
        SQLRepository instance = new SQLRepository();
        List<Object> expResult = null;
        List<Object> result = instance.findAll(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class SQLRepository.
     */
    @Test
    public void testFindById() {

        SQLRepository instance = new SQLRepository();
        AdminClinic result = (AdminClinic)instance.findById(50500000, "AdminClinic.findByAdminClinicId", "adminClinicId");
        System.out.println(result.getPassCode());
    }
    
}
