/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dto;

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
public class UserGroupTest {
    
    public UserGroupTest() {
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
     * Test of getUserId method, of class UserGroup.
     */
    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        UserGroup instance = new UserGroup();
        Integer expResult = null;
        Integer result = instance.getUserId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserId method, of class UserGroup.
     */
    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        Integer userId = null;
        UserGroup instance = new UserGroup();
        instance.setUserId(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsrGroupId method, of class UserGroup.
     */
    @Test
    public void testGetUsrGroupId() {
        System.out.println("getUsrGroupId");
        UserGroup instance = new UserGroup();
        Integer expResult = null;
        Integer result = instance.getUsrGroupId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsrGroupId method, of class UserGroup.
     */
    @Test
    public void testSetUsrGroupId() {
        System.out.println("setUsrGroupId");
        Integer usrGroupId = null;
        UserGroup instance = new UserGroup();
        instance.setUsrGroupId(usrGroupId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupId method, of class UserGroup.
     */
    @Test
    public void testGetGroupId() {
        System.out.println("getGroupId");
        UserGroup instance = new UserGroup();
        LoginGroup expResult = null;
        LoginGroup result = instance.getGroupId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroupId method, of class UserGroup.
     */
    @Test
    public void testSetGroupId() {
        System.out.println("setGroupId");
        LoginGroup groupId = null;
        UserGroup instance = new UserGroup();
        instance.setGroupId(groupId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UserGroup.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserGroup instance = new UserGroup();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class UserGroup.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        UserGroup instance = new UserGroup();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class UserGroup.
     */
    @Test
    public void testUserGroup() {
        UserGroup instance = new UserGroup();
        SQLRepository repo = new SQLRepository();
        Object ob = repo.findById(50500000, "UserGroup.findByUserId", "userId");
        System.out.println(ob);
    }
    
}
