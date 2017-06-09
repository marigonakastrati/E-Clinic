/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

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
public class ScheduleServiceTest {
    
    public ScheduleServiceTest() {
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
     * Test of findDoctorShift method, of class ScheduleService.
     */
    @Test
    public void testFindDoctorShift() throws Exception {
        System.out.println("findDoctorShift");
        String name = "";
        String surname = "";
        String statusOfShift = "";
        Date dateOfShift = null;
        ScheduleService instance = new ScheduleService();
        List<Schedule> expResult = null;
        List<Schedule> result = instance.findDoctorShift(name, surname, statusOfShift, dateOfShift);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testFindDoctorSchedule() {
        ScheduleService scheduleService = new ScheduleService();
        List<Schedule> doctorList = null;
        try {
            doctorList = scheduleService.findDoctorShift("1212", "", "Planned",null);
        } catch (Exception ex) {
        }
        assertNotNull(doctorList);
    }
}
