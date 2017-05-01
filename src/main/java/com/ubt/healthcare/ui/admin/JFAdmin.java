/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin;

import com.ubt.healthcare.dto.AdminClinic;
import com.ubt.healthcare.ui.JPMain;
import com.ubt.healthcare.ui.JPanelViewProfile;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author F
 */
public class JFAdmin extends JFrame{
    
    private JPanelAddDoctor jpAddDoctor;
    private JPanelAddReceptionist jpAddReceptionist;
    private JPanelViewDoctor jpViewDoctor;
    private JPanelViewReceptionist jpViewReceptionist;
    private JPanelViewProfile jpViewProfile;
    private JPanelAdminScreen jpAdminScreen;
    private JScrollPane jspPane;
    private JPMain jpMain;
    private CardLayout clCardlayout ;
    private AdminClinic admin;

    public JFAdmin(JPanelAddDoctor jpAddDoctor, JPanelAddReceptionist jpAddReceptionist,
                JPanelViewDoctor jpViewDoctor, JPanelViewReceptionist jpViewReceptionist, 
                JPanelViewProfile jpViewProfile, JPanelAdminScreen jpAdminScreen, AdminClinic admin) 
    {
        this.jpAddDoctor = jpAddDoctor;
        this.jpAddReceptionist = jpAddReceptionist;
        this.jpViewDoctor = jpViewDoctor;
        this.jpViewReceptionist = jpViewReceptionist;
        this.jpViewProfile = jpViewProfile;
        this.jpAdminScreen = jpAdminScreen;
        this.admin = admin;
        
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
}
