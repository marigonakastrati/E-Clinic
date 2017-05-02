/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.eventhandling;

import com.ubt.healthcare.ui.JFLogin;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author F
 */
public class MouseAdapterUpdateStudentEditScreen extends MouseAdapter{
    private JFLogin jfMain;

    public MouseAdapterUpdateStudentEditScreen(JFLogin jfMain) {
        this.jfMain = jfMain;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) // call the update methods...
    {
        //jfMain.editStudent();
        JOptionPane.showMessageDialog(null, " Changes has been made");
    }
    
    
}
