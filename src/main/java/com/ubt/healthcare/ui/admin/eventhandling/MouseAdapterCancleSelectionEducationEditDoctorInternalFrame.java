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
public class MouseAdapterCancleSelectionEducationEditDoctorInternalFrame extends MouseAdapter{
    private JIFEditDoctor jidEditDoctor;

    public MouseAdapterCancleSelectionEducationEditDoctorInternalFrame(JIFEditDoctor jidEditDoctor) {
        this.jidEditDoctor = jidEditDoctor;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jidEditDoctor.clearFields(1);
    }
    
    
}
