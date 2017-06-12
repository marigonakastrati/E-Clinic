/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.clinicManager.eventhandling;

import com.ubt.healthcare.ui.clinicManager.JFClinicManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterAddShiftScreen extends MouseAdapter{
    private JFClinicManager jfHRManager;

    public MouseAdapterAddShiftScreen(JFClinicManager jfHRManager) {
        this.jfHRManager = jfHRManager;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jfHRManager.showAddShiftScreen();
    }
    
    
}
