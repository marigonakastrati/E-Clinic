/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author F
 */
public class JPLoginScreen extends JPanel {

    private JPasswordField jpfpassCode = new JPasswordField(10);
    private JTextField jtfpersonId = new JTextField(10);
    private JLabel jlpassCode = new JLabel("");
    private JLabel jlpersonId = new JLabel("");
    private JLabel jllogin = new JLabel("");
    private JLabel jlcloseWindows = new JLabel(""); 
    private JLabel jlBackground = new JLabel("");
    private JLabel jlpassCodePad = new JLabel("");
    private JLabel jlpersonIdPad = new JLabel("");

    public JPLoginScreen() {
        this.setLayout(null);

        jpfpassCode.setBorder(null);
        jpfpassCode.setHorizontalAlignment(0);
        jpfpassCode.setForeground(Color.GRAY);
        jpfpassCode.setFont(new Font("Tahoma", 1, 16));
        jpfpassCode.setBounds(305, 178, 136, 20);

        jtfpersonId.setBorder(null);
        jtfpersonId.setHorizontalAlignment(0);
        jtfpersonId.setForeground(Color.GRAY);
        jtfpersonId.setFont(new Font("Tahoma", 1, 16));
        jtfpersonId.setBounds(305, 139, 136, 20);

        jlpassCodePad.setBorder(null);
        jlpassCodePad.setHorizontalAlignment(0);
        jlpassCodePad.setForeground(Color.GRAY);
        jlpassCodePad.setFont(new Font("Tahoma", 1, 16));
        jlpassCodePad.setBounds(280, 178, 20, 20);
        jlpassCodePad.setIcon(new ImageIcon(getClass().getResource("/com/ubt/healthcare/ui/images/passwordPad.png")));

        jlpersonIdPad.setBorder(null);
        jlpersonIdPad.setHorizontalAlignment(0);
        jlpersonIdPad.setForeground(Color.GRAY);
        jlpersonIdPad.setFont(new Font("Tahoma", 1, 16));
        jlpersonIdPad.setBounds(280, 139, 20, 20);
        jlpersonIdPad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ubt/healthcare/ui/images/userNamePad.png")));

        jlpassCode.setIcon(new ImageIcon(getClass().getResource("/com/ubt/healthcare/ui/images/textField.png")));
        jlpassCode.setBounds(300, 133, 145, 30);// 78,133

        jlpersonId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ubt/healthcare/ui/images/textField.png")));
        jlpersonId.setBounds(300, 173, 145, 30);//78,173

        jllogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ubt/healthcare/ui/images/sign.png")));
        jllogin.setBounds(300, 219, 140, 38);

        jlcloseWindows.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ubt/healthcare/ui/images/close.png")));
        jlcloseWindows.setBounds(760, 1, 25, 25);

        jlBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/ubt/healthcare/ui/images/login-background.png")));
        jlBackground.setBounds(0, 0, 800, 800);

        this.add(jlpersonId);
        this.add(jtfpersonId);
        this.add(jlpassCode);
        this.add(jpfpassCode);
        this.add(jllogin);
        this.add(jlcloseWindows);
        this.add(jlpersonIdPad);
        this.add(jlpassCodePad);
        this.add(jlBackground);
    }

    public JPasswordField getJtfpassCode() {
        return jpfpassCode;
    }

    public JTextField getJtfUserId() {
        return jtfpersonId;
    }

    public JLabel getJlpassCode() {
        return jlpassCode;
    }

    public JLabel getJlUserId() {
        return jlpersonId;
    }

    public JLabel getJllogin() {
        return jllogin;
    }

    public JLabel getJlcloseWindows() {
        return jlcloseWindows;
    }

    public void addCloseMainWindowsMouseAdapter(MouseAdapter e) {
        jlcloseWindows.addMouseListener(e);
    }

    public void addLoginMouseAdapter(MouseAdapter e) {
        jllogin.addMouseListener(e);
    }

    public void addLoginEnterKeyListener(KeyListener e) {
        jpfpassCode.addKeyListener(e);
    }
}
