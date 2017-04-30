/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.view;

import com.ubt.healthcare.view.admin.JPAddDoctor;
import com.ubt.healthcare.view.eventhandling.MouseAdapterCloseWindows;
import com.ubt.healthcare.view.eventhandling.MouseAdapterEditScreen;
import com.ubt.healthcare.view.eventhandling.MouseAdapterLogOut;
import com.ubt.healthcare.view.eventhandling.MouseAdapterLogin;
import com.ubt.healthcare.view.eventhandling.MouseAdapterViewSchedule;

/**
 *
 * @author F Starts the main Gui app, and assigns the listeners for each
 * components start the application
 */
public class Main {

    public static void main(String[] args) {
        
        JPMain jpMain = new JPMain();
        JPLoginScreen jpLoginScreen = new JPLoginScreen();
        JPInformationScreen jpStudentInformation = new JPInformationScreen();
        JPProfile jpProfile = new JPProfile();
        JPAddDoctor jpAddDoctor = new JPAddDoctor();
        JFMain jfMain = new JFMain(jpMain, jpLoginScreen, jpStudentInformation,jpProfile,jpAddDoctor);
        
        jpLoginScreen.addCloseMainWindowsMouseAdapter(new MouseAdapterCloseWindows(jfMain));
        jpLoginScreen.addLoginMouseAdapter(new MouseAdapterLogin(jfMain));
        jpStudentInformation.addEditStudentMouseAdapter(new MouseAdapterEditScreen(jfMain));
        jpStudentInformation.addViewScheduleScreenListener(new MouseAdapterViewSchedule(jfMain));
        jpStudentInformation.addLogOutAdapter(new MouseAdapterLogOut(jfMain));

        jfMain.setSize(800, 800);

    }
}
