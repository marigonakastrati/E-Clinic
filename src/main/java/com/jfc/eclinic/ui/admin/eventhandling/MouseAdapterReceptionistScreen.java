/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.eventhandling;

import com.ubt.healthcare.ui.admin.JFAdminScreen;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterReceptionistScreen extends MouseAdapter{
    private JFAdminScreen jfAdminScreen;

    public MouseAdapterReceptionistScreen(JFAdminScreen jfAdminScreen) {
        this.jfAdminScreen = jfAdminScreen;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jfAdminScreen.showReceptionistScreen();
    }
    
    
}
