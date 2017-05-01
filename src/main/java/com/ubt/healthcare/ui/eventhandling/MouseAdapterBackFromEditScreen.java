/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.eventhandling;

import com.ubt.healthcare.ui.JFMain;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author F
 */
public class MouseAdapterBackFromEditScreen extends MouseAdapter{
    private JFMain jfMain;

    public MouseAdapterBackFromEditScreen(JFMain jfMain) {
        this.jfMain = jfMain;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jfMain.showStudentInformationScreen();;
    }
    


    
}
