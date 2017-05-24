/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.eventhandling;

import com.ubt.healthcare.ui.JIFAddCity;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterCloseCountry extends MouseAdapter{
    private JIFAddCity jifAddCity;

    public MouseAdapterCloseCountry(JIFAddCity jifAddCity) {
        this.jifAddCity = jifAddCity;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jifAddCity.closeSaveNewCountrInternlaPaneListener();
    }
    
    
}
