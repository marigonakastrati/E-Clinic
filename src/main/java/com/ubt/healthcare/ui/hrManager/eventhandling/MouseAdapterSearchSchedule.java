/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.hrManager.eventhandling;

import com.ubt.healthcare.ui.hrManager.JIFAddShift;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterSearchSchedule extends MouseAdapter{
    private JIFAddShift jifAdddShift;

    public MouseAdapterSearchSchedule(JIFAddShift jifAdddShift) {
        this.jifAdddShift = jifAdddShift;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jifAdddShift.searchShiftInternalPane();
    }
    
    
}
