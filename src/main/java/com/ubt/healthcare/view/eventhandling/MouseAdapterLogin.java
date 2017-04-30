/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.view.eventhandling;

import com.ubt.healthcare.view.JFMain;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author F
 */
public class MouseAdapterLogin extends MouseAdapter{
    private JFMain jfMain;

    public MouseAdapterLogin(JFMain jfMain) {
        this.jfMain = jfMain;
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        jfMain.showStudentInformationScreen();;
    }
    
    @Override
     public void mouseEntered(MouseEvent arg0) {
        ImageIcon icSingHover = new ImageIcon("C:\\Users\\F\\Documents\\NetBeansProjects\\Health-care-Maven\\src\\main\\java\\com\\ubt\\healthcare\\view\\images\\sign-hover.png");
        jfMain.getJlLoginLabel()
                    .setIcon(icSingHover);
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
         ImageIcon icSing = new ImageIcon("C:\\Users\\F\\Documents\\NetBeansProjects\\Health-care-Maven\\src\\main\\java\\com\\ubt\\healthcare\\view\\images\\sign.png");
         jfMain.getJlLoginLabel()
                   .setIcon(icSing);
    }

}
