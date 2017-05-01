/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui;

import com.ubt.healthcare.ui.eventhandling.MouseAdapterCloseWindows;
import com.ubt.healthcare.ui.eventhandling.MouseAdapterLogin;

/**
 *
 * @author F Starts the main Gui app, and assigns the listeners for each
 * components start the application
 */
public class Main {

    public static void main(String[] args) {
        
        JPMain jpMain = new JPMain();
        JPLoginScreen jpLoginScreen = new JPLoginScreen();
        //JPInformationScreen jpStudentInformation = new JPInformationScreen();
        //JPProfile jpProfile = new JPProfile();
        //JPAddDoctor jpAddDoctor = new JPAddDoctor();
        //JFMain jfMain = new JFMain(jpMain, jpLoginScreen, jpStudentInformation,jpProfile,jpAddDoctor);
        JFLogin jfLogin = new JFLogin(jpMain, jpLoginScreen);
        
        jpLoginScreen.addCloseMainWindowsMouseAdapter(new MouseAdapterCloseWindows(jfLogin));
        jpLoginScreen.addLoginMouseAdapter(new MouseAdapterLogin(jfLogin));
        /*jpStudentInformation.addEditStudentMouseAdapter(new MouseAdapterEditScreen(jfMain));
        jpStudentInformation.addViewScheduleScreenListener(new MouseAdapterViewSchedule(jfMain));
        jpStudentInformation.addLogOutAdapter(new MouseAdapterLogOut(jfMain));*/

        jfLogin.setSize(800, 800);

    }
}
