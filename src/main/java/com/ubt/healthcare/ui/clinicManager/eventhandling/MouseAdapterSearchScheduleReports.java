/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.clinicManager.eventhandling;

import com.ubt.healthcare.ui.clinicManager.JIFReports;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterSearchScheduleReports extends MouseAdapter{
    private JIFReports jifReports;

    public MouseAdapterSearchScheduleReports(JIFReports jifReports) {
        this.jifReports = jifReports;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jifReports.searchShiftInternalPane();
    }
    
    
}
