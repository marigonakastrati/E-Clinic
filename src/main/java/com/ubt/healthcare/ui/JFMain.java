/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui;

import com.ubt.healthcare.business.AuthenticateUser;
import com.ubt.healthcare.dto.AdminClinic;
import com.ubt.healthcare.dto.Person;
import com.ubt.healthcare.ui.admin.JPAddDoctor;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author F
 */
public class JFMain extends JFrame {

    private JPMain jpMain;
    private JPLoginScreen jpLoginScreen;
    private JPInformationScreen jpAuthScreen;
    private JPProfile jpProfile;
    private JPAddDoctor jpAddDoctor;
    private CardLayout clCardlayout ;
    private Person person;

    public JFMain(JPMain jpMain, JPLoginScreen jpLoginScreen, JPInformationScreen jpAuthScreen, JPProfile jpProfile,JPAddDoctor jpAddDoctor) 
    {
              
        this.jpMain = jpMain;
        this.jpLoginScreen = jpLoginScreen;
        this.jpAuthScreen = jpAuthScreen;
        this.jpProfile = jpProfile;
        this.jpAddDoctor  = jpAddDoctor;
        clCardlayout = new CardLayout();
        setUndecorated(true);// disable the minimize, maximize, close
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setBounds(100, 100, 300, 300);
        jpMain.setLayout(clCardlayout);
        //jploginscreen.setLayout(null);// if you want to change the [x, y, w, h] of  components set the layout manager to null...
        //but you will have problems when the frame size  changes
        //jpauthscreen.setLayout(null);
        jpMain.add(jpLoginScreen, "Login Screen");// it works by using the second paramteter to switch the JPanels
        jpMain.add(jpAuthScreen, "Information Screen");
        jpMain.add(jpProfile, "Profile");
        jpMain.add(jpAddDoctor, "Add Doctor");
        clCardlayout.show(jpMain, "Change");

        add(jpMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Information System - Terminal Point");
        pack();
        setVisible(true);
    }

    public AdminClinic authUser() {
        String id = jpLoginScreen.getJtfUserId().getText();
        String passcode = new String(jpLoginScreen.getJtfpassCode().getPassword());
        AuthenticateUser auth = new AuthenticateUser();
        AdminClinic value = (AdminClinic)auth.authenticateAdminClinic(id, passcode);
        return value;
    }

    public void showStudentInformationScreen() {
        person = authUser().getPersonId();
        if (person != null) {
            jpAuthScreen.getJtaauthID().setText(person.getPersonId()+ "");
            jpAuthScreen.getJtaauthName().setText(person.getFirstName());
            jpAuthScreen.getJtaauthSurname().setText(person.getLastName());
            jpAuthScreen.getJtaGroupName().setText(person.getGenderId().getGenderName());
            jpAuthScreen.getJtaCity().setText(person.getAddressId().getStreetName());
            //clCardlayout.show(jpMain, "Information Screen");
            //switchToScreen(informationScreen);
            jpLoginScreen.setVisible(false);
            jpAuthScreen.setVisible(false);
            jpProfile.setVisible(true);
            //jpAddDoctor.getjTextField17().setText("TestField");
            jpAddDoctor.setVisible(false);
            //clCardlayout.next(jpMain);
            //clCardlayout.next(jpMain);
        } else {
            JOptionPane.showMessageDialog(null, "Wrong passcode");
        }
    }

    public void showLoginScreen() {
        jpLoginScreen.getJtfUserId().setText("");
        jpLoginScreen.getJtfpassCode().setText("");
        jpLoginScreen.getJtfUserId().requestFocusInWindow();
        //clCardlayout.show(jpMain, "Login Screen"); Maybe i will not use CardLayout
        //clCardlayout.previous(jpMain);
        //switchToScreen(loginScreen);
        //jpViewScheduleScreen.setVisible(false);
        jpAuthScreen.setVisible(false);
        jpLoginScreen.setVisible(true);
        jpLoginScreen.getJtfUserId().requestFocusInWindow();// request focus after logout

    }
    
    public void showViewScheduleScreen()
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
        
        jpAuthScreen.setVisible(false);
        jpLoginScreen.setVisible(false);
        
    }
    
    public void showEditStudentScreen() 
    {
        /*jpStudentEditScreen.getJtaCity().setText(person.getPersonId().getCity());
        jpStudentEditScreen.getJtaauthID().setText(person.getStudentId()+"");
        jpStudentEditScreen.getJtaGroupName().setText(person.getGroupId().getGroupName());
        jpStudentEditScreen.getJtauthName().setText(person.getPersonId().getFirstName());
        jpStudentEditScreen.getJtauthSurname().setText(person.getPersonId().getLastName());*/
        
        jpAuthScreen.setVisible(false);
        jpLoginScreen.setVisible(false);

    }
    
    
    public void editStudent()
    {
       /* Person person = person.getPersonId();
        person.setCity(jpStudentEditScreen.getJtaCity().getText());
        student.setPersonId(person);
        person.setStudent(student);
        personService.update(person);
        studentService.update(student);*/
    }

    public JLabel getJlCloseWindowsLoginScreen() {
        return jpLoginScreen.getJlcloseWindows();
    }
    
     public JLabel getJlLoginLabel() {
        return jpLoginScreen.getJllogin();
    }



    public void switchToScreen(String screen)
    {
        clCardlayout.show(jpMain, screen);
    }

}
