/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.eventhandling;

import com.ubt.healthcare.ui.admin.JIFEditDoctor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterDeleteSelectedEducationEditDoctorInternalFrame extends MouseAdapter{
    private JIFEditDoctor jifEditDoctor;

    public MouseAdapterDeleteSelectedEducationEditDoctorInternalFrame(JIFEditDoctor jifEditDoctor) {
        this.jifEditDoctor = jifEditDoctor;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jifEditDoctor.deleteEducation();
    }
    
    
}
