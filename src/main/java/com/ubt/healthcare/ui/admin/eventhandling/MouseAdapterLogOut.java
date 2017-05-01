/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.eventhandling;

import com.ubt.healthcare.ui.JFLogin;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterLogOut extends MouseAdapter{
    private JFLogin jfLogin;

    public MouseAdapterLogOut(JFLogin jfMain) {
        this.jfLogin = jfMain;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jfLogin.showLoginScreen();;
    }
    
    
}
