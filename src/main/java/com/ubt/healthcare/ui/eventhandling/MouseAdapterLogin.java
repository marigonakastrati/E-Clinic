/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.eventhandling;

import com.ubt.healthcare.ui.JFLogin;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterLogin extends MouseAdapter{
    private JFLogin jfLogin;

    public MouseAdapterLogin(JFLogin jfLogin) {
        this.jfLogin = jfLogin;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jfLogin.authenticateUser();
    }
    
    @Override
     public void mouseEntered(MouseEvent arg0) {
        jfLogin.getJlLoginLabel()
                    .setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ubt/healthcare/ui/images/sign-hover.png")));
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
         jfLogin.getJlLoginLabel()
                   .setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ubt/healthcare/ui/images/sign.png")));
    }

}
