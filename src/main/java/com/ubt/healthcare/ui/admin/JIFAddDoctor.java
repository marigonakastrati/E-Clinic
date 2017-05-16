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
public class JIFAddDoctor extends javax.swing.JInternalFrame {

    private DoctorTableModelEducation doctorTableModelEducation;
    private DoctorService doctorService;
    private Doctor doctor;
    private JIFViewDoctor jifViewDoctor;

    /**
     * Creates new form JIFDoctor
     * @param jifViewDoctor
     */
    public JIFAddDoctor(JIFViewDoctor jifViewDoctor ) {

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
        jtfAddress1 = new javax.swing.JTextField();
        jlCity = new javax.swing.JLabel();
        jlCountry = new javax.swing.JLabel();
        jlHomePhone = new javax.swing.JLabel();
        jtfHomePhone = new javax.swing.JTextField();
        jlWorkPhone = new javax.swing.JLabel();
        jtfWorkPhone = new javax.swing.JTextField();
        jlMobilePhone = new javax.swing.JLabel();
        jtfMobilePhone = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jlPassword = new javax.swing.JLabel();
        jpwPassword = new javax.swing.JPasswordField();
        jlDateOfBirth = new javax.swing.JLabel();
        jdchDateOfBirth = new com.toedter.calendar.JDateChooser();
        jlBirthPlace1 = new javax.swing.JLabel();
        jcbBirthPlace = new javax.swing.JComboBox<>();
        jlContactInformation = new javax.swing.JLabel();
        jlAddressInformation = new javax.swing.JLabel();
        jlPersonalInformation = new javax.swing.JLabel();
        jcbCountry = new javax.swing.JComboBox<>();
        jcbCity = new javax.swing.JComboBox<>();
        jlAddress2 = new javax.swing.JLabel();
        jlBuildingNumber = new javax.swing.JLabel();
        jtfBuildingNumber = new javax.swing.JTextField();
        jspEducationDetails = new javax.swing.JScrollPane();
        jtEducationDetails = new javax.swing.JTable();
        jbUpdate = new javax.swing.JButton();
        jbSearchDoctor = new javax.swing.JButton();
        jbAddNewDoctor = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Add Doctor Screen");
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

        jlPassword.setForeground(new java.awt.Color(0, 153, 204));
        jlPassword.setText("Password :");

        jlDateOfBirth.setForeground(new java.awt.Color(0, 153, 204));
        jlDateOfBirth.setText("    Date of Birth :");

        jlBirthPlace1.setForeground(new java.awt.Color(0, 153, 204));
        jlBirthPlace1.setText("  Birth Place ");

        jlContactInformation.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jlContactInformation.setForeground(new java.awt.Color(102, 102, 255));
        jlContactInformation.setText("Contact Information");

        jlAddressInformation.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jlAddressInformation.setForeground(new java.awt.Color(102, 102, 255));
        jlAddressInformation.setText("      Address Information ");

        jlPersonalInformation.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jlPersonalInformation.setForeground(new java.awt.Color(102, 102, 255));
        jlPersonalInformation.setText("Personal Information ");

        jlAddress2.setForeground(new java.awt.Color(0, 153, 204));
        jlAddress2.setText("Address  :");

        jlBuildingNumber.setForeground(new java.awt.Color(0, 153, 204));
        jlBuildingNumber.setText("Building Number :");

        javax.swing.GroupLayout jpPersonalInformationLayout = new javax.swing.GroupLayout(jpPersonalInformation);
        jpPersonalInformation.setLayout(jpPersonalInformationLayout);
        jpPersonalInformationLayout.setHorizontalGroup(
            jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlSex)
                                            .addComponent(jlBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlMaritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jlPassword))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jlMiddleName)
                                        .addComponent(jlFirstName)
                                        .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                                            .addComponent(jlLastName)
                                            .addGap(2, 2, 2))
                                        .addComponent(jlPersonalId, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(2, 2, 2)
                                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jpwPassword)
                                    .addComponent(jtfFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(jtfMiddleName, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(jtfLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(jtfPersonalId, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfBirthCity, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfGender, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfMaritalStatus, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 351, Short.MAX_VALUE))
                            .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlDateOfBirth, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlBirthPlace1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jcbBirthPlace, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jdchDateOfBirth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlPersonalInformation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlAddressInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPersonalInformationLayout.createSequentialGroup()
                                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jlCity, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlAddress2)
                                    .addComponent(jlCountry)
                                    .addComponent(jlBuildingNumber))
                                .addGap(27, 27, 27)
                                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jcbCity, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfBuildingNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jtfAddress1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(197, 197, 197))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPersonalInformationLayout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jlContactInformation)
                            .addGap(317, 317, 317))
                        .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                            .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                                    .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jlMobilePhone)
                                            .addComponent(jlWorkPhone))
                                        .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                                            .addComponent(jlHomePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(3, 3, 3)))
                                    .addGap(30, 30, 30)
                                    .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jtfWorkPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfMobilePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfHomePhone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(183, 183, 183)))))
        );
        jpPersonalInformationLayout.setVerticalGroup(
            jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlAddressInformation)
                    .addComponent(jlPersonalInformation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPersonalId, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPersonalId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlAddress2))
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
                            .addComponent(jlCity, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCountry)
                    .addComponent(jcbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlBirthPlace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfBirthCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfBuildingNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlBuildingNumber)))
                .addGap(18, 18, 18)
                .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlSex, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfMaritalStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlMaritalStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jpwPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlPassword))
                        .addGap(29, 29, 29)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlDateOfBirth)
                            .addComponent(jdchDateOfBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlBirthPlace1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80))
                    .addGroup(jpPersonalInformationLayout.createSequentialGroup()
                        .addComponent(jlContactInformation)
                        .addGap(18, 18, 18)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlMobilePhone)
                            .addComponent(jtfMobilePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlWorkPhone)
                            .addComponent(jtfWorkPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlHomePhone)
                            .addComponent(jtfHomePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpPersonalInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(jtpDoctorDetails, javax.swing.GroupLayout.DEFAULT_SIZE, 1022, Short.MAX_VALUE)))
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
                .addComponent(jtpDoctorDetails)
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
    private javax.swing.JComboBox<String> jcbBirthPlace;
    private javax.swing.JComboBox<String> jcbCity;
    private javax.swing.JComboBox<String> jcbCountry;
    private com.toedter.calendar.JDateChooser jdchDateOfBirth;
    private javax.swing.JLabel jlAddress2;
    private javax.swing.JLabel jlAddressInformation;
    private javax.swing.JLabel jlBirthPlace;
    private javax.swing.JLabel jlBirthPlace1;
    private javax.swing.JLabel jlBuildingNumber;
    private javax.swing.JLabel jlCity;
    private javax.swing.JLabel jlContactInformation;
    private javax.swing.JLabel jlCountry;
    private javax.swing.JLabel jlDateOfBirth;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlFirstName;
    private javax.swing.JLabel jlHomePhone;
    private javax.swing.JLabel jlLastName;
    private javax.swing.JLabel jlMaritalStatus;
    private javax.swing.JLabel jlMiddleName;
    private javax.swing.JLabel jlMobilePhone;
    private javax.swing.JLabel jlPassword;
    private javax.swing.JLabel jlPersonalId;
    private javax.swing.JLabel jlPersonalInformation;
    private javax.swing.JLabel jlSex;
    private javax.swing.JLabel jlWorkPhone;
    private javax.swing.JPanel jpPersonalInformation;
    private javax.swing.JPasswordField jpwPassword;
    private javax.swing.JScrollPane jspEducationDetails;
    private javax.swing.JScrollPane jspPersonalInformation;
    private javax.swing.JTable jtEducationDetails;
    private javax.swing.JTextField jtfAddress1;
    private javax.swing.JTextField jtfBirthCity;
    private javax.swing.JTextField jtfBuildingNumber;
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
