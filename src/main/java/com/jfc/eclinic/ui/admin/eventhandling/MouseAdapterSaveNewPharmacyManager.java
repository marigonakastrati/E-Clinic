/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.eventhandling;

import com.ubt.healthcare.ui.admin.JIFPharmacyManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Marigona
 */
public class MouseAdapterSaveNewPharmacyManager extends MouseAdapter{
        private JIFPharmacyManager jifPharmacyManager;
  
    public MouseAdapterSaveNewPharmacyManager(JIFPharmacyManager jifPharmacyManager) {
        this.jifPharmacyManager = jifPharmacyManager;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jifPharmacyManager.savePharmacyManagerInternalFrameAddPharmacyManager();
    }
}
