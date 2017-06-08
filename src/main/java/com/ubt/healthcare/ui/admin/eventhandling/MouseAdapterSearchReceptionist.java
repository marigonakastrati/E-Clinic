/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.eventhandling;

import com.ubt.healthcare.ui.admin.JIFReceptionist;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterSearchReceptionist extends MouseAdapter{
    private JIFReceptionist jifReceptionist;

    public MouseAdapterSearchReceptionist(JIFReceptionist jifReceptionist) {
        this.jifReceptionist = jifReceptionist;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jifReceptionist.searchReceptionistInternalPane();
    }
    
    
}
