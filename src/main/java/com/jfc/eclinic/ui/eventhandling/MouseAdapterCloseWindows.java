/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.eventhandling;

import com.ubt.healthcare.ui.JFLogin;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author F
 */
public class MouseAdapterCloseWindows extends MouseAdapter {

    private JFLogin jfLogin;
    
    public MouseAdapterCloseWindows(JFLogin jfLogin) 
    {
        this.jfLogin = jfLogin;
    }

    @Override
    public void mouseEntered(MouseEvent arg0) 
    {
        ImageIcon icHover =new ImageIcon(getClass().getResource("/com/ubt/healthcare/ui/images/close-hover.png"));
        jfLogin.getJlCloseWindowsLoginScreen()
                .setIcon(icHover);
    }

    @Override
    public void mouseExited(MouseEvent arg0) 
    {
        ImageIcon icClose =new ImageIcon(getClass().getResource("/com/ubt/healthcare/ui/images/close.png"));
        jfLogin.getJlCloseWindowsLoginScreen()
                .setIcon(icClose);
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
         System.exit(0);
    }
}
