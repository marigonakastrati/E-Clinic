/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.hrManager;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author F
 */
public class JFHRManager extends javax.swing.JFrame {

    private JIFAddShift jifAddShift;
    private JIFReports jifReports;

    /**
     * Creates new form JFHRManager
     *
     * @param jifAddShift
     * @param jifReports
     */
    public JFHRManager(JIFAddShift jifAddShift, JIFReports jifReports) {
        this.jifAddShift = jifAddShift;
        this.jifReports = jifReports;

        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public JFHRManager() {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jdpPaneHandler = new javax.swing.JDesktopPane();
        jlProfile = new javax.swing.JLabel();
        jlShiftManagement = new javax.swing.JLabel();
        jlLogout = new javax.swing.JLabel();
        jlReports = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HR Manager");

        javax.swing.GroupLayout jdpPaneHandlerLayout = new javax.swing.GroupLayout(jdpPaneHandler);
        jdpPaneHandler.setLayout(jdpPaneHandlerLayout);
        jdpPaneHandlerLayout.setHorizontalGroup(
            jdpPaneHandlerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jdpPaneHandlerLayout.setVerticalGroup(
            jdpPaneHandlerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        jlProfile.setText("Profile");

        jlShiftManagement.setText("Shift Management");

        jlLogout.setText("Log Out");

        jlReports.setText("Reports");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jdpPaneHandler, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlProfile)
                .addGap(66, 66, 66)
                .addComponent(jlShiftManagement)
                .addGap(60, 60, 60)
                .addComponent(jlReports)
                .addGap(70, 70, 70)
                .addComponent(jlLogout)
                .addContainerGap(389, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlProfile)
                    .addComponent(jlShiftManagement)
                    .addComponent(jlLogout)
                    .addComponent(jlReports))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdpPaneHandler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jdpPaneHandler;
    private javax.swing.JLabel jlLogout;
    private javax.swing.JLabel jlProfile;
    private javax.swing.JLabel jlReports;
    private javax.swing.JLabel jlShiftManagement;
    // End of variables declaration//GEN-END:variables

    public void showAddShiftScreen() {

        jdpPaneHandler.remove(jifAddShift);
        jdpPaneHandler.add(jifAddShift);
        jifAddShift.show();
    }

    public void showReportsScreen() {

        jdpPaneHandler.remove(jifReports);
        jdpPaneHandler.add(jifReports);
        jifReports.show();
    }

    static {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());

                    /*jdpPaneHandler.setUI(new DesktopPaneUI() {
                        @Override
                        public void installUI(JComponent ui) {
                            try {
                                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel.");

                            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
                            }
                        }
                    });*/
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("UI Manager not found");
        }
    }
}