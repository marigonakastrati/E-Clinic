/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.view.eventhandling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.ubt.healthcare.view.JFMain;

/**
 *
 * @author F
 */
public class ActionListenerLogout implements ActionListener {

    private JFMain cr;

    public ActionListenerLogout(JFMain cr) {
        this.cr = cr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cr.showLoginScreen();
    }
}
