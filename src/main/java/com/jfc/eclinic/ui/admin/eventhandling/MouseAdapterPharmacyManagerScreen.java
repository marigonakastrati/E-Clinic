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
 * @author Marigona
 */
public class MouseAdapterPharmacyManagerScreen extends MouseAdapter{
    
    private JFAdminScreen jfAdminScreen;

    public MouseAdapterPharmacyManagerScreen(JFAdminScreen jfAdminScreen) {
        this.jfAdminScreen = jfAdminScreen;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jfAdminScreen.showPharmacyManagerScreen();
    }
    
    
}
