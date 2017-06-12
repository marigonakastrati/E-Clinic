/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.clinicManager;

import com.ubt.healthcare.business.AddressService;
import com.ubt.healthcare.business.CityService;
import com.ubt.healthcare.business.ContactService;
import com.ubt.healthcare.business.CountryService;
import com.ubt.healthcare.business.EducationProgramService;
import com.ubt.healthcare.business.EducationService;
import com.ubt.healthcare.business.EducationTypeService;
import com.ubt.healthcare.business.GenderService;
import com.ubt.healthcare.business.LoginGroupService;
import com.ubt.healthcare.business.MartialStatusService;
import com.ubt.healthcare.business.PersonArchiveService;
import com.ubt.healthcare.business.PersonEducationService;
import com.ubt.healthcare.business.PersonService;
import com.ubt.healthcare.business.ReligionService;
import com.ubt.healthcare.business.ScheduleService;
import com.ubt.healthcare.business.ScheduleStatusService;
import com.ubt.healthcare.business.UserGroupService;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.HRManager;
import com.ubt.healthcare.dto.Person;
import com.ubt.healthcare.dto.Receptionist;
import com.ubt.healthcare.dto.Schedule;
import com.ubt.healthcare.dto.ScheduleStatus;
import com.ubt.healthcare.ui.clinicManager.model.DoctorTableModelSelectDoctor;
import com.ubt.healthcare.ui.clinicManager.model.ScheduleTableModel;
import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.ui.util.LoadTables;
import com.ubt.healthcare.ui.util.PasswordHashing;
import java.awt.event.MouseAdapter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author F
 */
public class JIFAddShift extends javax.swing.JInternalFrame {

    private List<Schedule> scheduleList;
    private ScheduleService scheduleService;
    private ScheduleTableModel scheduleTableModelViewNurse;
    private LoadTables loadTable;
    private PasswordHashing passwordHashing;
    private InputValidation inputValidation;
    private Receptionist receptionist;
    private ContactService contactService;
    private EducationTypeService educationTypeService;
    private EducationProgramService educationProgramService;
    private EducationService educationService;
    private PersonEducationService personEducationService;
    private GenderService genderService;
    private MartialStatusService martialStatusService;
    private CityService cityService;
    private CountryService countryService;
    private ReligionService religionService;
    private AddressService addressService;
    private PersonService personService;
    private PersonArchiveService personArchiveService;
    private UserGroupService userGroupService;
    private LoginGroupService loginGroupService;
    private HRManager hrManager;
    private Schedule schedule;
    private ScheduleStatusService scheduleStatusService;
    private JIFSearchDoctor jifSearchDoctor;

    /**
     * Creates new form JIFHRManager
     *
     * @param jifSearchDoctor
     */
    public JIFAddShift(JIFSearchDoctor jifSearchDoctor) {
        initComponents();
        scheduleService = new ScheduleService();
        scheduleStatusService = new ScheduleStatusService();
        loadTable = new LoadTables();
        passwordHashing = new PasswordHashing();
        inputValidation = new InputValidation();
        contactService = new ContactService();
        educationTypeService = new EducationTypeService();
        educationProgramService = new EducationProgramService();
        personEducationService = new PersonEducationService();
        educationService = new EducationService();
        religionService = new ReligionService();
        genderService = new GenderService();
        martialStatusService = new MartialStatusService();
        cityService = new CityService();
        countryService = new CountryService();
        addressService = new AddressService();
        personService = new PersonService();
        userGroupService = new UserGroupService();
        loginGroupService = new LoginGroupService();
        personArchiveService = new PersonArchiveService();
        this.jifSearchDoctor = jifSearchDoctor;
        fillComboBoxScheduleStatusSearch();
        fillComboBoxScheduleStatus();
        bindTheShiftSearchTableModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jspDoctorTable = new javax.swing.JScrollPane();
        jtScheduleList = new javax.swing.JTable();
        jtfFirstNameSearch = new javax.swing.JTextField();
        jtfLastNameSearch = new javax.swing.JTextField();
        jcbStatusSearch = new javax.swing.JComboBox<>();
        jbSearchShift = new javax.swing.JButton();
        jbSaveShift = new javax.swing.JButton();
        jlFirstNameSearch = new javax.swing.JLabel();
        jlLastNameSearch = new javax.swing.JLabel();
        jlStatusSearch = new javax.swing.JLabel();
        jbCancel = new javax.swing.JButton();
        jdcDateOfShiftSearch = new com.toedter.calendar.JDateChooser();
        jlDateSearch = new javax.swing.JLabel();
        jlFirstName = new javax.swing.JLabel();
        jtfFirstName = new javax.swing.JTextField();
        jlLastName = new javax.swing.JLabel();
        jtfLastName = new javax.swing.JTextField();
        jlDateStart = new javax.swing.JLabel();
        jlDateEnd = new javax.swing.JLabel();
        jlTimeStart = new javax.swing.JLabel();
        jtfTimeStart = new javax.swing.JTextField();
        jlTimeEnd = new javax.swing.JLabel();
        jtfTimeEnd = new javax.swing.JTextField();
        jdcDateStart = new com.toedter.calendar.JDateChooser();
        jdcDateEnd = new com.toedter.calendar.JDateChooser();
        jlStatus = new javax.swing.JLabel();
        jcbStatus = new javax.swing.JComboBox<>();
        jbSelectDoctor = new javax.swing.JButton();
        jlDoctorId = new javax.swing.JLabel();
        jtfDoctorId = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Shift Management");
        setToolTipText("");

        jtScheduleList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jspDoctorTable.setViewportView(jtScheduleList);

        jtfLastNameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfLastNameSearchActionPerformed(evt);
            }
        });

        jbSearchShift.setText("Search");
        jbSearchShift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchShiftActionPerformed(evt);
            }
        });

        jbSaveShift.setText("Save");

        jlFirstNameSearch.setText("First Name");

        jlLastNameSearch.setText("Last Name");

        jlStatusSearch.setText("Status");

        jbCancel.setText("Cancel");
        jbCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelActionPerformed(evt);
            }
        });

        jlDateSearch.setText("Date");

        jlFirstName.setText("First Name");

        jtfFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFirstNameActionPerformed(evt);
            }
        });

        jlLastName.setText("Last Name");

        jlDateStart.setText("Date Start");

        jlDateEnd.setText("Date End");

        jlTimeStart.setText("Time Start");

        jlTimeEnd.setText("Time End");

        jlStatus.setText("Status");

        jbSelectDoctor.setText("Select Doctor");

        jlDoctorId.setText("Id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlFirstNameSearch)
                            .addComponent(jtfFirstNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlLastNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfLastNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbSaveShift, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcbStatusSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlStatusSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlDateSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(305, 305, 305))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jdcDateOfShiftSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jbSearchShift, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspDoctorTable)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlTimeEnd)
                                    .addComponent(jlTimeStart)
                                    .addComponent(jlStatus))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfTimeEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jtfTimeStart, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jcbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jlFirstName)
                                                .addComponent(jlLastName)
                                                .addComponent(jlDateStart))
                                            .addGap(50, 50, 50))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jlDateEnd)
                                            .addGap(61, 61, 61)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlDoctorId)
                                        .addGap(71, 71, 71)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jtfLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jdcDateStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jdcDateEnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfDoctorId))
                                .addGap(13, 13, 13)
                                .addComponent(jbSelectDoctor)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jlDateSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbCancel)
                                .addComponent(jbSearchShift))
                            .addComponent(jbSaveShift, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jlFirstNameSearch)
                                    .addComponent(jlLastNameSearch)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlStatusSearch)
                                .addGap(4, 4, 4)))))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtfFirstNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfLastNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbStatusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jdcDateOfShiftSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspDoctorTable, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSelectDoctor)
                    .addComponent(jlDoctorId)
                    .addComponent(jtfDoctorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFirstName)
                    .addComponent(jtfFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlLastName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlDateStart)
                    .addComponent(jdcDateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlDateEnd)
                    .addComponent(jdcDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTimeStart)
                    .addComponent(jtfTimeStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTimeEnd)
                    .addComponent(jtfTimeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlStatus)
                    .addComponent(jcbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfLastNameSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfLastNameSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfLastNameSearchActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        clearTheFields();
        bindTheShiftSearchTableModel();
    }//GEN-LAST:event_jbCancelActionPerformed

    private void jtfFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfFirstNameActionPerformed

    private void jbSearchShiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchShiftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbSearchShiftActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbSaveShift;
    private javax.swing.JButton jbSearchShift;
    private javax.swing.JButton jbSelectDoctor;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JComboBox<String> jcbStatusSearch;
    private com.toedter.calendar.JDateChooser jdcDateEnd;
    private com.toedter.calendar.JDateChooser jdcDateOfShiftSearch;
    private com.toedter.calendar.JDateChooser jdcDateStart;
    private javax.swing.JLabel jlDateEnd;
    private javax.swing.JLabel jlDateSearch;
    private javax.swing.JLabel jlDateStart;
    private javax.swing.JLabel jlDoctorId;
    private javax.swing.JLabel jlFirstName;
    private javax.swing.JLabel jlFirstNameSearch;
    private javax.swing.JLabel jlLastName;
    private javax.swing.JLabel jlLastNameSearch;
    private javax.swing.JLabel jlStatus;
    private javax.swing.JLabel jlStatusSearch;
    private javax.swing.JLabel jlTimeEnd;
    private javax.swing.JLabel jlTimeStart;
    private javax.swing.JScrollPane jspDoctorTable;
    private javax.swing.JTable jtScheduleList;
    private javax.swing.JTextField jtfDoctorId;
    private javax.swing.JTextField jtfFirstName;
    private javax.swing.JTextField jtfFirstNameSearch;
    private javax.swing.JTextField jtfLastName;
    private javax.swing.JTextField jtfLastNameSearch;
    private javax.swing.JTextField jtfTimeEnd;
    private javax.swing.JTextField jtfTimeStart;
    // End of variables declaration//GEN-END:variables

    public void addSaveShiftInternalFrameMouseAdapter(MouseAdapter e) {
        jbSaveShift.addMouseListener(e);
    }

    public void addSearchShiftPanelMouseAdapter(MouseAdapter e) {
        jbSearchShift.addMouseListener(e);
    }

    public void addSelectDoctorPanelMouseAdapter(MouseAdapter e) {
        jbSelectDoctor.addMouseListener(e);
    }

    public void loadShiftListTable(String name, String surname, String statusOfShift, Date dateOfShift) {
        try {
            scheduleList = scheduleService.findDoctorShift(name, surname, statusOfShift, dateOfShift);
            if (scheduleList.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No shift found");
            } else {
                scheduleTableModelViewNurse = new ScheduleTableModel(scheduleList);
                jtScheduleList.setModel(scheduleTableModelViewNurse);
                scheduleTableModelViewNurse.fireTableDataChanged();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error detected while connecting on database");

        }
    }

    public void searchShiftInternalPane() {
        String firstName = jtfFirstNameSearch.getText();
        String lastName = jtfLastNameSearch.getText();
        String statusOfShift = jcbStatusSearch.getSelectedIndex() < 0 ? "" : jcbStatusSearch.getSelectedItem().toString();
        Date dateOfShift = jdcDateOfShiftSearch.getDate();

        if (firstName.trim().length() == 0 && lastName.trim().length() == 0 && statusOfShift.trim().length() == 0
                && dateOfShift == null) {
            JOptionPane.showMessageDialog(rootPane, "Please fill the fields to find the shift you are looking for");
        } else {

            loadShiftListTable(firstName, lastName, statusOfShift, dateOfShift);

        }
    }

    public void fillComboBoxScheduleStatusSearch() {
        try {
            List<Object> obj = loadTable.fillComboBoxScheduleStatus();
            jcbStatusSearch.removeAllItems();
            jcbStatusSearch.addItem("");
            for (Object o : obj) {
                jcbStatusSearch.addItem(((ScheduleStatus) o).getStatusName());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error detected while connecting on database");

        }
    }

    public void fillComboBoxScheduleStatus() {
        try {
            List<Object> obj = loadTable.fillComboBoxScheduleStatus();
            jcbStatus.removeAllItems();
            jcbStatus.addItem("");
            for (Object o : obj) {
                jcbStatus.addItem(((ScheduleStatus) o).getStatusName());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error detected while connecting on database");

        }
    }

    public int getSelectedScheduleStatusIndex(String scheduleStatus) {
        try {
            List<ScheduleStatus> fillComboBoxscheduleStatus = (List<ScheduleStatus>) (Object) loadTable.fillComboBoxScheduleStatus();
            int i = 0;
            for (ScheduleStatus object : fillComboBoxscheduleStatus) {
                if (object.getStatusName().equals(scheduleStatus)) {
                    return i + 1;
                }
                i++;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error detected while connecting on database");

        }
        return -1;
    }

    public void shiftTableRowSelectionListener() {
        final ListSelectionModel selectedModel = jtScheduleList.getSelectionModel();
        selectedModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                int selectedRow = selectedModel.getAnchorSelectionIndex();
                if (selectedRow > -1) {
                    Schedule schedule = scheduleTableModelViewNurse.getSchedule(selectedRow);
                    updateScheduleFields(schedule);

                }
            }
        });
    }

    private void bindTheShiftSearchTableModel() {
        scheduleTableModelViewNurse = new ScheduleTableModel(new ArrayList<>());
        scheduleTableModelViewNurse.add(new ArrayList<>());
        jtScheduleList.setModel(scheduleTableModelViewNurse);
        scheduleTableModelViewNurse.fireTableDataChanged();
        shiftTableRowSelectionListener();
    }

    private void updateScheduleFields(Schedule schedule) {

        jtfDoctorId.setText(String.valueOf(schedule.getDoctorId().getDoctorId()));
        jtfFirstName.setText(schedule.getDoctorId().getPersonId().getFirstName());
        jtfLastName.setText(schedule.getDoctorId().getPersonId().getLastName());
        jcbStatus.setSelectedIndex(getSelectedScheduleStatusIndex(schedule.getStatus().getStatusName()));
        jdcDateStart.setDate(schedule.getDateStart());
        jdcDateEnd.setDate(schedule.getDateEnd());
        jtfTimeStart.setText(schedule.getTimeStart().toString());
        jtfTimeEnd.setText(schedule.getTimeEnd().toString());
    }

    public void saveShiftInternalFrame() {

        int row = jtScheduleList.getSelectedRow();

        String firstName = jtfFirstName.getText();
        String lastName = jtfLastName.getText();
        Date dateStart = jdcDateStart.getDate();
        Date dateEnd = jdcDateEnd.getDate();
        String status = jcbStatus.getSelectedItem().toString();
        try {
            LocalTime timeStart = LocalTime.parse(jtfTimeStart.getText());
            LocalTime timeEnd = LocalTime.parse(jtfTimeEnd.getText());

            if (!("Valid".equals(inputValidation.validatePersonFirstName(firstName)))) {
                JOptionPane.showMessageDialog(rootPane, inputValidation.validatePersonFirstName(firstName));
            } else if (!("Valid".equals(inputValidation.validatePersonLastName(lastName)))) {
                JOptionPane.showMessageDialog(rootPane, inputValidation.validatePersonLastName(lastName));
            } else if (!("Valid".equals(inputValidation.validateScheduleDate(dateStart, dateEnd)))) {
                JOptionPane.showMessageDialog(rootPane, inputValidation.validateScheduleDate(dateStart, dateEnd));
            } else if (!("Valid".equals(inputValidation.validateScheduleTime(timeStart, timeEnd)))) {
                JOptionPane.showMessageDialog(rootPane, inputValidation.validateScheduleTime(timeStart, timeEnd));
            } else if (!("Valid".equals(inputValidation.validateScheduleStatus(status)))) {
                JOptionPane.showMessageDialog(rootPane, inputValidation.validateScheduleStatus(status));
            } else {

                if (row == -1) {

                    try {
                        schedule = new Schedule();
                        Person person = personService.checkIfPersonExists(firstName, lastName);
                        ScheduleStatus scheduleStus = scheduleStatusService.findTheScheduleStatus(status);
                        if (person == null) {
                            JOptionPane.showMessageDialog(rootPane, "Doctor not found");
                        } else {
                            schedule.setManagerId(hrManager);
                            schedule.setDateEnd(dateEnd);
                            schedule.setDateStart(dateStart);
                            schedule.setTimeStart(Date.from(timeStart.atDate(LocalDate.of(2017, 2, 1)).atZone(ZoneId.systemDefault()).toInstant()));
                            schedule.setTimeEnd(Date.from(timeEnd.atDate(LocalDate.of(2017, 2, 1)).atZone(ZoneId.systemDefault()).toInstant()));
                            schedule.setDoctorId(person.getDoctor());
                            schedule.setStatus(scheduleStus);
                            scheduleService.persistSchedule(schedule);
                            JOptionPane.showMessageDialog(rootPane, "Shift saved successfully ");
                        }
                    } catch (ConstraintViolationException ex) {
                        if (ex.getErrorCode() == 2627) {
                            JOptionPane.showMessageDialog(rootPane, "Error detected: Shift already exists");

                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(rootPane, "Error detected: " + ex.getMessage());
                    }

                }
            }
        } catch (Exception ex) {
            if (ex instanceof DateTimeParseException) {
                JOptionPane.showMessageDialog(rootPane, "The time must be on proper format");
            }
        }

    }

    private void clearTheFields() {
        jtfDoctorId.setText("");
        jtfFirstName.setText("");
        jtfLastName.setText("");
        jcbStatus.setSelectedIndex(0);
        jdcDateStart.setDate(null);
        jdcDateEnd.setDate(null);
        jtfTimeStart.setText("");
        jtfTimeEnd.setText("");
        jtfFirstNameSearch.setText("");
        jtfLastNameSearch.setText("");
        jcbStatusSearch.setSelectedIndex(0);
        jdcDateOfShiftSearch.setDate(null);
    }

    public void setHrManager(HRManager hrManager) {
        this.hrManager = hrManager;
    }

    public void updateDoctorFields() {
        DoctorTableModelSelectDoctor model = (DoctorTableModelSelectDoctor) jifSearchDoctor.getJtDoctorListTable().getModel();
        int row = jifSearchDoctor.getJtDoctorListTable().getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(rootPane, "No Doctor Selected");
        } else {
            Doctor doctor = model.getDoctor(row);
            jtfFirstName.setText(doctor.getPersonId().getFirstName());
            jtfLastName.setText(doctor.getPersonId().getLastName());
            jtfDoctorId.setText(String.valueOf(doctor.getDoctorId()));
            jifSearchDoctor.bindTheDoctorSearchTableModel();
            jifSearchDoctor.clearTheFields();
            jifSearchDoctor.dispose();
        }
    }
}
