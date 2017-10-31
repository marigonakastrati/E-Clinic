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
public class MouseAdapterSaveSchedule extends MouseAdapter{
    private JIFAddShift jifAdddShift;

    public MouseAdapterSaveSchedule(JIFAddShift jifAdddShift) {
        this.jifAdddShift = jifAdddShift;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jifAdddShift.saveShiftInternalFrame();
    }
    
    
}
