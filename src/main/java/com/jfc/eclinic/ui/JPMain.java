/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author F
 */
public class JPMain extends JPanel{

    private JLabel jlBackground = new JLabel("");// Enter your pass code
    public JPMain() {
        this.setBorder(new EmptyBorder(5, 5, 5, 5)); 
        this.add(jlBackground);
    }
    
    
}
