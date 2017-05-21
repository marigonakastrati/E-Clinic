/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui;

import com.ubt.healthcare.ui.admin.JIFSearchDoctor;
import com.ubt.healthcare.business.AuthenticateUser;
import com.ubt.healthcare.business.UserGroupAuthorization;
import com.ubt.healthcare.business.UserValidation;
import com.ubt.healthcare.dto.AdminClinic;
import com.ubt.healthcare.dto.Patient;
import com.ubt.healthcare.dto.Pharmacist;
import com.ubt.healthcare.dto.PharmacyManager;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.ui.admin.JFAdmin;
import com.ubt.healthcare.ui.admin.JFAdminScreen;
import com.ubt.healthcare.ui.admin.JIFAddDoctor;
import com.ubt.healthcare.ui.admin.JIFDoctor;
import com.ubt.healthcare.ui.admin.JPAddAdminClinic;
import com.ubt.healthcare.ui.admin.JPAddDoctor;
import com.ubt.healthcare.ui.admin.JPAddNurse;
import com.ubt.healthcare.ui.admin.JPAddPatient;
import com.ubt.healthcare.ui.admin.JPAddPharmacist;
import com.ubt.healthcare.ui.admin.JPAddPharmacyManager;
import com.ubt.healthcare.ui.admin.JPAddReceptionist;
import com.ubt.healthcare.ui.admin.JPanelAdminScreen;
import com.ubt.healthcare.ui.admin.JPanelViewDoctor;
import com.ubt.healthcare.ui.admin.JPanelViewReceptionist;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterAddDoctorScreen;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterAddReceptionistScreen;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterAdminScreen;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterCancleSelectionDoctorEducationInternalFrame;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterCloseSaveNewDoctorInternalFrame;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterDeleteSelectedDoctorEducationInternalFrame;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterDoctorScreenInternalFrame;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterEditProfileScreen;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterLogOut;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterPersistAdminClinic;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterPersistDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterPersistNurse;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterPersistPatient;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterPersistPharmacist;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterPersistPharmacyManager;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterPersistReceptionist;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSaveDoctorEducationInternalFrame;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSaveNewDoctorInternalFrame;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSearchDoctorInternalFrame;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSelectDoctorSearchInternalFrame;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterShowAddDoctorInternalFrame;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterShowSearchDoctorInternalFrame;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterViewDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterViewProfile;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterViewReceptionist;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author F
 */
public class JFLogin extends JFrame {

    private JPLoginScreen jpLoginScreen;
    private JPMain jpMain;
    private JFAdmin jfAdmin;
    private CardLayout clCardlayout ;
    private UserValidation userValidation;
    private UserGroupAuthorization userGroupAuthorization;
    private AuthenticateUser authUser ;

    public JFLogin(JPMain jpMain, JPLoginScreen jpLoginScreen) 
    {
        this.jpLoginScreen = jpLoginScreen;
        this.jpMain = jpMain;
        this.userValidation = new UserValidation();
        this.userGroupAuthorization = new UserGroupAuthorization();
        this.authUser = new AuthenticateUser();
        clCardlayout = new CardLayout();
        setUndecorated(true);// disable the minimize, maximize, close
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
        setBounds(100, 100, 300, 300);
        jpMain.setLayout(clCardlayout);

        
        jpMain.add(jpLoginScreen, "Login Screen");// it works by using the second paramteter to switch the JPanels
        clCardlayout.show(jpMain, "Show");

        add(jpMain);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("E Clinic");
        pack();
        setVisible(true);

    }

    public void authenticateUser() 
    {
        String user = jpLoginScreen.getJtfUserId().getText();
        /*find if the user typed exists on table UserGroupRoles 
            and determine its group based on the group type show the appropiate JFrame 
            e.g. JFAdmin, JFDoctor which on its self has JPViewSample JPanels...
            when the user presses logout the JFrame should terminate
            but the JFLogin should not...*/
        String msg = userValidation.validateUser(user);// input validation
        if("Validated".equals(msg))
        {
            String userRole = userGroupAuthorization.authorization(user);// role validation
            swithToRole(userRole, user);
        }
        else if ("The user is empty".equals(msg))
        {
             JOptionPane.showMessageDialog(null, "User Name is Empty");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Type the correct login information");
        }
        
        

    }
    
    private void swithToRole(String userRole, String user)
    {
        if ("AdminClinic".equals(userRole)) 
        {
            String passcode = new String(jpLoginScreen.getJtfpassCode().getPassword());
            AdminClinic admin = (AdminClinic)authUser.authenticateAdminClinic(user, passcode);
            if(admin != null)
            {
                showAdminScreen(admin);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong passcode");
                // clear the filed from jpLoginscreen...
            }        
        } 
        else if ("Doctor".equals(userRole)) 
        {
            String passcode = new String(jpLoginScreen.getJtfpassCode().getPassword());
            Doctor doctor = (Doctor)authUser.authenticateDoctor(user, passcode);
            if(doctor != null)
            {
                //showDoctorScreen(doctor); old version with jpane
                showDoctorFrameScreen(doctor); // new version with jinternalpane
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong passcode");
                // clear the filed from jpLoginscreen...
            }      
            
        } 
        else if ("Patient".equals(userRole)) 
        {
            String passcode = new String(jpLoginScreen.getJtfpassCode().getPassword());
            Patient patient = (Patient)authUser.authenticatePatient(user, passcode);
            if(patient != null)
            {
                showPatientScreen(patient);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong passcode");
                // clear the filed from jpLoginscreen...
            }   
            
        } 
        else if ("Pharmacist".equals(userRole)) 
        {
            String passcode = new String(jpLoginScreen.getJtfpassCode().getPassword());
            Pharmacist pharmacist = (Pharmacist)authUser.authenticatePharmacist(user, passcode);
            if(pharmacist != null)
            {
                showPharmacistScreen(pharmacist);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong passcode");
                // clear the filed from jpLoginscreen...
            }   
            
        } 
        else if ("PharmacyManager".equals(userRole)) 
        {
            String passcode = new String(jpLoginScreen.getJtfpassCode().getPassword());
            PharmacyManager pharmacyManager = (PharmacyManager)authUser.authenticatePharmacyManager(user, passcode);
            if(pharmacyManager != null)
            {
                showPharmacyManagerScreen(pharmacyManager);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong passcode");
                // clear the filed from jpLoginscreen...
            }   
           
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Credentials wrong");
            // clear the filed from jpLoginscreen...
        }
    }

    public JLabel getJlCloseWindowsLoginScreen() {
        return jpLoginScreen.getJlcloseWindows();
    }

    public JLabel getJlLoginLabel() {
        return jpLoginScreen.getJllogin();
    }
    
    /*
        create method which does instatiate the JFAdmin and its dependencies 
        and sets the values after authentication...
    */
    public void showAdminScreen(AdminClinic admin)
    {
        JPAddDoctor jpAddDoctor = new JPAddDoctor();
        JPAddNurse jpAddNurse = new JPAddNurse();
        JPAddPatient jpAddPatient = new JPAddPatient();
        JPAddPharmacyManager jpAddPharmacyManager = new JPAddPharmacyManager();
        JPAddPharmacist jpAddPharmacist = new JPAddPharmacist();
        JPAddReceptionist jpAddReceptionist = new JPAddReceptionist();
        JPAddAdminClinic jpAddAdminClinic = new JPAddAdminClinic();
        JPanelViewDoctor jpViewDoctor = new JPanelViewDoctor();
        JPanelViewReceptionist jpViewReceptionist = new JPanelViewReceptionist();
        JPanelViewProfile jpViewProfile = new JPanelViewProfile();
        //JPanelEditProfile jpEditProfile = new JPanelEditProfile();
        JPanelAdminScreen jpAdminScreen = new JPanelAdminScreen();
        /*jfAdmin = new JFAdmin(jpAddDoctor,jpAddNurse,jpAddPatient,jpAddPharmacyManager,jpAddPharmacist,jpAddReceptionist,
                            jpAddAdminClinic,jpViewDoctor, jpViewReceptionist, jpViewProfile, jpEditProfile, jpAdminScreen, admin);*/
        
        // set the Admin profile parameters
        jpViewProfile.getJtfId().setText(String.valueOf(admin.getAdminClinicId()));
        jpViewProfile.getJtfName().setText(String.valueOf(admin.getPersonId().getFirstName()));
        jpViewProfile.getJtfSurName().setText(String.valueOf(admin.getPersonId().getLastName()));
        
        // call the listeners and JPanels
        jpAdminScreen.addLogOutMouseAdapter(new MouseAdapterLogOut(this));
        jpAdminScreen.addViewDoctorMouseAdapter(new MouseAdapterViewDoctor(jfAdmin));
        jpAdminScreen.addViewReceptionistMouseAdapter(new MouseAdapterViewReceptionist(jfAdmin));
        jpAdminScreen.addViewProfileMouseAdapter(new MouseAdapterViewProfile(jfAdmin));
        
        jpAdminScreen.addAddDoctorMouseAdapter(new MouseAdapterAddDoctorScreen(jfAdmin));
        jpAdminScreen.addAddReceptionistMouseAdapter(new MouseAdapterAddReceptionistScreen(jfAdmin));
        
        jpAdminScreen.addAddAdminClinicMouseAdapter(new MouseAdapterAddReceptionistScreen(jfAdmin));
        jpAdminScreen.addAddPharmacyManagerMouseAdapter(new MouseAdapterAddReceptionistScreen(jfAdmin));
        jpAdminScreen.addAddNurseMouseAdapter(new MouseAdapterAddReceptionistScreen(jfAdmin));
        jpAdminScreen.addAddPatientMouseAdapter(new MouseAdapterAddReceptionistScreen(jfAdmin));
        jpAdminScreen.addAddPharmacistMouseAdapter(new MouseAdapterAddReceptionistScreen(jfAdmin));
        
        jpAddReceptionist.addBackToAdminScreenMouseAdapter(new MouseAdapterAdminScreen(jfAdmin));
        
        jpViewReceptionist.addBackToAdminScreenMouseAdapter(new MouseAdapterAdminScreen(jfAdmin));
        
        jpAddDoctor.addBackToAdminScreenMouseAdapter(new MouseAdapterAdminScreen(jfAdmin));
        jpAddDoctor.addRegisterDoctorMouseAdapter(new MouseAdapterPersistDoctor(jfAdmin));

        jpAddNurse.addBackToAdminScreenMouseAdapter(new MouseAdapterAdminScreen(jfAdmin));
        jpAddNurse.addRegisterDoctorMouseAdapter(new MouseAdapterPersistNurse(jfAdmin));

        jpAddPatient.addBackToAdminScreenMouseAdapter(new MouseAdapterAdminScreen(jfAdmin));
        jpAddPatient.addRegisterDoctorMouseAdapter(new MouseAdapterPersistPatient(jfAdmin));

        jpAddPharmacyManager.addBackToAdminScreenMouseAdapter(new MouseAdapterAdminScreen(jfAdmin));
        jpAddPharmacyManager.addRegisterDoctorMouseAdapter(new MouseAdapterPersistPharmacyManager(jfAdmin));

        jpAddPharmacist.addBackToAdminScreenMouseAdapter(new MouseAdapterAdminScreen(jfAdmin));
        jpAddPharmacist.addRegisterDoctorMouseAdapter(new MouseAdapterPersistPharmacist(jfAdmin));

        jpAddReceptionist.addBackToAdminScreenMouseAdapter(new MouseAdapterAdminScreen(jfAdmin));
        jpAddReceptionist.addRegisterDoctorMouseAdapter(new MouseAdapterPersistReceptionist(jfAdmin));

        jpAddAdminClinic.addBackToAdminScreenMouseAdapter(new MouseAdapterAdminScreen(jfAdmin));
        jpAddAdminClinic.addRegisterDoctorMouseAdapter(new MouseAdapterPersistAdminClinic(jfAdmin));
        
        jpViewDoctor.addBackToAdminScreenMouseAdapter(new MouseAdapterAdminScreen(jfAdmin));
        
        
        jpViewProfile.addBackToAdminScreenMouseAdapter(new MouseAdapterAdminScreen(jfAdmin));
        jpViewProfile.addUpdateAdminMouseAdapter(new MouseAdapterEditProfileScreen(jfAdmin));
        
        this.setVisible(false);
        jfAdmin.setSize(800, 800);
    }
    
    public void showPatientScreen(Patient patient) {
        //JFPatient jfPatient = new JFPatient();
             // call the listeners and JPanels
    }

    public void showDoctorScreen(Doctor doctor) {
       //JFDoctor jfDoctor = new JFDoctor();
             // call the listeners and JPanels
    }

    public void showPharmacistScreen(Pharmacist pharmacist) {
       //JFPharmacist jfPharmacist = new JFPharmacist();
             // call the listeners and JPanels
    }
    public void showPharmacyManagerScreen(PharmacyManager pharmacyManager) {
        //JFPharmacyManager jfPharmacyManager = new JFPharmacyManager();
            // call the listeners and JPanels
    }
    
    public void showLoginScreen()
    {
        jpLoginScreen.getJtfUserId().setText("");
        jpLoginScreen.getJtfpassCode().setText("");
        jpLoginScreen.getJtfUserId().requestFocusInWindow();
        //clCardlayout.show(jpMain, "Login Screen"); Maybe i will not use CardLayout
        //clCardlayout.previous(jpMain);
        //switchToScreen(loginScreen);
        //jpViewScheduleScreen.setVisible(false);
        setVisible(true);
        jpLoginScreen.setVisible(true);
        jfAdmin.dispose();
        
    }
    
    public void showDoctorFrameScreen(Doctor doctor)
    {
        
        JIFSearchDoctor ilfViewDoctor = new JIFSearchDoctor();      
        JIFAddDoctor jifAddDoctor = new JIFAddDoctor();
        
        JIFDoctor ilfDoctor = new JIFDoctor(ilfViewDoctor, jifAddDoctor);
        
        
        JFAdminScreen jfAdminScreen = new JFAdminScreen(ilfDoctor);
        
        jfAdminScreen.addDoctorScreenMouseAdapter(new MouseAdapterDoctorScreenInternalFrame(jfAdminScreen));
        
        ilfDoctor.addSearchDoctorInternalFrameMouseAdapter(new MouseAdapterShowSearchDoctorInternalFrame(jfAdminScreen));
        ilfDoctor.addOpenAddDoctorInternalFrameMouseAdapter(new MouseAdapterShowAddDoctorInternalFrame(jfAdminScreen));
        
        ilfViewDoctor.addSearchDoctorPanelMouseAdapter(new MouseAdapterSearchDoctorInternalFrame(ilfViewDoctor));
        
        ilfViewDoctor.addSelectDoctorPanelMouseAdapter(new MouseAdapterSelectDoctorSearchInternalFrame(ilfDoctor));
        
        jifAddDoctor.addSaveDoctorInternalFrameMouseAdapter(new MouseAdapterSaveNewDoctorInternalFrame(ilfDoctor));
        jifAddDoctor.addSaveEducationDoctorInternalFrameMouseAdapter(new MouseAdapterSaveDoctorEducationInternalFrame(jifAddDoctor));
        jifAddDoctor.addCancleFieldSelectionEducationDoctorInternalFrameMouseAdapter(new MouseAdapterCancleSelectionDoctorEducationInternalFrame(jifAddDoctor));
        jifAddDoctor.addDeleteEducationDoctorInternalFrameMouseAdapter(new MouseAdapterDeleteSelectedDoctorEducationInternalFrame(jifAddDoctor));
        jifAddDoctor.addAddDoctorInternalFrameMouseAdapter(new MouseAdapterCloseSaveNewDoctorInternalFrame(ilfDoctor));
  
        this.setVisible(false);
        jfAdminScreen.setVisible(true);
    }

}
