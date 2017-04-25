/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.view.eventhandling;

import com.ubt.healthcare.view.JFMain;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterLogin extends MouseAdapter{
    private JFMain jfMain;

    public MouseAdapterLogin(JFMain jfMain) {
        this.jfMain = jfMain;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jfMain.showStudentInformationScreen();;
    }
    
    @Override
     public void mouseEntered(MouseEvent arg0) {
        jfMain.getJlLoginLabel()
                    .setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/ubt/kiosk/view/images/sign-hover.png")));
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
         jfMain.getJlLoginLabel()
                   .setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/ubt/kiosk/view/images/sign.png")));
    }

}
