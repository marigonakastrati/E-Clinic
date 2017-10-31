/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.clinicManager.eventhandling;

import com.ubt.healthcare.ui.clinicManager.JIFAddShift;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterSelectDoctor extends MouseAdapter{
    private JIFAddShift jifAddShift;

    public MouseAdapterSelectDoctor(JIFAddShift jifAddShift) {
        this.jifAddShift = jifAddShift;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jifAddShift.updateDoctorFields();
    }
    
    
}
