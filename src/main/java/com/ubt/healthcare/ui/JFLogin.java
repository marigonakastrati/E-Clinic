/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui;

import com.ubt.healthcare.ui.admin.JIFSearchDoctor;
import com.ubt.healthcare.business.AuthenticateUser;
import com.ubt.healthcare.business.UserGroupService;
import com.ubt.healthcare.dto.AdminClinic;
import com.ubt.healthcare.dto.Patient;
import com.ubt.healthcare.dto.Pharmacist;
import com.ubt.healthcare.dto.PharmacyManager;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.ui.admin.JFAdminScreen;
import com.ubt.healthcare.ui.admin.JIFAddDoctor;
import com.ubt.healthcare.ui.admin.JIFDoctor;
import com.ubt.healthcare.ui.admin.JIFDoctorF;
import com.ubt.healthcare.ui.admin.JIFEditDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterCancleSelectionEducationAddDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterCancleSelectionEducationEditDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterCloseCountry;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterCloseEditDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterCloseSaveNewDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterDeleteSelectedEducationAddDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterDeleteSelectedEducationEditDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterDoctorScreen;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterEditDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterLogOut;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSaveCityAddDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSaveCountry;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSaveEducationAddDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSaveEducationEditDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSaveNewDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSaveNewDoctorF;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSearchDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSearchDoctorF;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSelectDoctorSearch;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterShowAddDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterShowCityAddDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterShowCountryAddDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterShowEditDoctor;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterShowSearchDoctor;
import com.ubt.healthcare.ui.util.InputValidation;
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
    private CardLayout clCardlayout;
    private JFAdminScreen jfAdminScreen;
    private UserGroupService userGroupService;
    private AuthenticateUser authUser;
    private InputValidation inputValidation;

    public JFLogin(JPMain jpMain, JPLoginScreen jpLoginScreen, JFAdminScreen jfAdminScreen) {
        this.jpLoginScreen = jpLoginScreen;
        this.jpMain = jpMain;
        this.jfAdminScreen = jfAdminScreen;
        this.authUser = new AuthenticateUser();
        userGroupService = new UserGroupService();
        inputValidation = new InputValidation();
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

    public void authenticateUser() {
        String user = jpLoginScreen.getJtfUserId().getText();
        String password = new String(jpLoginScreen.getJtfpassCode().getPassword());
        /*find if the user typed exists on table UserGroupRoles 
            and determine its group based on the group type show the appropiate JFrame 
            e.g. JFAdmin, JFDoctor which on its self has JPViewSample JPanels...
            when the user presses logout the JFrame should terminate
            but the JFLogin should not...*/

        //check if user is empty
        String msgUser = inputValidation.validateUserName(user);
        String msgPassword = inputValidation.validatePassword(password);
        if ("Valid".equals(msgUser) && "Valid".equals(msgPassword)) {
            String userMsg = userGroupService.checkIfUserxists(user);
            if ("Valid".equals(userMsg)) {
                String userRole = userGroupService.authorization(user);// role validation
                swithToRole(userRole, user);
            } else if ("Wrong".equals(userMsg)) {
                JOptionPane.showMessageDialog(null, "User Name is " + userMsg);

            }
        } else if ("Type user name".equals(msgUser)) {
            JOptionPane.showMessageDialog(null, "User Name is Empty");
        } else if ("You shoud type only numbers".equals(msgUser)) {
            JOptionPane.showMessageDialog(null, msgUser);
        } else {
            JOptionPane.showMessageDialog(null, "Type the correct login information");
        }

    }

    private void swithToRole(String userRole, String user) {
        if ("AdminClinic".equals(userRole)) {
            String passcode = new String(jpLoginScreen.getJtfpassCode().getPassword());
            AdminClinic admin = (AdminClinic) authUser.authenticateAdminClinic(user, passcode);
            if (admin != null) {
                showAdminScreen(admin);
            } else {
                JOptionPane.showMessageDialog(null, "Wrong passcode");
                // clear the filed from jpLoginscreen...
            }
        } else if ("Doctor".equals(userRole)) {
            String passcode = new String(jpLoginScreen.getJtfpassCode().getPassword());
            Doctor doctor = (Doctor) authUser.authenticateDoctor(user, passcode);
            if (doctor != null) {
                //showDoctorScreen(doctor); old version with jpane
                showDoctorFrameScreen(doctor); // new version with jinternalpane
            } else {
                JOptionPane.showMessageDialog(null, "Wrong passcode");
                // clear the filed from jpLoginscreen...
            }

        } else if ("Patient".equals(userRole)) {
            String passcode = new String(jpLoginScreen.getJtfpassCode().getPassword());
            Patient patient = (Patient) authUser.authenticatePatient(user, passcode);
            if (patient != null) {
                showPatientScreen(patient);
            } else {
                JOptionPane.showMessageDialog(null, "Wrong passcode");
                // clear the filed from jpLoginscreen...
            }

        } else if ("Pharmacist".equals(userRole)) {
            String passcode = new String(jpLoginScreen.getJtfpassCode().getPassword());
            Pharmacist pharmacist = (Pharmacist) authUser.authenticatePharmacist(user, passcode);
            if (pharmacist != null) {
                showPharmacistScreen(pharmacist);
            } else {
                JOptionPane.showMessageDialog(null, "Wrong passcode");
                // clear the filed from jpLoginscreen...
            }

        } else if ("PharmacyManager".equals(userRole)) {
            String passcode = new String(jpLoginScreen.getJtfpassCode().getPassword());
            PharmacyManager pharmacyManager = (PharmacyManager) authUser.authenticatePharmacyManager(user, passcode);
            if (pharmacyManager != null) {
                showPharmacyManagerScreen(pharmacyManager);
            } else {
                JOptionPane.showMessageDialog(null, "Wrong passcode");
                // clear the filed from jpLoginscreen...
            }

        } else {
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
    public void showAdminScreen(AdminClinic admin) {
        /*JPAddDoctor jpAddDoctor = new JPAddDoctor();
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
        /*jpViewProfile.getJtfId().setText(String.valueOf(admin.getAdminClinicId()));
        jpViewProfile.getJtfName().setText(String.valueOf(admin.getPersonId().getFirstName()));
        jpViewProfile.getJtfSurName().setText(String.valueOf(admin.getPersonId().getLastName()));*/
 /*
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
        jfAdmin.setSize(800, 800);*/
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

    public void showLoginScreen() {
        jpLoginScreen.getJtfUserId().setText("");
        jpLoginScreen.getJtfpassCode().setText("");
        jpLoginScreen.getJtfUserId().requestFocusInWindow();
        setVisible(true);
        jpLoginScreen.setVisible(true);
        jfAdminScreen.dispose();
        jfAdminScreen.setVisible(false);

    }

    public void showDoctorFrameScreen(Doctor doctor) {

        JIFDoctorF jifDoctorF = new JIFDoctorF();

        jfAdminScreen = new JFAdminScreen(jifDoctorF);

        jfAdminScreen.addDoctorScreenMouseAdapter(new MouseAdapterDoctorScreen(jfAdminScreen));
        jfAdminScreen.addLogOutMouseAdapter(new MouseAdapterLogOut(this));
        jifDoctorF.addSearchDoctorPanelMouseAdapter(new MouseAdapterSearchDoctorF(jifDoctorF));
        jifDoctorF.addSaveDoctorInternalFrameMouseAdapter(new MouseAdapterSaveNewDoctorF(jifDoctorF));

        this.setVisible(false);
        jfAdminScreen.setVisible(true);
    }

    /*public void showDoctorFrameScreen(Doctor doctor) {

        JIFAddCountry jifAddCountry = new JIFAddCountry();
        JIFAddCity jifAddCity = new JIFAddCity(jifAddCountry);
        JIFSearchDoctor jifSearchDoctor = new JIFSearchDoctor();
        JIFAddDoctor jifAddDoctor = new JIFAddDoctor(jifAddCity);
        JIFEditDoctor jifEditDoctor = new JIFEditDoctor(jifAddCity);
        JIFDoctorF jifDoctorF = new JIFDoctorF();

        JIFDoctor ilfDoctor = new JIFDoctor(jifSearchDoctor, jifAddDoctor, jifEditDoctor, jifAddCity, jifAddCountry);

        jfAdminScreen = new JFAdminScreen(ilfDoctor,jifDoctorF);

        jfAdminScreen.addDoctorScreenMouseAdapter(new MouseAdapterDoctorScreen(jfAdminScreen));
        jfAdminScreen.addLogOutMouseAdapter(new MouseAdapterLogOut(this));

        ilfDoctor.addSearchDoctorInternalFrameMouseAdapter(new MouseAdapterShowSearchDoctor(jfAdminScreen));
        ilfDoctor.addOpenAddDoctorInternalFrameMouseAdapter(new MouseAdapterShowAddDoctor(jfAdminScreen));
        ilfDoctor.addEditDoctorInternalFrameMouseAdapter(new MouseAdapterShowEditDoctor(jfAdminScreen));

        jifSearchDoctor.addSearchDoctorPanelMouseAdapter(new MouseAdapterSearchDoctor(jifSearchDoctor));
        jifSearchDoctor.addSelectDoctorPanelMouseAdapter(new MouseAdapterSelectDoctorSearch(ilfDoctor));

        jifAddDoctor.addSaveDoctorInternalFrameMouseAdapter(new MouseAdapterSaveNewDoctor(ilfDoctor));
        jifAddDoctor.addSaveEducationDoctorInternalFrameMouseAdapter(new MouseAdapterSaveEducationAddDoctor(jifAddDoctor));
        jifAddDoctor.addCancleFieldSelectionEducationDoctorInternalFrameMouseAdapter(new MouseAdapterCancleSelectionEducationAddDoctor(jifAddDoctor));
        jifAddDoctor.addDeleteEducationDoctorInternalFrameMouseAdapter(new MouseAdapterDeleteSelectedEducationAddDoctor(jifAddDoctor));
        jifAddDoctor.addCloseAddDoctorInternalFrameMouseAdapter(new MouseAdapterCloseSaveNewDoctor(ilfDoctor));
        jifAddDoctor.addAddNewCityInternalFrameMouseAdapter(new MouseAdapterShowCityAddDoctor(jfAdminScreen));

        //jifEditDoctor.addAddNewCityInternalFrameMouseAdapter(new MouseAdapterShowEditDoctor(jfAdminScreen));
        jifEditDoctor.addSaveDoctorInternalFrameMouseAdapter(new MouseAdapterEditDoctor(ilfDoctor));
        jifEditDoctor.addCloseAddDoctorInternalFrameMouseAdapter(new MouseAdapterCloseEditDoctor(ilfDoctor));
        jifEditDoctor.addSaveEducationDoctorInternalFrameMouseAdapter(new MouseAdapterSaveEducationEditDoctor(jifEditDoctor));
        jifEditDoctor.addCancleFieldSelectionEducationDoctorInternalFrameMouseAdapter(new MouseAdapterCancleSelectionEducationEditDoctor(jifEditDoctor));
        jifEditDoctor.addDeleteEducationDoctorInternalFrameMouseAdapter(new MouseAdapterDeleteSelectedEducationEditDoctor(jifEditDoctor));

        jifAddCity.addSaveCityAddDoctorInternalFrameMouseAdapter(new MouseAdapterSaveCityAddDoctor(jifAddDoctor));
        //jifAddCity.addSaveCityEditDoctorInternalFrameMouseAdapter(new MouseAdapterSaveCityEditDoctor(jifEditDoctor));
        //jifAddCity.addCloseCityAddDoctorInternalFrameMouseAdapter(new MouseAdapterCloseCityAddDoctorInternalFrame(jifAddDoctor));
        //jifAddCity.addCloseCityEditDoctorInternalFrameMouseAdapter(new MouseAdapterCloseCityEditDoctorInternalFrame(jifEditDoctor));
        jifAddCity.addAddCountryInternalFrameMouseAdapter(new MouseAdapterShowCountryAddDoctor(jfAdminScreen));

        jifAddCountry.addSaveCountryInternalFrameMouseAdapter(new MouseAdapterSaveCountry(jifAddCity));
        jifAddCountry.addCloseCountryInternalFrameMouseAdapter(new MouseAdapterCloseCountry(jifAddCity));
        
        jifDoctorF.addSearchDoctorPanelMouseAdapter(new MouseAdapterSearchDoctorF(jifDoctorF));
        jifDoctorF.addSaveDoctorInternalFrameMouseAdapter(new MouseAdapterSaveNewDoctorF(jifDoctorF));

        this.setVisible(false);
        jfAdminScreen.setVisible(true);
    }*/
}
