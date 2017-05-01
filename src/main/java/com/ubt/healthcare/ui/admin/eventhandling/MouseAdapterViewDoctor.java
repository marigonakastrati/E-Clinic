/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.eventhandling;

import com.ubt.healthcare.ui.admin.JFAdmin;
import com.ubt.healthcare.ui.admin.JPanelViewDoctor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterViewDoctor extends MouseAdapter{
    private JFAdmin jfAdmin;

    public MouseAdapterViewDoctor(JFAdmin jfAdmin) {
        this.jfAdmin = jfAdmin;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jfAdmin.showViewDoctorScreen();;
    }
    
    
}
