/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.eventhandling;

import com.ubt.healthcare.ui.admin.JIFPharmacist;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author Marigona
 */
public class MouseAdapterSearchPharmacist extends MouseAdapter {
    
    private JIFPharmacist jifPharmacist;

    public MouseAdapterSearchPharmacist(JIFPharmacist jifPharmacist) {
        this.jifPharmacist = jifPharmacist;
    }

    public void mouseClicked(MouseEvent arg0) 
    {
        jifPharmacist.searchPharmacistInternalPane();
    }
    
    
}