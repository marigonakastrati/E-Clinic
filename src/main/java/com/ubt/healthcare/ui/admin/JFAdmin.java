/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin;

import com.ubt.healthcare.business.UserValidation;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.Address;
import com.ubt.healthcare.dto.AdminClinic;
import com.ubt.healthcare.dto.City;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Gender;
import com.ubt.healthcare.dto.MartialStatus;
import com.ubt.healthcare.dto.Nurse;
import com.ubt.healthcare.dto.Patient;
import com.ubt.healthcare.dto.Person;
import com.ubt.healthcare.dto.Pharmacist;
import com.ubt.healthcare.dto.PharmacyManager;
import com.ubt.healthcare.dto.Receptionist;
import com.ubt.healthcare.dto.Religion;
import com.ubt.healthcare.ui.JPMain;
import com.ubt.healthcare.ui.JPanelEditProfile;
import com.ubt.healthcare.ui.JPanelViewProfile;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author F
 */
public class JFAdmin extends JFrame{
    
    private JPAddDoctor jpAddDoctor;
    private JPAddNurse jpAddNurse;
    private JPAddPatient jpAddPatient;
    private JPAddPharmacyManager jpAddPharmacyManager;
    private JPAddPharmacist jpAddPharmacist;
    private JPAddReceptionist jpAddReceptionist;
    private JPAddAdminClinic jpAddAdminClinic;
    private JPanelViewDoctor jpViewDoctor;
    private JPanelViewReceptionist jpViewReceptionist;
    private JPanelViewProfile jpViewProfile;
    private JPanelEditProfile jpEditProfile;
    private JPanelAdminScreen jpAdminScreen;
    private JScrollPane jspPane;
    private JPMain jpMain;
    private CardLayout clCardlayout ;
    private AdminClinic admin;
    private UserValidation userValidation;

    public JFAdmin(JPAddDoctor jpAddDoctor,JPAddNurse jpAddNurse, JPAddPatient jpAddPatient,JPAddPharmacyManager jpAddPharmacyManager,
                JPAddPharmacist jpAddPharmacist,JPAddReceptionist jpAddReceptionist, JPAddAdminClinic jpAddAdminClinic,
                JPanelViewDoctor jpViewDoctor, JPanelViewReceptionist jpViewReceptionist, 
                JPanelViewProfile jpViewProfile, JPanelEditProfile jpEditProfile ,JPanelAdminScreen jpAdminScreen, AdminClinic admin) 
    {
        this.jpAddDoctor = jpAddDoctor;
        this.jpAddNurse = jpAddNurse;
        this.jpAddPatient = jpAddPatient;
        this.jpAddPharmacyManager = jpAddPharmacyManager;
        this.jpAddPharmacist = jpAddPharmacist;
        this.jpAddReceptionist = jpAddReceptionist;
        this.jpAddAdminClinic = jpAddAdminClinic;
        this.jpViewDoctor = jpViewDoctor;
        this.jpViewReceptionist = jpViewReceptionist;
        this.jpViewProfile = jpViewProfile;
        this.jpEditProfile = jpEditProfile;
        this.jpAdminScreen = jpAdminScreen;
        this.admin = admin;
        this.userValidation = new UserValidation();
        
        //jspPane = new JScrollPane(jpViewProfile, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //jspPane.setLayout(null);
        jpMain = new JPMain();
        clCardlayout = new CardLayout();
        setUndecorated(true);// disable the minimize, maximize, close
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setBounds(100, 100, 300, 300);
        jpMain.setLayout(clCardlayout);
        
        jpMain.add(jpAdminScreen, "Admin Screen");// it works by using the second paramteter to switch the JPanels
        jpMain.add(jpViewProfile, "View Profile Screen");// it works by using the second paramteter to switch the JPanels
        jpMain.add(jpAddDoctor, "Add Doctor Screen");// it works by using the second paramteter to switch the JPanels
        jpMain.add(jpAddReceptionist, "Add  Receptionist Screen");// it works by using the second paramteter to switch the JPanels
        jpMain.add(jpViewDoctor, "View Doctor Screen");// it works by using the second paramteter to switch the JPanels
        jpMain.add(jpViewReceptionist, "View Receptionist Screen");// it works by using the second paramteter to switch the JPanels
        //jpMain.add(jspPane, "Pane Screen");// it works by using the second paramteter to switch the JPanels
        clCardlayout.show(jpMain, "Admin Screen");

        add(jpMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("E Clinic");
        pack();
        setVisible(true);

    }
    
    
    public void showAddDoctorScreen() {

        jpAddDoctor.setVisible(true);
        jpAddNurse.setVisible(false);
        jpAddPatient.setVisible(false);
        jpAddPharmacyManager.setVisible(false);
        jpAddPharmacist.setVisible(false);
        jpAddReceptionist.setVisible(false);
        jpAddAdminClinic.setVisible(false);
        jpViewDoctor.setVisible(false);
        jpViewReceptionist.setVisible(false);
        jpViewProfile.setVisible(false);
        jpEditProfile.setVisible(false);
        jpAdminScreen.setVisible(false);

    }

    public void showAddReceptionistScreen() {

        jpAddDoctor.setVisible(false);
        jpAddNurse.setVisible(false);
        jpAddPatient.setVisible(false);
        jpAddPharmacyManager.setVisible(false);
        jpAddPharmacist.setVisible(false);
        jpAddReceptionist.setVisible(true);
        jpAddAdminClinic.setVisible(false);
        jpViewDoctor.setVisible(false);
        jpViewReceptionist.setVisible(false);
        jpViewProfile.setVisible(false);
        jpEditProfile.setVisible(false);
        jpAdminScreen.setVisible(false);

    }

    public void showViewDoctorScreen() {
        jpAddDoctor.setVisible(false);
        jpAddNurse.setVisible(false);
        jpAddPatient.setVisible(false);
        jpAddPharmacyManager.setVisible(false);
        jpAddPharmacist.setVisible(false);
        jpAddReceptionist.setVisible(false);
        jpAddAdminClinic.setVisible(false);
        jpViewDoctor.setVisible(true);
        jpViewReceptionist.setVisible(false);
        jpViewProfile.setVisible(false);
        jpEditProfile.setVisible(false);
        jpAdminScreen.setVisible(false);

    }

    public void showViewProfileScreen() {
        jpAddDoctor.setVisible(false);
        jpAddNurse.setVisible(false);
        jpAddPatient.setVisible(false);
        jpAddPharmacyManager.setVisible(false);
        jpAddPharmacist.setVisible(false);
        jpAddReceptionist.setVisible(false);
        jpAddAdminClinic.setVisible(false);
        jpViewDoctor.setVisible(false);
        jpViewReceptionist.setVisible(false);
        jpViewProfile.setVisible(true);
        jpEditProfile.setVisible(false);
        jpAdminScreen.setVisible(false);

    }

    public void showViewReceptionistScreen() {
        jpAddDoctor.setVisible(false);
        jpAddNurse.setVisible(false);
        jpAddPatient.setVisible(false);
        jpAddPharmacyManager.setVisible(false);
        jpAddPharmacist.setVisible(false);
        jpAddReceptionist.setVisible(false);
        jpAddAdminClinic.setVisible(false);
        jpViewDoctor.setVisible(false);
        jpViewReceptionist.setVisible(true);
        jpViewProfile.setVisible(false);
        jpEditProfile.setVisible(false);
        jpAdminScreen.setVisible(false);
    }

    public void showViewAdminScreen() {
        jpAddDoctor.setVisible(false);
        jpAddNurse.setVisible(false);
        jpAddPatient.setVisible(false);
        jpAddPharmacyManager.setVisible(false);
        jpAddPharmacist.setVisible(false);
        jpAddReceptionist.setVisible(false);
        jpAddAdminClinic.setVisible(false);
        jpViewDoctor.setVisible(false);
        jpViewReceptionist.setVisible(false);
        jpViewProfile.setVisible(false);
        jpEditProfile.setVisible(false);
        jpAdminScreen.setVisible(true);
    }

    public void showAddPatientScreen() {
        jpAddDoctor.setVisible(false);
        jpAddNurse.setVisible(false);
        jpAddPatient.setVisible(true);
        jpAddPharmacyManager.setVisible(false);
        jpAddPharmacist.setVisible(false);
        jpAddReceptionist.setVisible(false);
        jpAddAdminClinic.setVisible(false);
        jpViewDoctor.setVisible(false);
        jpViewReceptionist.setVisible(false);
        jpViewProfile.setVisible(false);
        jpEditProfile.setVisible(false);
        jpAdminScreen.setVisible(false);
    }

    public void showAddPharmacistScreen() {
        jpAddDoctor.setVisible(false);
        jpAddNurse.setVisible(false);
        jpAddPatient.setVisible(false);
        jpAddPharmacyManager.setVisible(false);
        jpAddPharmacist.setVisible(true);
        jpAddReceptionist.setVisible(false);
        jpAddAdminClinic.setVisible(false);
        jpViewDoctor.setVisible(false);
        jpViewReceptionist.setVisible(false);
        jpViewProfile.setVisible(false);
        jpEditProfile.setVisible(false);
        jpAdminScreen.setVisible(false);
    }

    public void showAddPharmacyManagerScreen() {
        jpAddDoctor.setVisible(false);
        jpAddNurse.setVisible(false);
        jpAddPatient.setVisible(false);
        jpAddPharmacyManager.setVisible(true);
        jpAddPharmacist.setVisible(false);
        jpAddReceptionist.setVisible(false);
        jpAddAdminClinic.setVisible(false);
        jpViewDoctor.setVisible(false);
        jpViewReceptionist.setVisible(false);
        jpViewProfile.setVisible(false);
        jpEditProfile.setVisible(false);
        jpAdminScreen.setVisible(false);
    }

    public void showAddAdminClinicScreen() {
        jpAddDoctor.setVisible(false);
        jpAddNurse.setVisible(false);
        jpAddPatient.setVisible(false);
        jpAddPharmacyManager.setVisible(false);
        jpAddPharmacist.setVisible(false);
        jpAddReceptionist.setVisible(false);
        jpAddAdminClinic.setVisible(true);
        jpViewDoctor.setVisible(false);
        jpViewReceptionist.setVisible(false);
        jpViewProfile.setVisible(false);
        jpEditProfile.setVisible(false);
        jpAdminScreen.setVisible(false);
    }

    public void showAddNurseScreen() {
        jpAddDoctor.setVisible(false);
        jpAddNurse.setVisible(true);
        jpAddPatient.setVisible(false);
        jpAddPharmacyManager.setVisible(false);
        jpAddPharmacist.setVisible(false);
        jpAddReceptionist.setVisible(false);
        jpAddAdminClinic.setVisible(false);
        jpViewDoctor.setVisible(false);
        jpViewReceptionist.setVisible(false);
        jpViewProfile.setVisible(false);
        jpEditProfile.setVisible(false);
        jpAdminScreen.setVisible(false);
    }

    
    public void showLogInScreen()
    {
     

        setVisible(false);
        
    }
    //show the JPupdateprofile
    public void showUpdateProfileScreen()
    {
       /* Person person = person.getPersonId();
        person.setCity(jpStudentEditScreen.getJtaCity().getText());
        student.setPersonId(person);
        person.setStudent(student);
        personService.update(person);
        studentService.update(student);*/
        jpEditProfile.setVisible(true);
        // should the lisstener be on ui.admin.eventhandling or ui.eventhandling???

        
    }
    
    public void persistDoctor()
    {
        String firstName = jpAddDoctor.getJtfFirstName().getText();
        String lastName =jpAddDoctor.getJtfLastName().getText();
        String middleName = jpAddDoctor.getJtfMiddleName().getText();
        String personaId = jpAddDoctor.getJtfPersonalId().getText();
        Date dateOfBorth = jpAddDoctor.getJdchDateOfBirth().getDate();
        String birthPlace = jpAddDoctor.getJcbBirthPlace().getSelectedItem().toString();
        //String gender = jpAddDoctor.getGenderValue();
        String mobNumber = jpAddDoctor.getJtfMobilePhone().getText();
        String email = jpAddDoctor.getJtfEmail().getText();
        String address = jpAddDoctor.getJtfAddress1().getText();
        String country = jpAddDoctor.getJcbCountry().getSelectedItem().toString();
        String city = jpAddDoctor.getJcbCity().getSelectedItem().toString();
        String postCode = jpAddDoctor.getJtfPostCode1().getText();
        String password = new String(jpAddDoctor.getJpwPassword().getPassword());
        String personalID = jpAddDoctor.getJtfPersonalId().getText();
        
        Doctor doctor = new Doctor();
        Person person = new Person();
        City birthCity = new City();
        
        //set country name
        
        // set city name
        birthCity = userValidation.findTheCity(birthPlace);
        
        
        //set martial status
        MartialStatus ms = new MartialStatus();
        ms = userValidation.findTheMartialStatus();
        // set religion id
        Religion rel = new Religion();
        rel = userValidation.findTheReligion();
        
        // set gender id 
        Gender gen = new Gender();
        gen = userValidation.findTheGender();
        
        // set actual city id 
        City cit = new City();
        cit = userValidation.findTheCity(city);
        
        // set actual address id 
        Address add = new Address();
        add.setCityId(cit);
        add.setBuildingNumber(Integer.parseInt(postCode));
        add.setStreetName(address);
        
        person.setPersonId(Integer.parseInt(personalID));
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMiddleName(middleName);
        person.setDateOfBirth(dateOfBorth);
        person.setBirthCityId(birthCity);
        person.setGenderId(gen);
        person.setAddressId(add);
        person.setReigionId(rel);
        person.setMartialStatusId(ms);
 
        
        doctor.setPassCode(password);
        doctor.setPersonId(person);
        person.setDoctor(doctor);
        
        
        String msg = userValidation.validatePerson(person);
        
        if("Validated".equals(msg))
        {
            String persistMsg = null;
            persistMsg = persistDoctor(doctor);
            if("Saved".equals(persistMsg))
            {
                JOptionPane.showMessageDialog(null, "User is saved");
                clearTheFields("Doctor");
                showViewAdminScreen();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, persistMsg);
            }
        }
        else if ("You must type your first name".equals(msg))
        {
            JOptionPane.showMessageDialog(null, msg);
        } 
    }
    
    private String persistDoctor(Doctor doctor)
    {
        String personMsg = null;
        String addressMsg = null;
        String doctorMsg = null;
        
        SQLRepository repo = new SQLRepository();
        Person person = doctor.getPersonId();
        
        //Gender genderTo = person.getGenderId();
        Address addressTo = person.getAddressId();
        String streetName = addressTo.getStreetName();
        String postCode = addressTo.getBuildingNumber().toString();
        
        addressMsg = userValidation.checkIfAddressExists(streetName,postCode); // if street name and post code and city and county same dont add new address
        personMsg = userValidation.checkIfUserExists(person);
        doctorMsg = userValidation.checkIfDoctorExists(doctor);
        
        if("Save".equals(personMsg) && "Save".equals(doctorMsg))
        {
            if("Save".equals(addressMsg))
            {
                //save address and person
                repo.add(addressTo);
                repo.add(person);
                //repo.add(doctor);
                return "Saved";
            }
            else
            {
                repo.add(person);
                //repo.add(doctor);
                return "Saved";
            }
        }

            return "Save".equals(personMsg)?doctorMsg:personMsg;
    }
    
    public void persistNurse()
    {
        String firstName = jpAddDoctor.getJtfFirstName().getText();
        String lastName =jpAddDoctor.getJtfLastName().getText();
        String middleName = jpAddDoctor.getJtfMiddleName().getText();
        String personaId = jpAddDoctor.getJtfPersonalId().getText();
        Date dateOfBorth = jpAddDoctor.getJdchDateOfBirth().getDate();
        String birthPlace = jpAddDoctor.getJcbBirthPlace().getSelectedItem().toString();
        //String gender = jpAddDoctor.getGenderValue();
        String mobNumber = jpAddDoctor.getJtfMobilePhone().getText();
        String email = jpAddDoctor.getJtfEmail().getText();
        String address = jpAddDoctor.getJtfAddress1().getText();
        String country = jpAddDoctor.getJcbCountry().getSelectedItem().toString();
        String city = jpAddDoctor.getJcbCity().getSelectedItem().toString();
        String postCode = jpAddDoctor.getJtfPostCode1().getText();
        String password = new String(jpAddDoctor.getJpwPassword().getPassword());
        String personalID = jpAddDoctor.getJtfPersonalId().getText();
        
        Nurse nurse = new Nurse();
        Person person = new Person();
        City birthCity = new City();
        
        //set country name
        
        // set city name
        birthCity = userValidation.findTheCity(birthPlace);
        
        
        //set martial status
        MartialStatus ms = new MartialStatus();
        ms = userValidation.findTheMartialStatus();
        // set religion id
        Religion rel = new Religion();
        rel = userValidation.findTheReligion();
        
        // set gender id 
        Gender gen = new Gender();
        gen = userValidation.findTheGender();
        
        // set actual city id 
        City cit = new City();
        cit = userValidation.findTheCity(city);
        
        // set actual address id 
        Address add = new Address();
        add.setCityId(cit);
        add.setBuildingNumber(Integer.parseInt(postCode));
        add.setStreetName(address);
        
        person.setPersonId(Integer.parseInt(personalID));
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMiddleName(middleName);
        person.setDateOfBirth(dateOfBorth);
        person.setBirthCityId(birthCity);
        person.setGenderId(gen);
        person.setAddressId(add);
        person.setReigionId(rel);
        person.setMartialStatusId(ms);
 
        
        nurse.setPassCode(password);
        nurse.setPersonId(person);
        person.setNurse(nurse);
        
        
        String msg = userValidation.validatePerson(person);
        
        if("Validated".equals(msg))
        {
            String persistMsg = null;
            persistMsg = persistNurse(nurse);
            if("Saved".equals(persistMsg))
            {
                JOptionPane.showMessageDialog(null, "User is saved");
                clearTheFields("Nurse");
                showViewAdminScreen();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, persistMsg);
            }
        }
        else if ("You must type your first name".equals(msg))
        {
            JOptionPane.showMessageDialog(null, msg);
        } 
    }
    
    public void persistPharmacist()
    {
        String firstName = jpAddDoctor.getJtfFirstName().getText();
        String lastName =jpAddDoctor.getJtfLastName().getText();
        String middleName = jpAddDoctor.getJtfMiddleName().getText();
        String personaId = jpAddDoctor.getJtfPersonalId().getText();
        Date dateOfBorth = jpAddDoctor.getJdchDateOfBirth().getDate();
        String birthPlace = jpAddDoctor.getJcbBirthPlace().getSelectedItem().toString();
        //String gender = jpAddDoctor.getGenderValue();
        String mobNumber = jpAddDoctor.getJtfMobilePhone().getText();
        String email = jpAddDoctor.getJtfEmail().getText();
        String address = jpAddDoctor.getJtfAddress1().getText();
        String country = jpAddDoctor.getJcbCountry().getSelectedItem().toString();
        String city = jpAddDoctor.getJcbCity().getSelectedItem().toString();
        String postCode = jpAddDoctor.getJtfPostCode1().getText();
        String password = new String(jpAddDoctor.getJpwPassword().getPassword());
        String personalID = jpAddDoctor.getJtfPersonalId().getText();
        
        Pharmacist pharmacist = new Pharmacist();
        Person person = new Person();
        City birthCity = new City();
        
        //set country name
        
        // set city name
        birthCity = userValidation.findTheCity(birthPlace);
        
        
        //set martial status
        MartialStatus ms = new MartialStatus();
        ms = userValidation.findTheMartialStatus();
        // set religion id
        Religion rel = new Religion();
        rel = userValidation.findTheReligion();
        
        // set gender id 
        Gender gen = new Gender();
        gen = userValidation.findTheGender();
        
        // set actual city id 
        City cit = new City();
        cit = userValidation.findTheCity(city);
        
        // set actual address id 
        Address add = new Address();
        add.setCityId(cit);
        add.setBuildingNumber(Integer.parseInt(postCode));
        add.setStreetName(address);
        
        person.setPersonId(Integer.parseInt(personalID));
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMiddleName(middleName);
        person.setDateOfBirth(dateOfBorth);
        person.setBirthCityId(birthCity);
        person.setGenderId(gen);
        person.setAddressId(add);
        person.setReigionId(rel);
        person.setMartialStatusId(ms);
 
        
        pharmacist.setPassCode(password);
        pharmacist.setPersonId(person);
        person.setPharmacist(pharmacist);
        
        
        String msg = userValidation.validatePerson(person);
        
        if("Validated".equals(msg))
        {
            String persistMsg = null;
            persistMsg = persistPharmacist(pharmacist);
            if("Saved".equals(persistMsg))
            {
                JOptionPane.showMessageDialog(null, "User is saved");
                clearTheFields("Pharmacist");
                showViewAdminScreen();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, persistMsg);
            }
        }
        else if ("You must type your first name".equals(msg))
        {
            JOptionPane.showMessageDialog(null, msg);
        } 
    }
    
    public void persistPharmacyManager()
    {
        String firstName = jpAddDoctor.getJtfFirstName().getText();
        String lastName =jpAddDoctor.getJtfLastName().getText();
        String middleName = jpAddDoctor.getJtfMiddleName().getText();
        String personaId = jpAddDoctor.getJtfPersonalId().getText();
        Date dateOfBorth = jpAddDoctor.getJdchDateOfBirth().getDate();
        String birthPlace = jpAddDoctor.getJcbBirthPlace().getSelectedItem().toString();
        //String gender = jpAddDoctor.getGenderValue();
        String mobNumber = jpAddDoctor.getJtfMobilePhone().getText();
        String email = jpAddDoctor.getJtfEmail().getText();
        String address = jpAddDoctor.getJtfAddress1().getText();
        String country = jpAddDoctor.getJcbCountry().getSelectedItem().toString();
        String city = jpAddDoctor.getJcbCity().getSelectedItem().toString();
        String postCode = jpAddDoctor.getJtfPostCode1().getText();
        String password = new String(jpAddDoctor.getJpwPassword().getPassword());
        String personalID = jpAddDoctor.getJtfPersonalId().getText();
        
        PharmacyManager pharmacyManager = new PharmacyManager();
        Person person = new Person();
        City birthCity = new City();
        
        //set country name
        
        // set city name
        birthCity = userValidation.findTheCity(birthPlace);
        
        
        //set martial status
        MartialStatus ms = new MartialStatus();
        ms = userValidation.findTheMartialStatus();
        // set religion id
        Religion rel = new Religion();
        rel = userValidation.findTheReligion();
        
        // set gender id 
        Gender gen = new Gender();
        gen = userValidation.findTheGender();
        
        // set actual city id 
        City cit = new City();
        cit = userValidation.findTheCity(city);
        
        // set actual address id 
        Address add = new Address();
        add.setCityId(cit);
        add.setBuildingNumber(Integer.parseInt(postCode));
        add.setStreetName(address);
        
        person.setPersonId(Integer.parseInt(personalID));
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMiddleName(middleName);
        person.setDateOfBirth(dateOfBorth);
        person.setBirthCityId(birthCity);
        person.setGenderId(gen);
        person.setAddressId(add);
        person.setReigionId(rel);
        person.setMartialStatusId(ms);
 
        
        pharmacyManager.setPassCode(password);
        pharmacyManager.setPersonId(person);
        person.setPharmacyManager(pharmacyManager);
        
        
        String msg = userValidation.validatePerson(person);
        
        if("Validated".equals(msg))
        {
            String persistMsg = null;
            persistMsg = persistPharmacyManager(pharmacyManager);
            if("Saved".equals(persistMsg))
            {
                JOptionPane.showMessageDialog(null, "User is saved");
                clearTheFields("PharmacyManager");
                showViewAdminScreen();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, persistMsg);
            }
        }
        else if ("You must type your first name".equals(msg))
        {
            JOptionPane.showMessageDialog(null, msg);
        } 
    }
    
    public void persistReceptionist()
    {
        String firstName = jpAddDoctor.getJtfFirstName().getText();
        String lastName =jpAddDoctor.getJtfLastName().getText();
        String middleName = jpAddDoctor.getJtfMiddleName().getText();
        String personaId = jpAddDoctor.getJtfPersonalId().getText();
        Date dateOfBorth = jpAddDoctor.getJdchDateOfBirth().getDate();
        String birthPlace = jpAddDoctor.getJcbBirthPlace().getSelectedItem().toString();
        //String gender = jpAddDoctor.getGenderValue();
        String mobNumber = jpAddDoctor.getJtfMobilePhone().getText();
        String email = jpAddDoctor.getJtfEmail().getText();
        String address = jpAddDoctor.getJtfAddress1().getText();
        String country = jpAddDoctor.getJcbCountry().getSelectedItem().toString();
        String city = jpAddDoctor.getJcbCity().getSelectedItem().toString();
        String postCode = jpAddDoctor.getJtfPostCode1().getText();
        String password = new String(jpAddDoctor.getJpwPassword().getPassword());
        String personalID = jpAddDoctor.getJtfPersonalId().getText();
        
        Receptionist receptionist = new Receptionist();
        Person person = new Person();
        City birthCity = new City();
        
        //set country name
        
        // set city name
        birthCity = userValidation.findTheCity(birthPlace);
        
        
        //set martial status
        MartialStatus ms = new MartialStatus();
        ms = userValidation.findTheMartialStatus();
        // set religion id
        Religion rel = new Religion();
        rel = userValidation.findTheReligion();
        
        // set gender id 
        Gender gen = new Gender();
        gen = userValidation.findTheGender();
        
        // set actual city id 
        City cit = new City();
        cit = userValidation.findTheCity(city);
        
        // set actual address id 
        Address add = new Address();
        add.setCityId(cit);
        add.setBuildingNumber(Integer.parseInt(postCode));
        add.setStreetName(address);
        
        person.setPersonId(Integer.parseInt(personalID));
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMiddleName(middleName);
        person.setDateOfBirth(dateOfBorth);
        person.setBirthCityId(birthCity);
        person.setGenderId(gen);
        person.setAddressId(add);
        person.setReigionId(rel);
        person.setMartialStatusId(ms);
 
        
        receptionist.setPassCode(password);
        receptionist.setPersonId(person);
        person.setReceptionist(receptionist);
        
        
        String msg = userValidation.validatePerson(person);
        
        if("Validated".equals(msg))
        {
            String persistMsg = null;
            persistMsg = persistReceptionist(receptionist);
            if("Saved".equals(persistMsg))
            {
                JOptionPane.showMessageDialog(null, "User is saved");
                clearTheFields("Receptionist");
                showViewAdminScreen();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, persistMsg);
            }
        }
        else if ("You must type your first name".equals(msg))
        {
            JOptionPane.showMessageDialog(null, msg);
        } 
    }
    
     public void persistPatient()
    {
        String firstName = jpAddDoctor.getJtfFirstName().getText();
        String lastName =jpAddDoctor.getJtfLastName().getText();
        String middleName = jpAddDoctor.getJtfMiddleName().getText();
        String personaId = jpAddDoctor.getJtfPersonalId().getText();
        Date dateOfBorth = jpAddDoctor.getJdchDateOfBirth().getDate();
        String birthPlace = jpAddDoctor.getJcbBirthPlace().getSelectedItem().toString();
        //String gender = jpAddDoctor.getGenderValue();
        String mobNumber = jpAddDoctor.getJtfMobilePhone().getText();
        String email = jpAddDoctor.getJtfEmail().getText();
        String address = jpAddDoctor.getJtfAddress1().getText();
        String country = jpAddDoctor.getJcbCountry().getSelectedItem().toString();
        String city = jpAddDoctor.getJcbCity().getSelectedItem().toString();
        String postCode = jpAddDoctor.getJtfPostCode1().getText();
        String password = new String(jpAddDoctor.getJpwPassword().getPassword());
        String personalID = jpAddDoctor.getJtfPersonalId().getText();
        
        Patient patient = new Patient();
        Person person = new Person();
        City birthCity = new City();
        
        //set country name
        
        // set city name
        birthCity = userValidation.findTheCity(birthPlace);
        
        
        //set martial status
        MartialStatus ms = new MartialStatus();
        ms = userValidation.findTheMartialStatus();
        // set religion id
        Religion rel = new Religion();
        rel = userValidation.findTheReligion();
        
        // set gender id 
        Gender gen = new Gender();
        gen = userValidation.findTheGender();
        
        // set actual city id 
        City cit = new City();
        cit = userValidation.findTheCity(city);
        
        // set actual address id 
        Address add = new Address();
        add.setCityId(cit);
        add.setBuildingNumber(Integer.parseInt(postCode));
        add.setStreetName(address);
        
        person.setPersonId(Integer.parseInt(personalID));
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMiddleName(middleName);
        person.setDateOfBirth(dateOfBorth);
        person.setBirthCityId(birthCity);
        person.setGenderId(gen);
        person.setAddressId(add);
        person.setReigionId(rel);
        person.setMartialStatusId(ms);
 
        
        patient.setPassCode(password);
        patient.setPersonId(person);
        person.setPatient(patient);
        
        
        String msg = userValidation.validatePerson(person);
        
        if("Validated".equals(msg))
        {
            String persistMsg = null;
            persistMsg = persistPatient(patient);
            if("Saved".equals(persistMsg))
            {
                JOptionPane.showMessageDialog(null, "User is saved");
                clearTheFields("Patient");
                showViewAdminScreen();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, persistMsg);
            }
        }
        else if ("You must type your first name".equals(msg))
        {
            JOptionPane.showMessageDialog(null, msg);
        } 
    }
     
     private String persistNurse(Nurse nurse)
    {
        String personMsg = null;
        String addressMsg = null;
        String nurseMsg = null;
        
        SQLRepository repo = new SQLRepository();
        Person person = nurse.getPersonId();
        
        //Gender genderTo = person.getGenderId();
        Address addressTo = person.getAddressId();
        String streetName = addressTo.getStreetName();
        String postCode = addressTo.getBuildingNumber().toString();
        
        addressMsg = userValidation.checkIfAddressExists(streetName,postCode); // if street name and post code and city and county same dont add new address
        personMsg = userValidation.checkIfUserExists(person);
        nurseMsg = userValidation.checkIfNurseExists(nurse);
        
        if("Save".equals(personMsg) && "Save".equals(nurseMsg))
        {
            if("Save".equals(addressMsg))
            {
                //save address and person
                repo.add(addressTo);
                repo.add(person);
                //repo.add(doctor);
                return "Saved";
            }
            else
            {
                repo.add(person);
                //repo.add(nurse);
                return "Saved";
            }
        }

            return "Save".equals(personMsg)?nurseMsg:personMsg;
    }
     
     private String persistPatient(Patient patient)
    {
        String personMsg = null;
        String addressMsg = null;
        String patientMsg = null;
        
        SQLRepository repo = new SQLRepository();
        Person person = patient.getPersonId();
        
        //Gender genderTo = person.getGenderId();
        Address addressTo = person.getAddressId();
        String streetName = addressTo.getStreetName();
        String postCode = addressTo.getBuildingNumber().toString();
        
        addressMsg = userValidation.checkIfAddressExists(streetName,postCode); // if street name and post code and city and county same dont add new address
        personMsg = userValidation.checkIfUserExists(person);
        patientMsg = userValidation.checkIfPatientExists(patient);
        
        if("Save".equals(personMsg) && "Save".equals(patientMsg))
        {
            if("Save".equals(addressMsg))
            {
                //save address and person
                repo.add(addressTo);
                repo.add(person);
                //repo.add(doctor);
                return "Saved";
            }
            else
            {
                repo.add(person);
                //repo.add(patient);
                return "Saved";
            }
        }

            return "Save".equals(personMsg)?patientMsg:personMsg;
    }
     
     private String persistPharmacist(Pharmacist pharmacist)
    {
        String personMsg = null;
        String addressMsg = null;
        String pharmacistMsg = null;
        
        SQLRepository repo = new SQLRepository();
        Person person = pharmacist.getPersonId();
        
        //Gender genderTo = person.getGenderId();
        Address addressTo = person.getAddressId();
        String streetName = addressTo.getStreetName();
        String postCode = addressTo.getBuildingNumber().toString();
        
        addressMsg = userValidation.checkIfAddressExists(streetName,postCode); // if street name and post code and city and county same dont add new address
        personMsg = userValidation.checkIfUserExists(person);
        pharmacistMsg = userValidation.checkIfPharmacistExists(pharmacist);
        
        if("Save".equals(personMsg) && "Save".equals(pharmacistMsg))
        {
            if("Save".equals(addressMsg))
            {
                //save address and person
                repo.add(addressTo);
                repo.add(person);
                //repo.add(doctor);
                return "Saved";
            }
            else
            {
                repo.add(person);
                //repo.add(pharmacist);
                return "Saved";
            }
        }

            return "Save".equals(personMsg)?pharmacistMsg:personMsg;
    }
     
     private String persistPharmacyManager(PharmacyManager pharacyManager)
    {
        String personMsg = null;
        String addressMsg = null;
        String pharmacyManager = null;
        
        SQLRepository repo = new SQLRepository();
        Person person = pharacyManager.getPersonId();
        
        //Gender genderTo = person.getGenderId();
        Address addressTo = person.getAddressId();
        String streetName = addressTo.getStreetName();
        String postCode = addressTo.getBuildingNumber().toString();
        
        addressMsg = userValidation.checkIfAddressExists(streetName,postCode); // if street name and post code and city and county same dont add new address
        personMsg = userValidation.checkIfUserExists(person);
        pharmacyManager = userValidation.checkIfPharmacyManagerExists(pharacyManager);
        
        if("Save".equals(personMsg) && "Save".equals(pharmacyManager))
        {
            if("Save".equals(addressMsg))
            {
                //save address and person
                repo.add(addressTo);
                repo.add(person);
                //repo.add(doctor);
                return "Saved";
            }
            else
            {
                repo.add(person);
                //repo.add(pharacyManager);
                return "Saved";
            }
        }

            return "Save".equals(personMsg)?pharmacyManager:personMsg;
    }
     
     private String persistReceptionist(Receptionist receptionist)
    {
        String personMsg = null;
        String addressMsg = null;
        String receptionistMsg = null;
        
        SQLRepository repo = new SQLRepository();
        Person person = receptionist.getPersonId();
        
        //Gender genderTo = person.getGenderId();
        Address addressTo = person.getAddressId();
        String streetName = addressTo.getStreetName();
        String postCode = addressTo.getBuildingNumber().toString();
        
        addressMsg = userValidation.checkIfAddressExists(streetName,postCode); // if street name and post code and city and county same dont add new address
        personMsg = userValidation.checkIfUserExists(person);
        receptionistMsg = userValidation.checkIfReceptionistExists(receptionist);
        
        if("Save".equals(personMsg) && "Save".equals(receptionistMsg))
        {
            if("Save".equals(addressMsg))
            {
                //save address and person
                repo.add(addressTo);
                repo.add(person);
                //repo.add(doctor);
                return "Saved";
            }
            else
            {
                repo.add(person);
                //repo.add(receptionist);
                return "Saved";
            }
        }

            return "Save".equals(personMsg)?receptionistMsg:personMsg;
    }
     
     public void persistAdminClinic()
    {
        String firstName = jpAddDoctor.getJtfFirstName().getText();
        String lastName =jpAddDoctor.getJtfLastName().getText();
        String middleName = jpAddDoctor.getJtfMiddleName().getText();
        String personaId = jpAddDoctor.getJtfPersonalId().getText();
        Date dateOfBorth = jpAddDoctor.getJdchDateOfBirth().getDate();
        String birthPlace = jpAddDoctor.getJcbBirthPlace().getSelectedItem().toString();
        //String gender = jpAddDoctor.getGenderValue();
        String mobNumber = jpAddDoctor.getJtfMobilePhone().getText();
        String email = jpAddDoctor.getJtfEmail().getText();
        String address = jpAddDoctor.getJtfAddress1().getText();
        String country = jpAddDoctor.getJcbCountry().getSelectedItem().toString();
        String city = jpAddDoctor.getJcbCity().getSelectedItem().toString();
        String postCode = jpAddDoctor.getJtfPostCode1().getText();
        String password = new String(jpAddDoctor.getJpwPassword().getPassword());
        String personalID = jpAddDoctor.getJtfPersonalId().getText();
        
        AdminClinic adminClinic = new AdminClinic();
        Person person = new Person();
        City birthCity = new City();
        
        //set country name
        
        // set city name
        birthCity = userValidation.findTheCity(birthPlace);
        
        
        //set martial status
        MartialStatus ms = new MartialStatus();
        ms = userValidation.findTheMartialStatus();
        // set religion id
        Religion rel = new Religion();
        rel = userValidation.findTheReligion();
        
        // set gender id 
        Gender gen = new Gender();
        gen = userValidation.findTheGender();
        
        // set actual city id 
        City cit = new City();
        cit = userValidation.findTheCity(city);
        
        // set actual address id 
        Address add = new Address();
        add.setCityId(cit);
        add.setBuildingNumber(Integer.parseInt(postCode));
        add.setStreetName(address);
        
        person.setPersonId(Integer.parseInt(personalID));
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMiddleName(middleName);
        person.setDateOfBirth(dateOfBorth);
        person.setBirthCityId(birthCity);
        person.setGenderId(gen);
        person.setAddressId(add);
        person.setReigionId(rel);
        person.setMartialStatusId(ms);
 
        
        adminClinic.setPassCode(password);
        adminClinic.setPersonId(person);
        person.setAdminClinic(adminClinic);
        
        
        String msg = userValidation.validatePerson(person);
        
        if("Validated".equals(msg))
        {
            String persistMsg = null;
            persistMsg = persistAdminClinic(adminClinic);
            if("Saved".equals(persistMsg))
            {
                JOptionPane.showMessageDialog(null, "User is saved");
                clearTheFields("AdminClinic");
                showViewAdminScreen();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, persistMsg);
            }
        }
        else if ("You must type your first name".equals(msg))
        {
            JOptionPane.showMessageDialog(null, msg);
        } 
    }
     private String persistAdminClinic(AdminClinic adminClinic)
    {
        String personMsg = null;
        String addressMsg = null;
        String receptionistMsg = null;
        
        SQLRepository repo = new SQLRepository();
        Person person = adminClinic.getPersonId();
        
        //Gender genderTo = person.getGenderId();
        Address addressTo = person.getAddressId();
        String streetName = addressTo.getStreetName();
        String postCode = addressTo.getBuildingNumber().toString();
        
        addressMsg = userValidation.checkIfAddressExists(streetName,postCode); // if street name and post code and city and county same dont add new address
        personMsg = userValidation.checkIfUserExists(person);
        receptionistMsg = userValidation.checkIfAdminClinicExists(adminClinic);
        
        if("Save".equals(personMsg) && "Save".equals(receptionistMsg))
        {
            if("Save".equals(addressMsg))
            {
                //save address and person
                repo.add(addressTo);
                repo.add(person);
                //repo.add(doctor);
                return "Saved";
            }
            else
            {
                repo.add(person);
                //repo.add(receptionist);
                return "Saved";
            }
        }

            return "Save".equals(personMsg)?receptionistMsg:personMsg;
    }
     
     public void clearTheFields(String type)
     {
         switch(type)
         {
             case "Doctor":
                 jpAddDoctor.getJtfFirstName().setText("");
                 jpAddDoctor.getJtfLastName().setText("");
                 jpAddDoctor.getJtfMiddleName().setText("");
                 jpAddDoctor.getJtfPersonalId().setText("");
                 jpAddDoctor.getJtfMobilePhone().setText("");
                 jpAddDoctor.getJtfEmail().setText("");
                 jpAddDoctor.getJtfAddress1().setText("");
                 jpAddDoctor.getJtfPostCode1().setText("");
                 jpAddDoctor.getJpwPassword().setText("");
                 jpAddDoctor.getJtfPersonalId().setText("");
                 break;
            case "Patient":
                 jpAddPatient.getJtfFirstName().setText("");
                 jpAddPatient.getJtfLastName().setText("");
                 jpAddPatient.getJtfMiddleName().setText("");
                 jpAddPatient.getJtfPersonalId().setText("");
                 jpAddPatient.getJtfMobilePhone().setText("");
                 jpAddPatient.getJtfEmail().setText("");
                 jpAddPatient.getJtfAddress1().setText("");
                 jpAddPatient.getJtfPostCode1().setText("");
                 jpAddPatient.getJpwPassword().setText("");
                 jpAddPatient.getJtfPersonalId().setText("");
                 break;
            case "AdminClinic":
                 jpAddAdminClinic.getJtfFirstName().setText("");
                 jpAddAdminClinic.getJtfLastName().setText("");
                 jpAddAdminClinic.getJtfMiddleName().setText("");
                 jpAddAdminClinic.getJtfPersonalId().setText("");
                 jpAddAdminClinic.getJtfMobilePhone().setText("");
                 jpAddAdminClinic.getJtfEmail().setText("");
                 jpAddAdminClinic.getJtfAddress1().setText("");
                 jpAddAdminClinic.getJtfPostCode1().setText("");
                 jpAddAdminClinic.getJpwPassword().setText("");
                 jpAddAdminClinic.getJtfPersonalId().setText("");
                 break;
             case "Receptionist":
                 jpAddReceptionist.getJtfFirstName().setText("");
                 jpAddReceptionist.getJtfLastName().setText("");
                 jpAddReceptionist.getJtfMiddleName().setText("");
                 jpAddReceptionist.getJtfPersonalId().setText("");
                 jpAddReceptionist.getJtfMobilePhone().setText("");
                 jpAddReceptionist.getJtfEmail().setText("");
                 jpAddReceptionist.getJtfAddress1().setText("");
                 jpAddReceptionist.getJtfPostCode1().setText("");
                 jpAddReceptionist.getJpwPassword().setText("");
                 jpAddReceptionist.getJtfPersonalId().setText("");
                 break;  
            case "Nurse":
                 jpAddNurse.getJtfFirstName().setText("");
                 jpAddNurse.getJtfLastName().setText("");
                 jpAddNurse.getJtfMiddleName().setText("");
                 jpAddNurse.getJtfPersonalId().setText("");
                 jpAddNurse.getJtfMobilePhone().setText("");
                 jpAddNurse.getJtfEmail().setText("");
                 jpAddNurse.getJtfAddress1().setText("");
                 jpAddNurse.getJtfPostCode1().setText("");
                 jpAddNurse.getJpwPassword().setText("");
                 jpAddNurse.getJtfPersonalId().setText("");
                 break;      
            case "Pharmacist":
                 jpAddPharmacist.getJtfFirstName().setText("");
                 jpAddPharmacist.getJtfLastName().setText("");
                 jpAddPharmacist.getJtfMiddleName().setText("");
                 jpAddPharmacist.getJtfPersonalId().setText("");
                 jpAddPharmacist.getJtfMobilePhone().setText("");
                 jpAddPharmacist.getJtfEmail().setText("");
                 jpAddPharmacist.getJtfAddress1().setText("");
                 jpAddPharmacist.getJtfPostCode1().setText("");
                 jpAddPharmacist.getJpwPassword().setText("");
                 jpAddPharmacist.getJtfPersonalId().setText("");
                 break;  
            case "PharmacyManager":
                 jpAddPharmacyManager.getJtfFirstName().setText("");
                 jpAddPharmacyManager.getJtfLastName().setText("");
                 jpAddPharmacyManager.getJtfMiddleName().setText("");
                 jpAddPharmacyManager.getJtfPersonalId().setText("");
                 jpAddPharmacyManager.getJtfMobilePhone().setText("");
                 jpAddPharmacyManager.getJtfEmail().setText("");
                 jpAddPharmacyManager.getJtfAddress1().setText("");
                 jpAddPharmacyManager.getJtfPostCode1().setText("");
                 jpAddPharmacyManager.getJpwPassword().setText("");
                 jpAddPharmacyManager.getJtfPersonalId().setText("");
                 break;      
                     
         }
     }
}
