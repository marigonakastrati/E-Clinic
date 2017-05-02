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
import com.ubt.healthcare.dto.Country;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Gender;
import com.ubt.healthcare.dto.MartialStatus;
import com.ubt.healthcare.dto.Person;
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
    private JPanelAddReceptionist jpAddReceptionist;
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

    public JFAdmin(JPAddDoctor jpAddDoctor, JPanelAddReceptionist jpAddReceptionist,
                JPanelViewDoctor jpViewDoctor, JPanelViewReceptionist jpViewReceptionist, 
                JPanelViewProfile jpViewProfile, JPanelEditProfile jpEditProfile ,JPanelAdminScreen jpAdminScreen, AdminClinic admin) 
    {
        this.jpAddDoctor = jpAddDoctor;
        this.jpAddReceptionist = jpAddReceptionist;
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

        jpAddReceptionist.setVisible(false);
        jpViewDoctor.setVisible(false);
        jpViewReceptionist.setVisible(false);
        jpViewProfile.setVisible(false);
        jpAdminScreen.setVisible(false);
        jpAddDoctor.setVisible(true);
        //jspPane = new JScrollPane(jpAddDoctor, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    }

    public void showAddReceptionistScreen() {
        /*jp.getJtfUserId().setText("");
        jpLoginScreen.getJtfpassCode().setText("");
        jpLoginScreen.getJtfUserId().requestFocusInWindow();
        //clCardlayout.show(jpMain, "Login Screen"); Maybe i will not use CardLayout
        //clCardlayout.previous(jpMain);
        //switchToScreen(loginScreen);
        //jpViewScheduleScreen.setVisible(false);
        jpAuthScreen.setVisible(false);
        jpLoginScreen.setVisible(true);
        jpLoginScreen.getJtfUserId().requestFocusInWindow();// request focus after logout*/

    }
    
    public void showViewDoctorScreen()
    {
        /*jpViewScheduleScreen.getJtaSubjectName()
                        .setText(person.getGroupId().getScheduleId().getSubjectId().getSubjectName());
        jpViewScheduleScreen.getJtaStartTime()
                        .setText(person.getGroupId().getScheduleId().getStartTime().toString()+"");
        jpViewScheduleScreen.getJtaEndTime()
                        .setText(person.getGroupId().getScheduleId().getEndTime().toString()+"");
        jpViewScheduleScreen.getJtaRoomNumber()
                        .setText(person.getGroupId().getScheduleId().getRoomId().getRoomId()+"");
        jpViewScheduleScreen.getJtaStatus()
                        .setText(person.getGroupId().getScheduleId().getStatusId().getStatusName());*/
        
        /*jpAuthScreen.setVisible(false);
        jpLoginScreen.setVisible(false);*/
        
    }
    
    public void showViewProfileScreen() 
    {
        /*jpStudentEditScreen.getJtaCity().setText(person.getPersonId().getCity());
        jpStudentEditScreen.getJtaauthID().setText(person.getStudentId()+"");
        jpStudentEditScreen.getJtaGroupName().setText(person.getGroupId().getGroupName());
        jpStudentEditScreen.getJtauthName().setText(person.getPersonId().getFirstName());
        jpStudentEditScreen.getJtauthSurname().setText(person.getPersonId().getLastName());*/
        
        /*jpAuthScreen.setVisible(false);
        jpLoginScreen.setVisible(false);*/
        jpAddReceptionist.setVisible(false);
        jpViewDoctor.setVisible(false);
        jpViewReceptionist.setVisible(false);
        jpViewProfile.setVisible(true);
        jpAdminScreen.setVisible(false);
        jpAddDoctor.setVisible(false);
        //jspPane = new JScrollPane(jpViewProfile, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    }
    
    
    public void showViewReceptionistScreen()
    {
       /* Person person = person.getPersonId();
        person.setCity(jpStudentEditScreen.getJtaCity().getText());
        student.setPersonId(person);
        person.setStudent(student);
        personService.update(person);
        studentService.update(student);*/
    }
    
    public void showViewAdminScreen()
    {
       /* Person person = person.getPersonId();
        person.setCity(jpStudentEditScreen.getJtaCity().getText());
        student.setPersonId(person);
        person.setStudent(student);
        personService.update(person);
        studentService.update(student);*/

        jpAddReceptionist.setVisible(false);
        jpViewDoctor.setVisible(false);
        jpViewReceptionist.setVisible(false);
        jpViewProfile.setVisible(false);
        jpAdminScreen.setVisible(true);
        jpAddDoctor.setVisible(false);
    }
    
    public void showLogInScreen()
    {
       /* Person person = person.getPersonId();
        person.setCity(jpStudentEditScreen.getJtaCity().getText());
        student.setPersonId(person);
        person.setStudent(student);
        personService.update(person);
        studentService.update(student);*/

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
        add.setPostCode(postCode);
        add.setStreetName(address);
        
        person.setPersonId(Integer.parseInt(personalID));
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMiddleName(middleName);
        person.setDateOfBirth(dateOfBorth);
        person.setBirthCityId(birthCity);
        person.setGenderId(gen);
        person.setAddressId(add);
        person.setReligionId(rel);
        person.setMartialStatusId(ms);
 
        
        doctor.setPassCode(password);
        doctor.setPersonId(person);
        person.setDoctor(doctor);
        
        
        String msg = userValidation.validateDoctor(doctor);
        
        if("Validated".equals(msg))
        {
            String persistMsg = null;
            persistMsg = persistDoctor(doctor);
            if("Saved".equals(persistMsg))
            {
                JOptionPane.showMessageDialog(null, "User is saved");
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
        String postCode = addressTo.getPostCode();
        
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
                repo.add(doctor);
                return "Saved";
            }
        }

            return "Save".equals(personMsg)?doctorMsg:personMsg;
    }
    
}
