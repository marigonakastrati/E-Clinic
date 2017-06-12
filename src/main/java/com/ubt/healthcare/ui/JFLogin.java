/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui;

import com.ubt.healthcare.business.AuthenticateUser;
import com.ubt.healthcare.business.UserGroupService;
import com.ubt.healthcare.dto.AdminClinic;
import com.ubt.healthcare.dto.Patient;
import com.ubt.healthcare.dto.Pharmacist;
import com.ubt.healthcare.dto.PharmacyManager;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.HRManager;
import com.ubt.healthcare.dto.Nurse;
import com.ubt.healthcare.ui.admin.JFAdminScreen;
import com.ubt.healthcare.ui.admin.JIFDoctor;
import com.ubt.healthcare.ui.admin.JIFNurse;
import com.ubt.healthcare.ui.admin.JIFPharmacist;
import com.ubt.healthcare.ui.admin.JIFPharmacyManager;
import com.ubt.healthcare.ui.admin.JIFReceptionist;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterDoctorScreen;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterLogOut;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterNurseScreen;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterPharmacistScreen;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterReceptionistScreen;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSaveNewDoctorF;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSaveNewNurse;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSaveNewPharmacist;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSaveNewReceptionist;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSearchDoctorF;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSearchNurse;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSearchPharmacist;
import com.ubt.healthcare.ui.admin.eventhandling.MouseAdapterSearchReceptionist;
import com.ubt.healthcare.ui.clinicManager.JFClinicManager;
import com.ubt.healthcare.ui.clinicManager.JIFAddShift;
import com.ubt.healthcare.ui.clinicManager.JIFReports;
import com.ubt.healthcare.ui.clinicManager.JIFSearchDoctor;
import com.ubt.healthcare.ui.clinicManager.eventhandling.MouseAdapterAddShiftScreen;
import com.ubt.healthcare.ui.clinicManager.eventhandling.MouseAdapterReportScreen;
import com.ubt.healthcare.ui.clinicManager.eventhandling.MouseAdapterSaveSchedule;
import com.ubt.healthcare.ui.clinicManager.eventhandling.MouseAdapterSearchDoctor;
import com.ubt.healthcare.ui.clinicManager.eventhandling.MouseAdapterSearchSchedule;
import com.ubt.healthcare.ui.clinicManager.eventhandling.MouseAdapterSearchScheduleReports;
import com.ubt.healthcare.ui.clinicManager.eventhandling.MouseAdapterSelectDoctor;
import com.ubt.healthcare.ui.clinicManager.eventhandling.MouseAdapterViewReports;
import com.ubt.healthcare.ui.clinicManager.eventhandling.MouseAdapterViewSearchDoctor;
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
    private JFClinicManager jfHRManager;
    private UserGroupService userGroupService;
    private AuthenticateUser authUser;
    private InputValidation inputValidation;

    public JFLogin(JPMain jpMain, JPLoginScreen jpLoginScreen, JFAdminScreen jfAdminScreen, JFClinicManager jfHRManager) {
        this.jpLoginScreen = jpLoginScreen;
        this.jpMain = jpMain;
        this.jfAdminScreen = jfAdminScreen;
        this.jfHRManager = jfHRManager;
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
        try {
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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error detected while connecting on database");

        }

    }

    private void swithToRole(String userRole, String user) {
        try {
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

            } else if ("Nurse".equals(userRole)) {
                String passcode = new String(jpLoginScreen.getJtfpassCode().getPassword());
                Nurse nurse = (Nurse) authUser.authenticateNurse(user, passcode);
                if (nurse != null) {
                    showNurseScreen(nurse);
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong passcode");
                    // clear the filed from jpLoginscreen...
                }

            } else if ("HRManager".equals(userRole)) {// clinic manager
                String passcode = new String(jpLoginScreen.getJtfpassCode().getPassword());
                HRManager clinicManager = (HRManager) authUser.authenticateClinicManager(user, passcode);
                if (clinicManager != null) {
                    showClinicManagerScreen(clinicManager);
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong passcode");
                    // clear the filed from jpLoginscreen...
                }

            } else {
                JOptionPane.showMessageDialog(null, "Credentials wrong");
                // clear the filed from jpLoginscreen...
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error detected while connecting on database");

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

    public void showNurseScreen(Nurse nurse) {
        //JFPharmacist jfPharmacist = new JFPharmacist();
        // call the listeners and JPanels
    }

    public void showClinicManagerScreen(HRManager clinicManager) {

        JIFSearchDoctor jifSearchDoctor = new JIFSearchDoctor();
        JIFAddShift jifAddShift = new JIFAddShift(jifSearchDoctor);
        JIFReports jifReports = new JIFReports();
        jfHRManager = new JFClinicManager(jifAddShift, jifReports, jifSearchDoctor);

        jfHRManager.addReportsMouseAdapter(new MouseAdapterReportScreen(jfHRManager));
        jfHRManager.addAddShiftScreenMouseAdapter(new MouseAdapterAddShiftScreen(jfHRManager));
        jfHRManager.addLogOutMouseAdapter(new MouseAdapterLogOut(this));

        jifAddShift.addSearchShiftPanelMouseAdapter(new MouseAdapterSearchSchedule(jifAddShift));
        jifAddShift.addSaveShiftInternalFrameMouseAdapter(new MouseAdapterSaveSchedule(jifAddShift));
        jifAddShift.addSelectDoctorPanelMouseAdapter(new MouseAdapterViewSearchDoctor(jfHRManager));
        jifAddShift.setHrManager(clinicManager);

        jifReports.addViewReportInternalFrameMouseAdapter(new MouseAdapterViewReports(jifReports));
        jifReports.addSearchShiftPanelMouseAdapter(new MouseAdapterSearchScheduleReports(jifReports));

        jifSearchDoctor.addSearchDoctorPanelMouseAdapter(new MouseAdapterSearchDoctor(jifSearchDoctor));
        jifSearchDoctor.addSelectDoctorPanelMouseAdapter(new MouseAdapterSelectDoctor(jifAddShift));

        this.setVisible(false);
        jfHRManager.setVisible(true);
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
        jfHRManager.dispose();
        jfHRManager.setVisible(false);

    }

    public void showDoctorFrameScreen(Doctor doctor) {

        JIFDoctor jifDoctorF = new JIFDoctor();
        JIFNurse jifNurse = new JIFNurse();
        JIFReceptionist jifReceptionist = new JIFReceptionist();
        JIFPharmacist jifPharmacist = new JIFPharmacist();
        JIFPharmacyManager jifPharmacyManager = new JIFPharmacyManager();
        jfAdminScreen = new JFAdminScreen(jifDoctorF, jifNurse, jifReceptionist, jifPharmacist, jifPharmacyManager);

        jfAdminScreen.addDoctorScreenMouseAdapter(new MouseAdapterDoctorScreen(jfAdminScreen));
        jfAdminScreen.addNurseScreenMouseAdapter(new MouseAdapterNurseScreen(jfAdminScreen));
        jfAdminScreen.addAddReceptionistMouseAdapter(new MouseAdapterReceptionistScreen(jfAdminScreen));
        jfAdminScreen.addPharmacistScreenMouseAdapter(new MouseAdapterPharmacistScreen(jfAdminScreen));
        jfAdminScreen.addLogOutMouseAdapter(new MouseAdapterLogOut(this));

        jifDoctorF.addSaveDoctorInternalFrameMouseAdapter(new MouseAdapterSaveNewDoctorF(jifDoctorF));
        jifDoctorF.addSearchDoctorPanelMouseAdapter(new MouseAdapterSearchDoctorF(jifDoctorF));

        jifNurse.addSaveNurseInternalFrameMouseAdapter(new MouseAdapterSaveNewNurse(jifNurse));
        jifNurse.addSearchNursePanelMouseAdapter(new MouseAdapterSearchNurse(jifNurse));

        jifReceptionist.addSaveReceptionistInternalFrameMouseAdapter(new MouseAdapterSaveNewReceptionist(jifReceptionist));
        jifReceptionist.addSearchReceptionistPanelMouseAdapter(new MouseAdapterSearchReceptionist(jifReceptionist));

        jifPharmacist.addSavePharmacistInternalFrameMouseAdapter(new MouseAdapterSaveNewPharmacist(jifPharmacist));
        jifPharmacist.addSearchPharmacistPanelMouseAdapter(new MouseAdapterSearchPharmacist(jifPharmacist));

        this.setVisible(false);
        jfAdminScreen.setVisible(true);
    }

    /*public void showDoctorFrameScreen(Doctor doctor) {

        JIFAddCountry jifAddCountry = new JIFAddCountry();
        JIFAddCity jifAddCity = new JIFAddCity(jifAddCountry);
        JIFSearchDoctor jifSearchDoctor = new JIFSearchDoctor();
        JIFAddDoctor jifAddDoctor = new JIFAddDoctor(jifAddCity);
        JIFEditDoctor jifEditDoctor = new JIFEditDoctor(jifAddCity);
        JIFDoctor jifDoctorF = new JIFDoctor();

        JIFDoctor ilfDoctor = new JIFDoctor(jifSearchDoctor, jifAddDoctor, jifEditDoctor, jifAddCity, jifAddCountry);

        jfAdminScreen = new JFAdminScreen(ilfDoctor,jifDoctorF);

        jfAdminScreen.addDoctorScreenMouseAdapter(new MouseAdapterDoctorScreen(jfAdminScreen));
        jfAdminScreen.addLogOutMouseAdapter(new MouseAdapterLogOut(this));

        ilfDoctor.addSearchDoctorInternalFrameMouseAdapter(new MouseAdapterShowSearchDoctor(jfAdminScreen));
        ilfDoctor.addOpenAddDoctorInternalFrameMouseAdapter(new MouseAdapterShowAddDoctor(jfAdminScreen));
        ilfDoctor.addEditDoctorInternalFrameMouseAdapter(new MouseAdapterShowEditDoctor(jfAdminScreen));

        jifSearchDoctor.addSearchReceptionistPanelMouseAdapter(new MouseAdapterSearchDoctor(jifSearchDoctor));
        jifSearchDoctor.addSelectDoctorPanelMouseAdapter(new MouseAdapterSelectDoctorSearch(ilfDoctor));

        jifAddDoctor.addSaveReceptionistInternalFrameMouseAdapter(new MouseAdapterSaveNewDoctor(ilfDoctor));
        jifAddDoctor.addSaveEducationDoctorInternalFrameMouseAdapter(new MouseAdapterSaveEducationAddDoctor(jifAddDoctor));
        jifAddDoctor.addCancleFieldSelectionEducationDoctorInternalFrameMouseAdapter(new MouseAdapterCancleSelectionEducationAddDoctor(jifAddDoctor));
        jifAddDoctor.addDeleteEducationDoctorInternalFrameMouseAdapter(new MouseAdapterDeleteSelectedEducationAddDoctor(jifAddDoctor));
        jifAddDoctor.addCloseAddDoctorInternalFrameMouseAdapter(new MouseAdapterCloseSaveNewDoctor(ilfDoctor));
        jifAddDoctor.addAddNewCityInternalFrameMouseAdapter(new MouseAdapterShowCityAddDoctor(jfAdminScreen));

        //jifEditDoctor.addAddNewCityInternalFrameMouseAdapter(new MouseAdapterShowEditDoctor(jfAdminScreen));
        jifEditDoctor.addSaveReceptionistInternalFrameMouseAdapter(new MouseAdapterEditDoctor(ilfDoctor));
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
        
        jifDoctorF.addSearchReceptionistPanelMouseAdapter(new MouseAdapterSearchDoctorF(jifDoctorF));
        jifDoctorF.addSaveReceptionistInternalFrameMouseAdapter(new MouseAdapterSaveNewDoctorF(jifDoctorF));

        this.setVisible(false);
        jfAdminScreen.setVisible(true);
    }*/
}
