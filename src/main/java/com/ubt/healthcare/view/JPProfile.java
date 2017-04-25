/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author F
 */
public class JPProfile extends JPanel {
    
    private JLabel jlauthId = new JLabel("ID ");
    private JTextArea jtaauthID = new JTextArea("");
    private JLabel jlauthName = new JLabel("Name ");
    private JTextArea jtauthName = new JTextArea("");
    private JLabel jlauthSurname = new JLabel("Surname");
    private JTextArea jtauthSurname = new JTextArea("");
    private JLabel jlDOB = new JLabel("Date of Birth");
    private JTextArea jtaDOB = new JTextArea("");
    private JLabel jlCity = new JLabel("City");
    private JTextArea jtaCity = new JTextArea("");
    private JLabel jlState = new JLabel("State");
    private JTextArea jtaState = new JTextArea("");
    private JLabel jlBack = new JLabel("Back");
    private JLabel jlAddDoctor = new JLabel("Add Doctor");
    private JLabel jlAddReceptionist = new JLabel("Add Receptionist");
    private JLabel jlViewDoctor = new JLabel("View Doctor");
    private JLabel jlViewReceptionist = new JLabel("View Receptionist");
    private JLabel jlChangePassword = new JLabel("Change Password");
    
    

    public JPProfile() 
    {
        this.setBackground(Color.GRAY);
        this.setLayout(null);
        
        jlauthId.setBounds(65, 10, 120, 25);
        jtaauthID.setBounds(125, 10, 120, 25);
        jlauthName.setBounds(65, 40, 120, 25);
        jtauthName.setBounds(125, 40, 120, 25);
        jlauthSurname.setBounds(65, 70, 120, 25);
        jtauthSurname.setBounds(125, 70, 120, 25);
        jlDOB.setBounds(65, 100, 120, 25);
        jtaDOB.setBounds(125, 100, 120, 25);
        jlCity.setBounds(65, 130, 120, 25);
        jtaCity.setBounds(125, 130, 120, 25);
        jlState.setBounds(60, 160, 120, 25);
        jtaState.setBounds(125, 160, 120, 25);
        //jlBack.setBounds(300, 700, 120, 25);
        jlAddDoctor.setBounds(20, 700, 120, 25);
        jlAddReceptionist.setBounds(160, 700, 120, 25);
        jlViewDoctor.setBounds(300, 700, 120, 25);
        jlViewReceptionist.setBounds(440, 700, 120, 25);
        jlChangePassword.setBounds(580, 700, 120, 25);
        
        ImageIcon ic = new ImageIcon("C:\\Users\\F\\Documents\\NetBeansProjects\\Health-care-Maven\\src\\main\\java\\com\\ubt\\healthcare\\view\\images\\schedule.png");
        jlAddDoctor.setIcon(ic);
        
        jlAddReceptionist.setIcon(ic);
        
        jlViewDoctor.setIcon(ic);
        
        jlViewReceptionist.setIcon(ic);
        
        jlChangePassword.setIcon(ic);
        
        this.add(jlauthId);
        this.add(jtaauthID);
        this.add(jlauthName);
        this.add(jtauthName);
        this.add(jtauthSurname);
        this.add(jlauthSurname);
        this.add(jlDOB);
        this.add(jtaDOB);
        this.add(jlCity);
        this.add(jtaCity);
        this.add(jlState);
        this.add(jtaState);
        this.add(jlAddDoctor);
        this.add(jlAddReceptionist);
        this.add(jlViewDoctor);
        this.add(jlViewReceptionist);
        this.add(jlChangePassword);
        
    }
    
    
}
