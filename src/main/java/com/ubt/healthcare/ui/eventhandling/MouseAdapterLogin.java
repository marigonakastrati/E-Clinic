/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.eventhandling;

import com.ubt.healthcare.ui.JFLogin;
import com.ubt.healthcare.ui.JFMain;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

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
        ImageIcon icSingHover = new ImageIcon("C:\\Users\\F\\Documents\\NetBeansProjects\\Health-care-Maven\\src\\main\\java\\com\\ubt\\healthcare\\ui\\images\\sign-hover.png");
        jfLogin.getJlLoginLabel()
                    .setIcon(icSingHover);
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
         ImageIcon icSing = new ImageIcon("C:\\Users\\F\\Documents\\NetBeansProjects\\Health-care-Maven\\src\\main\\java\\com\\ubt\\healthcare\\ui\\images\\sign.png");
         jfLogin.getJlLoginLabel()
                   .setIcon(icSing);
    }

}
