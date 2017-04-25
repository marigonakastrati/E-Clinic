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
public class MouseAdapterCloseWindows extends MouseAdapter {

    private JFMain jpinterface;
    
    public MouseAdapterCloseWindows(JFMain jpinterface) 
    {
        this.jpinterface = jpinterface;
    }

    @Override
    public void mouseEntered(MouseEvent arg0) 
    {
        ImageIcon icHover = new ImageIcon("C:\\Users\\F\\Documents\\NetBeansProjects\\Health-care-Maven\\src\\main\\java\\com\\ubt\\healthcare\\view\\images\\close-hover.png");

        jpinterface.getJlCloseWindowsLoginScreen()
                .setIcon(icHover);
    }

    @Override
    public void mouseExited(MouseEvent arg0) 
    {
        ImageIcon icClose = new ImageIcon("C:\\Users\\F\\Documents\\NetBeansProjects\\Health-care-Maven\\src\\main\\java\\com\\ubt\\healthcare\\view\\images\\close.png");
        jpinterface.getJlCloseWindowsLoginScreen()
                .setIcon(icClose);

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
         System.exit(0);
    }
}
