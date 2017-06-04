/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.eventhandling;

import com.ubt.healthcare.ui.admin.JIFNurse;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterSearchNurse extends MouseAdapter{
    private JIFNurse jifNurse;

    public MouseAdapterSearchNurse(JIFNurse jifNurse) {
        this.jifNurse = jifNurse;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jifNurse.searchNurseInternalPane();
    }
    
    
}
