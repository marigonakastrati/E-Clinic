/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.entity;

import com.ubt.healthcare.dao.SQLRepository;
import java.util.Collection;
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
public class PersonTest {
    
    public PersonTest() {
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
     * Test of getPersonId method, of class Person.
     */
    @Test
    public void testGetPersonId() {
        System.out.println("getPersonId");
        Person instance = new Person();
        Integer expResult = null;
        Integer result = instance.getPersonId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonId method, of class Person.
     */
    @Test
    public void testSetPersonId() {
        System.out.println("setPersonId");
        Integer personId = null;
        Person instance = new Person();
        instance.setPersonId(personId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class Person.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class Person.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Person instance = new Person();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMiddleName method, of class Person.
     */
    @Test
    public void testGetMiddleName() {
        System.out.println("getMiddleName");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getMiddleName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMiddleName method, of class Person.
     */
    @Test
    public void testSetMiddleName() {
        System.out.println("setMiddleName");
        String middleName = "";
        Person instance = new Person();
        instance.setMiddleName(middleName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Person.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class Person.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Person instance = new Person();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDob method, of class Person.
     */
    @Test
    public void testGetDob() {
        System.out.println("getDob");
        Person instance = new Person();
        Date expResult = null;
        Date result = instance.getDob();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDob method, of class Person.
     */
    @Test
    public void testSetDob() {
        System.out.println("setDob");
        Date dob = null;
        Person instance = new Person();
        instance.setDob(dob);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBirthState method, of class Person.
     */
    @Test
    public void testGetBirthState() {
        System.out.println("getBirthState");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getBirthState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBirthState method, of class Person.
     */
    @Test
    public void testSetBirthState() {
        System.out.println("setBirthState");
        String birthState = "";
        Person instance = new Person();
        instance.setBirthState(birthState);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBirthTown method, of class Person.
     */
    @Test
    public void testGetBirthTown() {
        System.out.println("getBirthTown");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getBirthTown();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBirthTown method, of class Person.
     */
    @Test
    public void testSetBirthTown() {
        System.out.println("setBirthTown");
        String birthTown = "";
        Person instance = new Person();
        instance.setBirthTown(birthTown);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOccupation method, of class Person.
     */
    @Test
    public void testGetOccupation() {
        System.out.println("getOccupation");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getOccupation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOccupation method, of class Person.
     */
    @Test
    public void testSetOccupation() {
        System.out.println("setOccupation");
        String occupation = "";
        Person instance = new Person();
        instance.setOccupation(occupation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNationalty method, of class Person.
     */
    @Test
    public void testGetNationalty() {
        System.out.println("getNationalty");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getNationalty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNationalty method, of class Person.
     */
    @Test
    public void testSetNationalty() {
        System.out.println("setNationalty");
        String nationalty = "";
        Person instance = new Person();
        instance.setNationalty(nationalty);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEthnicOrigin method, of class Person.
     */
    @Test
    public void testGetEthnicOrigin() {
        System.out.println("getEthnicOrigin");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getEthnicOrigin();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEthnicOrigin method, of class Person.
     */
    @Test
    public void testSetEthnicOrigin() {
        System.out.println("setEthnicOrigin");
        String ethnicOrigin = "";
        Person instance = new Person();
        instance.setEthnicOrigin(ethnicOrigin);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaritalStatuss method, of class Person.
     */
    @Test
    public void testGetMaritalStatuss() {
        System.out.println("getMaritalStatuss");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getMaritalStatuss();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaritalStatuss method, of class Person.
     */
    @Test
    public void testSetMaritalStatuss() {
        System.out.println("setMaritalStatuss");
        String maritalStatuss = "";
        Person instance = new Person();
        instance.setMaritalStatuss(maritalStatuss);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCountry method, of class Person.
     */
    @Test
    public void testGetCountry() {
        System.out.println("getCountry");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getCountry();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCountry method, of class Person.
     */
    @Test
    public void testSetCountry() {
        System.out.println("setCountry");
        String country = "";
        Person instance = new Person();
        instance.setCountry(country);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPostCode method, of class Person.
     */
    @Test
    public void testGetPostCode() {
        System.out.println("getPostCode");
        Person instance = new Person();
        String expResult = "";
        String result = instance.getPostCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPostCode method, of class Person.
     */
    @Test
    public void testSetPostCode() {
        System.out.println("setPostCode");
        String postCode = "";
        Person instance = new Person();
        instance.setPostCode(postCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAdminClinic method, of class Person.
     */
    @Test
    public void testGetAdminClinic() {
        System.out.println("getAdminClinic");
        Person instance = new Person();
        AdminClinic expResult = null;
        AdminClinic result = instance.getAdminClinic();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAdminClinic method, of class Person.
     */
    @Test
    public void testSetAdminClinic() {
        System.out.println("setAdminClinic");
        AdminClinic adminClinic = null;
        Person instance = new Person();
        instance.setAdminClinic(adminClinic);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEducationCollection method, of class Person.
     */
    @Test
    public void testGetEducationCollection() {
        System.out.println("getEducationCollection");
        Person instance = new Person();
        Collection<Education> expResult = null;
        //Collection<Education> result = instance.getEducationCollection();
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEducationCollection method, of class Person.
     */
    @Test
    public void testSetEducationCollection() {
        System.out.println("setEducationCollection");
        Collection<Education> educationCollection = null;
        Person instance = new Person();
        //instance.setEducationCollection(educationCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPharmacyManager method, of class Person.
     */
    @Test
    public void testGetPharmacyManager() {
        System.out.println("getPharmacyManager");
        Person instance = new Person();
        PharmacyManager expResult = null;
        PharmacyManager result = instance.getPharmacyManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPharmacyManager method, of class Person.
     */
    @Test
    public void testSetPharmacyManager() {
        System.out.println("setPharmacyManager");
        PharmacyManager pharmacyManager = null;
        Person instance = new Person();
        instance.setPharmacyManager(pharmacyManager);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGuardianCollection method, of class Person.
     */
    @Test
    public void testGetGuardianCollection() {
        System.out.println("getGuardianCollection");
        Person instance = new Person();
        Collection<Guardian> expResult = null;
        Collection<Guardian> result = instance.getGuardianCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGuardianCollection method, of class Person.
     */
    @Test
    public void testSetGuardianCollection() {
        System.out.println("setGuardianCollection");
        Collection<Guardian> guardianCollection = null;
        Person instance = new Person();
        instance.setGuardianCollection(guardianCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGuardianCollection1 method, of class Person.
     */
    @Test
    public void testGetGuardianCollection1() {
        System.out.println("getGuardianCollection1");
        Person instance = new Person();
        Collection<Guardian> expResult = null;
        Collection<Guardian> result = instance.getGuardianCollection1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGuardianCollection1 method, of class Person.
     */
    @Test
    public void testSetGuardianCollection1() {
        System.out.println("setGuardianCollection1");
        Collection<Guardian> guardianCollection1 = null;
        Person instance = new Person();
        instance.setGuardianCollection1(guardianCollection1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReceptionist method, of class Person.
     */
    @Test
    public void testGetReceptionist() {
        System.out.println("getReceptionist");
        Person instance = new Person();
        Receptionist expResult = null;
        Receptionist result = instance.getReceptionist();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReceptionist method, of class Person.
     */
    @Test
    public void testSetReceptionist() {
        System.out.println("setReceptionist");
        Receptionist receptionist = null;
        Person instance = new Person();
        instance.setReceptionist(receptionist);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHRManager method, of class Person.
     */
    @Test
    public void testGetHRManager() {
        System.out.println("getHRManager");
        Person instance = new Person();
        HRManager expResult = null;
        HRManager result = instance.getHRManager();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHRManager method, of class Person.
     */
    @Test
    public void testSetHRManager() {
        System.out.println("setHRManager");
        HRManager hRManager = null;
        Person instance = new Person();
        instance.setHRManager(hRManager);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmergencyInformationCollection method, of class Person.
     */
    @Test
    public void testGetEmergencyInformationCollection() {
        System.out.println("getEmergencyInformationCollection");
        Person instance = new Person();
        Collection<EmergencyInformation> expResult = null;
        Collection<EmergencyInformation> result = instance.getEmergencyInformationCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmergencyInformationCollection method, of class Person.
     */
    @Test
    public void testSetEmergencyInformationCollection() {
        System.out.println("setEmergencyInformationCollection");
        Collection<EmergencyInformation> emergencyInformationCollection = null;
        Person instance = new Person();
        instance.setEmergencyInformationCollection(emergencyInformationCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPatient method, of class Person.
     */
    @Test
    public void testGetPatient() {
        System.out.println("getPatient");
        Person instance = new Person();
        Patient expResult = null;
        Patient result = instance.getPatient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPatient method, of class Person.
     */
    @Test
    public void testSetPatient() {
        System.out.println("setPatient");
        Patient patient = null;
        Person instance = new Person();
        instance.setPatient(patient);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDoctor method, of class Person.
     */
    @Test
    public void testGetDoctor() {
        System.out.println("getDoctor");
        Person instance = new Person();
        Doctor expResult = null;
        Doctor result = instance.getDoctor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDoctor method, of class Person.
     */
    @Test
    public void testSetDoctor() {
        System.out.println("setDoctor");
        Doctor doctor = null;
        Person instance = new Person();
        instance.setDoctor(doctor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContactCollection method, of class Person.
     */
    @Test
    public void testGetContactCollection() {
        System.out.println("getContactCollection");
        Person instance = new Person();
        Collection<Contact> expResult = null;
        Collection<Contact> result = instance.getContactCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContactCollection method, of class Person.
     */
    @Test
    public void testSetContactCollection() {
        System.out.println("setContactCollection");
        Collection<Contact> contactCollection = null;
        Person instance = new Person();
        instance.setContactCollection(contactCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPharmacist method, of class Person.
     */
    @Test
    public void testGetPharmacist() {
        System.out.println("getPharmacist");
        Person instance = new Person();
        Pharmacist expResult = null;
        Pharmacist result = instance.getPharmacist();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPharmacist method, of class Person.
     */
    @Test
    public void testSetPharmacist() {
        System.out.println("setPharmacist");
        Pharmacist pharmacist = null;
        Person instance = new Person();
        instance.setPharmacist(pharmacist);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGenderId method, of class Person.
     */
    @Test
    public void testGetGenderId() {
        System.out.println("getGenderId");
        Person instance = new Person();
        Gender expResult = null;
        Gender result = instance.getGenderId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGenderId method, of class Person.
     */
    @Test
    public void testSetGenderId() {
        System.out.println("setGenderId");
        Gender genderId = null;
        Person instance = new Person();
        instance.setGenderId(genderId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReligionID method, of class Person.
     */
    @Test
    public void testGetReligionID() {
        System.out.println("getReligionID");
        Person instance = new Person();
        Religion expResult = null;
        Religion result = instance.getReligionID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReligionID method, of class Person.
     */
    @Test
    public void testSetReligionID() {
        System.out.println("setReligionID");
        Religion religionID = null;
        Person instance = new Person();
        instance.setReligionID(religionID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNurse method, of class Person.
     */
    @Test
    public void testGetNurse() {
        System.out.println("getNurse");
        Person instance = new Person();
        Nurse expResult = null;
        Nurse result = instance.getNurse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNurse method, of class Person.
     */
    @Test
    public void testSetNurse() {
        System.out.println("setNurse");
        Nurse nurse = null;
        Person instance = new Person();
        instance.setNurse(nurse);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Person.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Person instance = new Person();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Person.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Person instance = new Person();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Person.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Person instance = new Person();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void addPerson()
    {
        Person p = new Person();
        Gender gender = new Gender();
        SQLRepository sql = new SQLRepository();
        
        gender.setGenderId(1);
        gender.setGenderName("MALE");
        
        p.setAdminClinic(null);
        p.setPersonId(123);
        p.setGenderId(gender);
        
        //sql.add(p);
        sql.remove(p);
    }
    
}
