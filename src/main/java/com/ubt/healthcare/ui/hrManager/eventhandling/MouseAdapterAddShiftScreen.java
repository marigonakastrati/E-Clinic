/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.hrManager.eventhandling;

import com.ubt.healthcare.ui.hrManager.JFHRManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterAddShiftScreen extends MouseAdapter{
    private JFHRManager jfHRManager;

    public MouseAdapterAddShiftScreen(JFHRManager jfHRManager) {
        this.jfHRManager = jfHRManager;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jfHRManager.showAddShiftScreen();
    }
    
    
}
