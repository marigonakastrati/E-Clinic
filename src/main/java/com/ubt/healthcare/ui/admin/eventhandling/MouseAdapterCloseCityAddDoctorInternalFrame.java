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
public class MouseAdapterCloseCityAddDoctorInternalFrame extends MouseAdapter{
    private JIFAddDoctor jifAddDoctor;

    public MouseAdapterCloseCityAddDoctorInternalFrame(JIFAddDoctor jifAddDoctor) {
        this.jifAddDoctor = jifAddDoctor;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jifAddDoctor.closeSaveNewCityInternlaPaneListener();
    }
    
    
}
