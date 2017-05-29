/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin;

import com.ubt.healthcare.business.DoctorService;
import com.ubt.healthcare.business.LoadTables;
import com.ubt.healthcare.business.PasswordHashing;
import com.ubt.healthcare.dto.City;
import com.ubt.healthcare.dto.Contact;
import com.ubt.healthcare.dto.Country;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Gender;
import com.ubt.healthcare.dto.MartialStatus;
import com.ubt.healthcare.dto.Person;
import com.ubt.healthcare.dto.Religion;
import com.ubt.healthcare.ui.admin.model.DoctorTableModelViewDoctor;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author F
 */
public class JIFDoctorF extends javax.swing.JInternalFrame {

    private List<Doctor> doctorList;
    private DoctorService doctorService;
    private DoctorTableModelViewDoctor doctorTableModelViewDoctor;
    private LoadTables loadTable;
    private PasswordHashing passwordHashing;

    /**
     * Creates new form JIFDoctorF
     */
    public JIFDoctorF() {
        initComponents();
        doctorService = new DoctorService();
        loadTable = new LoadTables();
        passwordHashing = new PasswordHashing();
        fillComboBoxCountry();
        fillComboBoxCity();
        fillComboBoxBirthCity();
        fillComboBoxSearchCity();
        fillComboBoxMartialStatus();
        fillComboBoxEducationType();
        fillComboBoxReligion();
        fillComboBoxGender();
        bindTheDoctorSearchTableModel();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField3 = new javax.swing.JTextField();
        jtpDoctor = new javax.swing.JTabbedPane();
        jspPersonalInformation = new javax.swing.JScrollPane();
        jpPersonalInformation = new javax.swing.JPanel();
        jlPersonalId = new javax.swing.JLabel();
        jtfPersonalId = new javax.swing.JTextField();
        jlFirstName = new javax.swing.JLabel();
        jtfFirstName = new javax.swing.JTextField();
        jtfMiddleName = new javax.swing.JTextField();
        jlMiddleName = new javax.swing.JLabel();
        jlLastName = new javax.swing.JLabel();
        jtfLastName = new javax.swing.JTextField();
        jlSex = new javax.swing.JLabel();
        jcbGender = new javax.swing.JComboBox<>();
        jlMartialStatus = new javax.swing.JLabel();
        jcbMartialStatus = new javax.swing.JComboBox<>();
        jlBirthPlace = new javax.swing.JLabel();
        jcbBirthPlace = new javax.swing.JComboBox<>();
        jcbReligion = new javax.swing.JComboBox<>();
        jlReligion = new javax.swing.JLabel();
        jlDateOfBirth = new javax.swing.JLabel();
        jdcDateOfBirth = new com.toedter.calendar.JDateChooser();
        jlPassword = new javax.swing.JLabel();
        jtfPassword = new javax.swing.JTextField();
        jlAddress = new javax.swing.JLabel();
        jtfAddress = new javax.swing.JTextField();
        jlCountry = new javax.swing.JLabel();
        jcbCountry = new javax.swing.JComboBox<>();
        jlCity = new javax.swing.JLabel();
        jcbCity = new javax.swing.JComboBox<>();
        jlBuildingNumber = new javax.swing.JLabel();
        jtfBulidingNumber = new javax.swing.JTextField();
        jlMobilePhone = new javax.swing.JLabel();
        jtfMobilePhone = new javax.swing.JTextField();
        jlWorkPhone = new javax.swing.JLabel();
        jtfWorkPhone = new javax.swing.JTextField();
        jlHomePhone = new javax.swing.JLabel();
        jtfHomePhone = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jbAddCity = new javax.swing.JButton();
        jspDoctorTable = new javax.swing.JScrollPane();
        jtDoctorListTable = new javax.swing.JTable();
        jtfFirstNameSearch = new javax.swing.JTextField();
        jtfLastNameSearch = new javax.swing.JTextField();
        jcbCitySearch = new javax.swing.JComboBox<>();
        jbSearchDoctor = new javax.swing.JButton();
        jbSave = new javax.swing.JButton();
        jbAddNew = new javax.swing.JButton();
        jlFirstNameSearch = new javax.swing.JLabel();
        jlLastNameSearch = new javax.swing.JLabel();
        jlCitySearch = new javax.swing.JLabel();
        jbCancel = new javax.swing.JButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        jTextField3.setText("jTextField3");

        jlPersonalId.setText("Personal ID");

        jlFirstName.setText("First Name");

        jtfFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFirstNameActionPerformed(evt);
            }
        });

        jlMiddleName.setText("Middle Name");

        jlLastName.setText("Last Name");

        jlSex.setText("Gender");

        jlMartialStatus.setText("Martial Status");

        jlBirthPlace.setText("Birth Place");

        jlReligion.setText("Religion");

        jlDateOfBirth.setText("Date Of Birth");

        jlPassword.setText("Password");

        jlAddress.setText("Address");

        jlCountry.setText("Country");

        jlCity.setText("City");

        jlBuildingNumber.setText("Building Number");

        jlMobilePhone.setText("Mobile Phone");

        jlWorkPhone.setText("Work Phone");

        jlHomePhone.setText("Home Phone");

        jlEmail.setText("Email");

        jbAddCity.setText("Add City");

        javax.swing.GroupLayout jpPersonalInformationLayout = new javax.swing.GroupLayout(jpPersonalInformation);
        jpPersonalInformation.setLayout(jpPersonalInformationLayout);
        jpPersonalInformationLayout.setHorizontalGroup(
            jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPersonalInformationLayout.createSequentialGroup()
                            .addComponent(jlDateOfBirth)
                            .addGap(56, 56, 56))
                        .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                            .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlFirstName)
                                .addComponent(jlPersonalId)
                                .addComponent(jlLastName)
                                .addComponent(jlMiddleName)
                                .addComponent(jlSex)
                                .addComponent(jlMartialStatus)
                                .addComponent(jlBirthPlace)
                                .addComponent(jlReligion))
                            .addGap(50, 50, 50)))
                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                        .addComponent(jlPassword)
                        .addGap(69, 69, 69)))
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbReligion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbMartialStatus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfPersonalId, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(136, 136, 136)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                                .addComponent(jlWorkPhone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfWorkPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                                .addComponent(jlMobilePhone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfMobilePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPersonalInformationLayout.createSequentialGroup()
                                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlBuildingNumber)
                                    .addComponent(jlCity))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcbCity, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfBulidingNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPersonalInformationLayout.createSequentialGroup()
                                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlAddress)
                                    .addComponent(jlCountry))
                                .addGap(77, 77, 77)
                                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                                .addComponent(jlHomePhone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfHomePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                                .addComponent(jlEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jbAddCity)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jpPersonalInformationLayout.setVerticalGroup(
            jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlPersonalId)
                            .addComponent(jtfPersonalId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlFirstName)
                            .addComponent(jtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlAddress))
                        .addGap(15, 15, 15)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlCountry))))
                .addGap(18, 18, 18)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlMiddleName)
                        .addComponent(jtfMiddleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbAddCity))
                    .addComponent(jlCity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlLastName)
                    .addComponent(jtfBulidingNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlBuildingNumber))
                .addGap(15, 15, 15)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSex)
                    .addComponent(jlMobilePhone)
                    .addComponent(jtfMobilePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbMartialStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlMartialStatus)
                    .addComponent(jlWorkPhone)
                    .addComponent(jtfWorkPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlBirthPlace)
                    .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlHomePhone)
                        .addComponent(jtfHomePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbReligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlReligion)
                    .addComponent(jlEmail)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDateOfBirth)
                    .addComponent(jdcDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlPassword)
                    .addComponent(jtfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jspPersonalInformation.setViewportView(jpPersonalInformation);

        jtpDoctor.addTab("Personal Information", jspPersonalInformation);

        jtDoctorListTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jspDoctorTable.setViewportView(jtDoctorListTable);

        jbSearchDoctor.setText("Search");

        jbSave.setText("Save");

        jbAddNew.setText("Add New");
        jbAddNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddNewActionPerformed(evt);
            }
        });

        jlFirstNameSearch.setText("First Name");

        jlLastNameSearch.setText("Last Name");

        jlCitySearch.setText("City");

        jbCancel.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfFirstNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlFirstNameSearch))
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlLastNameSearch)
                            .addComponent(jtfLastNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlCitySearch)
                                .addGap(275, 275, 275))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcbCitySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbSearchDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68))))
                    .addComponent(jtpDoctor)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jspDoctorTable)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jbSave, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160)
                .addComponent(jbAddNew, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAddNew)
                    .addComponent(jbSave)
                    .addComponent(jbCancel))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFirstNameSearch)
                    .addComponent(jlLastNameSearch)
                    .addComponent(jlCitySearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfFirstNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLastNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCitySearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSearchDoctor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspDoctorTable, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtpDoctor)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAddNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbAddNewActionPerformed

    private void jtfFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfFirstNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton jbAddCity;
    private javax.swing.JButton jbAddNew;
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbSave;
    private javax.swing.JButton jbSearchDoctor;
    private javax.swing.JComboBox<String> jcbBirthPlace;
    private javax.swing.JComboBox<String> jcbCity;
    private javax.swing.JComboBox<String> jcbCitySearch;
    private javax.swing.JComboBox<String> jcbCountry;
    private javax.swing.JComboBox<String> jcbGender;
    private javax.swing.JComboBox<String> jcbMartialStatus;
    private javax.swing.JComboBox<String> jcbReligion;
    private com.toedter.calendar.JDateChooser jdcDateOfBirth;
    private javax.swing.JLabel jlAddress;
    private javax.swing.JLabel jlBirthPlace;
    private javax.swing.JLabel jlBuildingNumber;
    private javax.swing.JLabel jlCity;
    private javax.swing.JLabel jlCitySearch;
    private javax.swing.JLabel jlCountry;
    private javax.swing.JLabel jlDateOfBirth;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlFirstName;
    private javax.swing.JLabel jlFirstNameSearch;
    private javax.swing.JLabel jlHomePhone;
    private javax.swing.JLabel jlLastName;
    private javax.swing.JLabel jlLastNameSearch;
    private javax.swing.JLabel jlMartialStatus;
    private javax.swing.JLabel jlMiddleName;
    private javax.swing.JLabel jlMobilePhone;
    private javax.swing.JLabel jlPassword;
    private javax.swing.JLabel jlPersonalId;
    private javax.swing.JLabel jlReligion;
    private javax.swing.JLabel jlSex;
    private javax.swing.JLabel jlWorkPhone;
    private javax.swing.JPanel jpPersonalInformation;
    private javax.swing.JScrollPane jspDoctorTable;
    private javax.swing.JScrollPane jspPersonalInformation;
    private javax.swing.JTable jtDoctorListTable;
    private javax.swing.JTextField jtfAddress;
    private javax.swing.JTextField jtfBulidingNumber;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfFirstNameSearch;
    private javax.swing.JTextField jtfHomePhone;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfLastNameSearch;
    private javax.swing.JTextField jtfMiddleName;
    private javax.swing.JTextField jtfMobilePhone;
    private javax.swing.JTextField jtfPassword;
    private javax.swing.JTextField jtfPersonalId;
    private javax.swing.JTextField jtfWorkPhone;
    private javax.swing.JTabbedPane jtpDoctor;
    // End of variables declaration//GEN-END:variables

// Mouse Event listener for Search button
    public void addSearchDoctorPanelMouseAdapter(MouseAdapter e) {
        jbSearchDoctor.addMouseListener(e);
    }

// load Doctor Table 
    public void loadDoctorListTable(String name, String surname, String city) {
        doctorList = doctorService.findDoctorsByParameters(name, surname, city);
        doctorTableModelViewDoctor = new DoctorTableModelViewDoctor(doctorList);
        jtDoctorListTable.setModel(doctorTableModelViewDoctor);
        doctorTableModelViewDoctor.fireTableDataChanged();
    }

    // method which searches for Doctor 
    public void searchDoctorInternalPane() {
        String nameOfDctor = jtfFirstNameSearch.getText();
        String surnameOfDctor = jtfLastNameSearch.getText();
        String cityOfDoctor = jcbCitySearch.getSelectedIndex() < 0 ? "" : jcbCitySearch.getSelectedItem().toString();

        if (nameOfDctor.trim().length() == 0 && surnameOfDctor.trim().length() == 0 && cityOfDoctor.trim().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Please fill the fields to find the Doctor you are looking for");
        } else {

            loadDoctorListTable(nameOfDctor, surnameOfDctor, cityOfDoctor);

        }
    }

    public void fillComboBoxCountry() {
        List<Object> obj = loadTable.fillComboBoxCountry();
        for (Object o : obj) {
            jcbCountry.addItem(((Country) o).getCountryName());
        }
    }

    public void fillComboBoxGender() {
        List<Object> obj = loadTable.fillComboBoxGender();
        for (Object o : obj) {
            jcbGender.addItem(((Gender) o).getGenderName());
        }
    }

    public void fillComboBoxCity() {
        List<Object> obj = loadTable.fillComboBoxBirthCity();
        for (Object o : obj) {
            jcbCity.addItem(((City) o).getCityName());
        }
    }

    public void fillComboBoxSearchCity() {
        List<Object> obj = loadTable.fillComboBoxBirthCity();
        for (Object o : obj) {
            jcbCitySearch.addItem(((City) o).getCityName());
        }
    }

    public void fillComboBoxBirthCity() {
        List<Object> obj = loadTable.fillComboBoxBirthCity();
        for (Object o : obj) {
            jcbBirthPlace.addItem(((City) o).getCityName());
        }
    }

    public void fillComboBoxCity(String country) {
        List<Object> obj = loadTable.fillComboBoxBirthCity();
        jcbCity.removeAllItems();
        for (Object o : obj) {
            if (((City) o).getCountryId().getCountryName().equals(country)) {
                jcbCity.addItem(((City) o).getCityName());
            }
        }
    }

    public void fillComboBoxMartialStatus() {
        List<Object> obj = loadTable.fillComboBoxMartialStatus();
        obj.forEach((o) -> {
            jcbMartialStatus.addItem(((MartialStatus) o).getMartialStatusName());
        });
    }

    public void fillComboBoxEducationType() {
        List<Object> obj = loadTable.fillComboBoxEducationType();
        for (Object o : obj) {
            //jcbEducationType.addItem(((EducationType) o).getEducationName());
        }
    }

    public void fillComboBoxReligion() {
        List<Object> obj = loadTable.fillComboBoxReligion();
        for (Object o : obj) {
            jcbReligion.addItem(((Religion) o).getName());
        }
    }

    // gets the index of cetain Gender
    public int getSelectedGenderIndex(String genderType) {
        List<Gender> fillComboBoxEducationType = (List<Gender>) (Object) loadTable.fillComboBoxGender();
        int i = 0;
        for (Gender object : fillComboBoxEducationType) {
            if (object.getGenderName().equals(genderType)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // gets the index of cetain Martial Status
    public int getSelectedMartialStatusIndex(String martialStatus) {
        List<MartialStatus> fillComboBoxEducationType = (List<MartialStatus>) (Object) loadTable.fillComboBoxMartialStatus();
        int i = 0;
        for (MartialStatus object : fillComboBoxEducationType) {
            if (object.getMartialStatusName().equals(martialStatus)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // gets the index of cetain City
    public int getSelectedCityIndex(String city) {
        List<City> fillComboBoxEducationType = (List<City>) (Object) loadTable.fillComboBoxBirthCity();
        int i = 0;
        for (City object : fillComboBoxEducationType) {
            if (object.getCityName().equals(city)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // gets the index of cetain Country
    public int getSelectedCountryIndex(String country) {
        List<Country> fillComboBoxEducationType = (List<Country>) (Object) loadTable.fillComboBoxCountry();
        int i = 0;
        for (Country object : fillComboBoxEducationType) {
            if (object.getCountryName().equals(country)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    // gets the index of cetain City
    public int getSelectedReligionIndex(String city) {
        List<Religion> fillComboBoxEducationType = (List<Religion>) (Object) loadTable.fillComboBoxReligion();
        int i = 0;
        for (Religion object : fillComboBoxEducationType) {
            if (object.getName().equals(city)) {
                return i;
            }
            i++;
        }
        return -1;
    }
// doctor view listener

    public void doctorTableRowSelectionListener() {
        final ListSelectionModel selectedModel = jtDoctorListTable.getSelectionModel();
        selectedModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                int selectedRow = selectedModel.getAnchorSelectionIndex();
                if (selectedRow > -1) {
                    // get the selected education from jtable which is saved on arrayList
                    //and update the jtfields which they can edit
                    Person pe = doctorTableModelViewDoctor.getDoctor(selectedRow).getPersonId();
                    updatePersonFields(pe);

                }
            }
        });
    }

    //reflect the updates to table
    private void fillTheDoctorSearchTable() {
        doctorTableModelViewDoctor.fireTableDataChanged();

    }

    //create table with empty rows and add the listener in constructor
    private void bindTheDoctorSearchTableModel() {
        doctorTableModelViewDoctor = new DoctorTableModelViewDoctor(new ArrayList<>());
        doctorTableModelViewDoctor.add(new ArrayList<>());
        jtDoctorListTable.setModel(doctorTableModelViewDoctor);
        fillTheDoctorSearchTable();
        doctorTableRowSelectionListener();
    }

    private void updatePersonFields(Person person) {
        jtfPersonalId.setText(String.valueOf(person.getPersonId()));
        jtfFirstName.setText(person.getFirstName());
        jtfMiddleName.setText(person.getMiddleName());
        jtfLastName.setText(person.getLastName());
        jcbGender.setSelectedIndex(getSelectedGenderIndex(person.getGenderId().getGenderName()));
        jcbMartialStatus.setSelectedIndex(getSelectedMartialStatusIndex(person.getMartialStatusId().getMartialStatusName()));
        jcbBirthPlace.setSelectedIndex(getSelectedCityIndex(person.getBirthCityId().getCityName()));
        jcbReligion.setSelectedIndex(getSelectedReligionIndex(person.getReigionId().getName()));
        jdcDateOfBirth.setDate(person.getDateOfBirth());
        jtfPassword.setText("");
        jtfAddress.setText(person.getAddressId().getStreetName());
        jcbCity.setSelectedIndex(getSelectedCityIndex(person.getAddressId().getCityId().getCityName()));
        jcbCountry.setSelectedIndex(getSelectedCountryIndex(person.getAddressId().getCityId().getCountryId().getCountryName()));
        jtfBulidingNumber.setText(String.valueOf(person.getAddressId().getBuildingNumber()));
        Collection<Contact> contactCollection = person.getContactCollection();
        if (contactCollection != null && contactCollection.size() > 0) {
// person might have just one contact details, soo clear the reamaining details of past selected persson
            jtfHomePhone.setText("");
            jtfWorkPhone.setText("");
            jtfMobilePhone.setText("");
            jtfEmail.setText("");
            for (Contact contact : contactCollection) {
                switch (contact.getType().trim()) {
                    case "HOME":
                        jtfHomePhone.setText(contact.getValue());
                        break;
                    case "WORK":
                        jtfWorkPhone.setText(contact.getValue());
                        break;
                    case "MOB":
                        jtfMobilePhone.setText(contact.getValue());
                        break;
                    case "EMAIL":
                        jtfEmail.setText(contact.getValue());
                        break;
                    default:
                        break;
                }

            }
        } else {
            jtfHomePhone.setText("");
            jtfWorkPhone.setText("");
            jtfMobilePhone.setText("");
            jtfEmail.setText("");

        }
    }

}
