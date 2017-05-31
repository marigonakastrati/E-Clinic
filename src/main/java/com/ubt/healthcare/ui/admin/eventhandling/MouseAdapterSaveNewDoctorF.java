/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.eventhandling;

import com.ubt.healthcare.ui.admin.JIFDoctorF;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterSaveNewDoctorF extends MouseAdapter{
    private JIFDoctorF jifDoctor;

    public MouseAdapterSaveNewDoctorF(JIFDoctorF jifDoctor) {
        this.jifDoctor = jifDoctor;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jifDoctor.saveDoctorInternalFrameAddDoctor();
    }
    
    
}
