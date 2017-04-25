/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.view;

import com.ubt.healthcare.business.AuthenticateUser;
import com.ubt.healthcare.entity.AdminClinic;
import com.ubt.healthcare.entity.Person;
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
    private JPViewScheduleScreen jpViewScheduleScreen;
    private JPStudentEditScreen jpStudentEditScreen;
    private JPProfile jpProfile;
    private CardLayout clCardlayout ;
    private Person person;

    public JFMain(JPMain jpMain, JPLoginScreen jpLoginScreen, JPInformationScreen jpAuthScreen,
            JPViewScheduleScreen jpViewScheduleScreen, JPStudentEditScreen jpStudentEditScreen,JPProfile jpProfile) {
        this.jpMain = jpMain;
        this.jpLoginScreen = jpLoginScreen;
        this.jpAuthScreen = jpAuthScreen;
        this.jpViewScheduleScreen = jpViewScheduleScreen;
        this.jpStudentEditScreen = jpStudentEditScreen;
        this.jpProfile = jpProfile;
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
        jpMain.add(jpStudentEditScreen, "Student");
        jpMain.add(jpViewScheduleScreen, "Schedule");
        jpMain.add(jpProfile, "Profile");
        clCardlayout.show(jpMain, "Change");

        add(jpMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Information System - Terminal Point");
        pack();
        setVisible(true);
    }

    public AdminClinic authUser() {
        String id = jpLoginScreen.getJtfstudentId().getText();
        String passcode = new String(jpLoginScreen.getJtfpassCode().getPassword());
        AuthenticateUser auth = new AuthenticateUser();
        AdminClinic value = (AdminClinic)auth.authenticate(id, passcode);
        return value;
    }

    public void showStudentInformationScreen() {
        person = authUser().getPersonId();
        if (person != null) {
            jpAuthScreen.getJtaauthID().setText(person.getPersonId()+ "");
            jpAuthScreen.getJtaauthName().setText(person.getFirstName());
            jpAuthScreen.getJtaauthSurname().setText(person.getLastName());
            jpAuthScreen.getJtaGroupName().setText(person.getMaritalStatuss());
            jpAuthScreen.getJtaCity().setText(person.getBirthTown());
            //clCardlayout.show(jpMain, "Information Screen");
            //switchToScreen(informationScreen);
            jpLoginScreen.setVisible(false);
            jpViewScheduleScreen.setVisible(false);
            jpStudentEditScreen.setVisible(false);
            jpAuthScreen.setVisible(false);
            jpProfile.setVisible(true);
            //clCardlayout.next(jpMain);
            //clCardlayout.next(jpMain);
        } else {
            JOptionPane.showMessageDialog(null, "Wrong passcode");
        }
    }

    public void showLoginScreen() {
        jpLoginScreen.getJtfstudentId().setText("");
        jpLoginScreen.getJtfpassCode().setText("");
        jpLoginScreen.getJtfstudentId().requestFocusInWindow();
        //clCardlayout.show(jpMain, "Login Screen"); Maybe i will not use CardLayout
        //clCardlayout.previous(jpMain);
        //switchToScreen(loginScreen);
        //jpViewScheduleScreen.setVisible(false);
        jpAuthScreen.setVisible(false);
        jpStudentEditScreen.setVisible(false);
        jpViewScheduleScreen.setVisible(false);
        jpLoginScreen.setVisible(true);
        jpLoginScreen.getJtfstudentId().requestFocusInWindow();// request focus after logout

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
        jpStudentEditScreen.setVisible(false);
        jpViewScheduleScreen.setVisible(true);
        
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
        jpViewScheduleScreen.setVisible(false);
        jpStudentEditScreen.setVisible(true);

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
