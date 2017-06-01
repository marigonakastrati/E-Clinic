/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui;

import com.ubt.healthcare.ui.admin.JFAdminScreen;
import com.ubt.healthcare.ui.eventhandling.KeyListenerLogin;
import com.ubt.healthcare.ui.eventhandling.MouseAdapterCloseWindows;
import com.ubt.healthcare.ui.eventhandling.MouseAdapterLogin;

/**
 *
 * @author F 
 */
public class Main {

    public static void main(String[] args) {
        
        JPMain jpMain = new JPMain();
        JPLoginScreen jpLoginScreen = new JPLoginScreen();
        JFAdminScreen jfAdminScreen = new JFAdminScreen();
        JFLogin jfLogin = new JFLogin(jpMain, jpLoginScreen,jfAdminScreen);
        
        jpLoginScreen.addCloseMainWindowsMouseAdapter(new MouseAdapterCloseWindows(jfLogin));
        jpLoginScreen.addLoginMouseAdapter(new MouseAdapterLogin(jfLogin));
        jpLoginScreen.addLoginEnterKeyListener(new KeyListenerLogin(jfLogin));

        jfLogin.setSize(800, 800);
        jfLogin.setLocationRelativeTo(null);

    }
}
