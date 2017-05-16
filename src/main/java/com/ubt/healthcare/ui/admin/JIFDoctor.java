/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin;

import com.ubt.healthcare.business.DoctorService;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.PersonEducation;
import com.ubt.healthcare.ui.JIFViewDoctor;
import com.ubt.healthcare.ui.admin.model.DoctorTableModelEducation;
import java.awt.event.MouseAdapter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author F
 */
public class JIFDoctor extends javax.swing.JInternalFrame {

    private DoctorTableModelEducation doctorTableModelEducation;
    private DoctorService doctorService;
    private Doctor doctor;
    private JIFViewDoctor jifViewDoctor;

    /**
     * Creates new form JIFDoctor
     * @param jifViewDoctor
     */
    public JIFDoctor(JIFViewDoctor jifViewDoctor ) {

        initComponents();
        doctorTableModelEducation = new DoctorTableModelEducation();
        doctorService = new DoctorService();
        this.jifViewDoctor = jifViewDoctor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtpDoctorDetails = new javax.swing.JTabbedPane();
        jspPersonalInformation = new javax.swing.JScrollPane();
        jpPersonalInformation = new javax.swing.JPanel();
        jlFirstName = new javax.swing.JLabel();
        jtfFirstName = new javax.swing.JTextField();
        jlMiddleName = new javax.swing.JLabel();
        jtfMiddleName = new javax.swing.JTextField();
        jlLastName = new javax.swing.JLabel();
        jtfLastName = new javax.swing.JTextField();
        jlPersonalId = new javax.swing.JLabel();
        jtfPersonalId = new javax.swing.JTextField();
        jlBirthPlace = new javax.swing.JLabel();
        jtfBirthCity = new javax.swing.JTextField();
        jlSex = new javax.swing.JLabel();
        jtfGender = new javax.swing.JTextField();
        jlMaritalStatus = new javax.swing.JLabel();
        jtfMaritalStatus = new javax.swing.JTextField();
        jlAddress1 = new javax.swing.JLabel();
        jtfAddress1 = new javax.swing.JTextField();
        jlCity = new javax.swing.JLabel();
        jtfCity = new javax.swing.JTextField();
        jlCountry = new javax.swing.JLabel();
        jtfCountry = new javax.swing.JTextField();
        jlHomePhone = new javax.swing.JLabel();
        jtfHomePhone = new javax.swing.JTextField();
        jlWorkPhone = new javax.swing.JLabel();
        jtfWorkPhone = new javax.swing.JTextField();
        jlMobilePhone = new javax.swing.JLabel();
        jtfMobilePhone = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jspEducationDetails = new javax.swing.JScrollPane();
        jtEducationDetails = new javax.swing.JTable();
        jbUpdate = new javax.swing.JButton();
        jbSearchDoctor = new javax.swing.JButton();
        jbAddNewDoctor = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Doctor Screen");
        setToolTipText("");
        setName(""); // NOI18N
        setVisible(true);

        jlFirstName.setForeground(new java.awt.Color(0, 153, 204));
        jlFirstName.setText("First name :");

        jtfFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFirstNameActionPerformed(evt);
            }
        });

        jlMiddleName.setForeground(new java.awt.Color(0, 153, 204));
        jlMiddleName.setText("Middle name :");

        jlLastName.setForeground(new java.awt.Color(0, 153, 204));
        jlLastName.setText("Last Name :");

        jlPersonalId.setForeground(new java.awt.Color(0, 153, 204));
        jlPersonalId.setText("Personal ID :");

        jtfPersonalId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPersonalIdActionPerformed(evt);
            }
        });

        jlBirthPlace.setForeground(new java.awt.Color(0, 153, 204));
        jlBirthPlace.setText("Birth City :");

        jlSex.setForeground(new java.awt.Color(0, 153, 204));
        jlSex.setText("Sex :");

        jlMaritalStatus.setForeground(new java.awt.Color(0, 153, 204));
        jlMaritalStatus.setText("Marital Status :");

        jlAddress1.setForeground(new java.awt.Color(0, 153, 204));
        jlAddress1.setText("Address 1 :");

        jlCity.setForeground(new java.awt.Color(0, 153, 204));
        jlCity.setText("City :");

        jlCountry.setForeground(new java.awt.Color(0, 153, 204));
        jlCountry.setText("   Country :");

        jlHomePhone.setForeground(new java.awt.Color(0, 153, 204));
        jlHomePhone.setText("Home Phone :");

        jlWorkPhone.setForeground(new java.awt.Color(0, 153, 204));
        jlWorkPhone.setText(" Work Phone :");

        jlMobilePhone.setForeground(new java.awt.Color(0, 153, 204));
        jlMobilePhone.setText("Mobile Phone :");

        jlEmail.setForeground(new java.awt.Color(0, 153, 204));
        jlEmail.setText(" E-mail :");

        javax.swing.GroupLayout jpPersonalInformationLayout = new javax.swing.GroupLayout(jpPersonalInformation);
        jpPersonalInformation.setLayout(jpPersonalInformationLayout);
        jpPersonalInformationLayout.setHorizontalGroup(
            jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlSex)
                            .addComponent(jlBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlMaritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jlMiddleName)
                        .addComponent(jlFirstName)
                        .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                            .addComponent(jlLastName)
                            .addGap(2, 2, 2))
                        .addComponent(jlPersonalId, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfFirstName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jtfMiddleName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jtfLastName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                    .addComponent(jtfPersonalId)
                    .addComponent(jtfBirthCity)
                    .addComponent(jtfGender)
                    .addComponent(jtfMaritalStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPersonalInformationLayout.createSequentialGroup()
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPersonalInformationLayout.createSequentialGroup()
                                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlHomePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlWorkPhone))
                                .addGap(18, 18, 18)
                                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfWorkPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfHomePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfCity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPersonalInformationLayout.createSequentialGroup()
                                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlMobilePhone)
                                    .addComponent(jlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfEmail)
                                    .addComponent(jtfMobilePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(167, 167, 167))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPersonalInformationLayout.createSequentialGroup()
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlAddress1)
                            .addComponent(jlCountry)
                            .addComponent(jlCity, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(349, 349, 349))))
        );
        jpPersonalInformationLayout.setVerticalGroup(
            jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPersonalId, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPersonalId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlAddress1))
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlCity, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCountry))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlBirthPlace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfBirthCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlSex, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfMaritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlMaritalStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(91, 91, 91))
                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlHomePhone)
                            .addComponent(jtfHomePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlWorkPhone)
                            .addComponent(jtfWorkPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfMobilePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlMobilePhone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jspPersonalInformation.setViewportView(jpPersonalInformation);

        jtpDoctorDetails.addTab("Personal Information", jspPersonalInformation);

        jtEducationDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jspEducationDetails.setViewportView(jtEducationDetails);

        jtpDoctorDetails.addTab("Education Details", jspEducationDetails);

        jbUpdate.setText("Update");
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });

        jbSearchDoctor.setText("Search");

        jbAddNewDoctor.setText("Add New");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jbSearchDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(94, 94, 94)
                        .addComponent(jbUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(94, 94, 94)
                        .addComponent(jbAddNewDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jtpDoctorDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 1020, Short.MAX_VALUE)))
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAddNewDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbSearchDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(175, 175, 175)
                .addComponent(jtpDoctorDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbUpdateActionPerformed

    private void jtfFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfFirstNameActionPerformed

    private void jtfPersonalIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPersonalIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPersonalIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAddNewDoctor;
    private javax.swing.JButton jbSearchDoctor;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JLabel jlAddress1;
    private javax.swing.JLabel jlBirthPlace;
    private javax.swing.JLabel jlCity;
    private javax.swing.JLabel jlCountry;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlFirstName;
    private javax.swing.JLabel jlHomePhone;
    private javax.swing.JLabel jlLastName;
    private javax.swing.JLabel jlMaritalStatus;
    private javax.swing.JLabel jlMiddleName;
    private javax.swing.JLabel jlMobilePhone;
    private javax.swing.JLabel jlPersonalId;
    private javax.swing.JLabel jlSex;
    private javax.swing.JLabel jlWorkPhone;
    private javax.swing.JPanel jpPersonalInformation;
    private javax.swing.JScrollPane jspEducationDetails;
    private javax.swing.JScrollPane jspPersonalInformation;
    private javax.swing.JTable jtEducationDetails;
    private javax.swing.JTextField jtfAddress1;
    private javax.swing.JTextField jtfBirthCity;
    private javax.swing.JTextField jtfCity;
    private javax.swing.JTextField jtfCountry;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfGender;
    private javax.swing.JTextField jtfHomePhone;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfMaritalStatus;
    private javax.swing.JTextField jtfMiddleName;
    private javax.swing.JTextField jtfMobilePhone;
    private javax.swing.JTextField jtfPersonalId;
    private javax.swing.JTextField jtfWorkPhone;
    private javax.swing.JTabbedPane jtpDoctorDetails;
    // End of variables declaration//GEN-END:variables
 
    public void loadEducationTable() {
        List<PersonEducation> doctorEducation = doctorService.findEducation(doctor);
        doctorTableModelEducation.add(doctorEducation);
        jtEducationDetails.setModel(doctorTableModelEducation);
        doctorTableModelEducation.fireTableDataChanged();
        // selectedIndexChange Method...
    }
    
     public void addSearchDoctorInternalFrameMouseAdapter(MouseAdapter e) {
        jbSearchDoctor.addMouseListener(e);
    }

    public DoctorService getDoctorService() {
        return doctorService;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public JTextField getJtfAddress1() {
        return jtfAddress1;
    }

    public JTextField getJtfCity1() {
        return jtfCity;
    }

    public JTextField getJtfCountry() {
        return jtfCountry;
    }

    public JTextField getJtfEmail() {
        return jtfEmail;
    }

    public JTextField getJtfFirstName() {
        return jtfFirstName;
    }

    public JTextField getJtfGender() {
        return jtfGender;
    }

    public JTextField getJtfHomePhone() {
        return jtfHomePhone;
    }

    public JTextField getJtfLastName() {
        return jtfLastName;
    }

    public JTextField getJtfMaritalStatus() {
        return jtfMaritalStatus;
    }

    public JTextField getJtfMiddleName() {
        return jtfMiddleName;
    }

    public JTextField getJtfMobilePhone() {
        return jtfMobilePhone;
    }

    public JTextField getJtfPersonalId() {
        return jtfPersonalId;
    }

    public JTextField getJtfPlace() {
        return jtfBirthCity;
    }

    public JTextField getJtfWorkPhone() {
        return jtfWorkPhone;
    }

    public void viewSelectedDoctor() 
    {

        int row = jifViewDoctor.getJtDoctorTable().getSelectedRow();// do not allow multiple row selection
        if (row > -1) 
        {
            
            // get selected doctor
            doctor = jifViewDoctor.getDoctorTableModelViewDoctor().getDoctor(row);
            
            //update the JIFDoctor fields with doctors object
            updateDoctorFields(doctor);
            loadEducationTable();
            
            //clear the fields of JIFViewDoctor
            jifViewDoctor.getJtfSearchByName().setText("");
            jifViewDoctor.getJtfSearchBySurName().setText("");
            
            // check if no item found...
            jifViewDoctor.getDoctorTableModelViewDoctor().removeAll();

        }
        else// if no row selected display message that no row is selected 
        {
            JOptionPane.showMessageDialog(rootPane, "No Doctor Selected");
            //clear the fields of JIFViewDoctor
            jifViewDoctor.getJtfSearchByName().setText("");
            jifViewDoctor.getJtfSearchBySurName().setText("");
            
            // check if no item found...
            jifViewDoctor.getDoctorTableModelViewDoctor().removeAll();
            
        }
        
        // close the JIFViewDoctor
        jifViewDoctor.dispose();
        this.show();

    }
 

    public JIFViewDoctor getJifViewDoctor() {
        return jifViewDoctor;
    }
     
    private void  updateDoctorFields(Doctor doctor)
    {
        jtfPersonalId.setText(doctor.getPersonId().getPersonId().toString());
        jtfFirstName.setText(doctor.getPersonId().getFirstName());
        jtfLastName.setText(doctor.getPersonId().getLastName());
        jtfMiddleName.setText(doctor.getPersonId().getMiddleName());
        jtfBirthCity.setText(doctor.getPersonId().getBirthCityId().getCityName());
        jtfGender.setText(doctor.getPersonId().getGenderId().getGenderName());
        jtfMaritalStatus.setText(doctor.getPersonId().getMartialStatusId().getMartialStatusName());
    }
    
}
