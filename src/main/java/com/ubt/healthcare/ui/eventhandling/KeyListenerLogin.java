/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.eventhandling;

import com.ubt.healthcare.ui.JFLogin;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author F
 */
public class KeyListenerLogin implements KeyListener {

    private JFLogin jfLogin;

    public KeyListenerLogin(JFLogin jfLogin) {
        this.jfLogin = jfLogin;
    }

    @Override
    public void keyTyped(KeyEvent e) {
   }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            jfLogin.authenticateUser();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       }

}
