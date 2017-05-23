/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.eventhandling;

import com.ubt.healthcare.ui.admin.JIFAddDoctor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterCancleSelectionEducationAddDoctorInternalFrame extends MouseAdapter{
    private JIFAddDoctor jidAddDoctor;

    public MouseAdapterCancleSelectionEducationAddDoctorInternalFrame(JIFAddDoctor jidAddDoctor) {
        this.jidAddDoctor = jidAddDoctor;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jidAddDoctor.clearFields(1);
    }
    
    
}
