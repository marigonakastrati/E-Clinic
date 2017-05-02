/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.eventhandling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.ubt.healthcare.ui.JFLogin;

/**
 *
 * @author F
 */
public class ActionListenerLogout implements ActionListener {

    private JFLogin cr;

    public ActionListenerLogout(JFLogin cr) {
        this.cr = cr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //cr.showLoginScreen();
    }
}
