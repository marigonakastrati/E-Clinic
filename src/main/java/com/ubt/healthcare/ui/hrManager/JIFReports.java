/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.hrManager;

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
import com.ubt.healthcare.business.UserGroupService;
import com.ubt.healthcare.dto.Address;
import com.ubt.healthcare.dto.City;
import com.ubt.healthcare.dto.Contact;
import com.ubt.healthcare.dto.Country;
import com.ubt.healthcare.dto.Gender;
import com.ubt.healthcare.dto.MartialStatus;
import com.ubt.healthcare.dto.Person;
import com.ubt.healthcare.dto.Receptionist;
import com.ubt.healthcare.dto.Religion;
import com.ubt.healthcare.dto.Schedule;
import com.ubt.healthcare.dto.ScheduleStatus;
import com.ubt.healthcare.dto.UserGroup;
import com.ubt.healthcare.ui.hrManager.model.ScheduleTableModel;
import com.ubt.healthcare.ui.util.InputValidation;
import com.ubt.healthcare.ui.util.LoadTables;
import com.ubt.healthcare.ui.util.PasswordHashing;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author F
 */
public class JIFReports extends javax.swing.JInternalFrame {

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

    /**
     * Creates new form JIFHRManager
     */
    public JIFReports() {
        initComponents();
        scheduleService = new ScheduleService();
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
        fillComboBoxScheduleStatusSearch();
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
        jtDoctorListTable = new javax.swing.JTable();
        jtfFirstNameSearch = new javax.swing.JTextField();
        jtfLastNameSearch = new javax.swing.JTextField();
        jcbStatusSearch = new javax.swing.JComboBox<>();
        jbSearchShift = new javax.swing.JButton();
        jbViewReports = new javax.swing.JButton();
        jlFirstNameSearch = new javax.swing.JLabel();
        jlLastNameSearch = new javax.swing.JLabel();
        jlStatusSearch = new javax.swing.JLabel();
        jbCancel = new javax.swing.JButton();
        jdcDateOfShiftSearch = new com.toedter.calendar.JDateChooser();
        jlDateSearch = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Reports");
        setToolTipText("");

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

        jtfLastNameSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfLastNameSearchActionPerformed(evt);
            }
        });

        jbSearchShift.setText("Search");

        jbViewReports.setText("View Report");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlFirstNameSearch)
                    .addComponent(jtfFirstNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLastNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfLastNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlStatusSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(126, 126, 126))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbStatusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlDateSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(305, 305, 305))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdcDateOfShiftSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(122, 122, 122)
                        .addComponent(jbSearchShift, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(21, 21, 21))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jbViewReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(391, 391, 391)
                .addComponent(jbCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addGap(246, 246, 246))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspDoctorTable)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbViewReports)
                            .addComponent(jbCancel))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlFirstNameSearch)
                            .addComponent(jlLastNameSearch)
                            .addComponent(jlStatusSearch)))
                    .addComponent(jlDateSearch, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jbSearchShift, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfFirstNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtfLastNameSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcbStatusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jdcDateOfShiftSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspDoctorTable, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbCancel;
    private javax.swing.JButton jbSearchShift;
    private javax.swing.JButton jbViewReports;
    private javax.swing.JComboBox<String> jcbStatusSearch;
    private com.toedter.calendar.JDateChooser jdcDateOfShiftSearch;
    private javax.swing.JLabel jlDateSearch;
    private javax.swing.JLabel jlFirstNameSearch;
    private javax.swing.JLabel jlLastNameSearch;
    private javax.swing.JLabel jlStatusSearch;
    private javax.swing.JScrollPane jspDoctorTable;
    private javax.swing.JTable jtDoctorListTable;
    private javax.swing.JTextField jtfFirstNameSearch;
    private javax.swing.JTextField jtfLastNameSearch;
    // End of variables declaration//GEN-END:variables

    public void addViewReportInternalFrameMouseAdapter(MouseAdapter e) {
        jbViewReports.addMouseListener(e);
    }

    public void addSearchShiftPanelMouseAdapter(MouseAdapter e) {
        jbSearchShift.addMouseListener(e);
    }

    public void loadShiftListTable(String name, String surname, String statusOfShift, Date dateOfShift) {
        try {
            scheduleList = scheduleService.findDoctorShift(name, surname, statusOfShift, dateOfShift);
            scheduleTableModelViewNurse = new ScheduleTableModel(scheduleList);
            jtDoctorListTable.setModel(scheduleTableModelViewNurse);
            scheduleTableModelViewNurse.fireTableDataChanged();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error detected while connecting on database");

        }
    }

    public void searchShiftInternalPane() {
        String nameOfNurse = jtfFirstNameSearch.getText();
        String surNameOfNurse = jtfLastNameSearch.getText();
        String statusOfShift = jcbStatusSearch.getSelectedIndex() < 0 ? "" : jcbStatusSearch.getSelectedItem().toString();
        Date dateOfShift = jdcDateOfShiftSearch.getDate();

        if (nameOfNurse.trim().length() == 0 && surNameOfNurse.trim().length() == 0 && statusOfShift.trim().length() == 0
                && dateOfShift == null) {
            JOptionPane.showMessageDialog(rootPane, "Please fill the fields to find the shift you are looking for");
        } else {

            loadShiftListTable(nameOfNurse, surNameOfNurse, statusOfShift, dateOfShift);

        }
    }

    public void viewReports() {
        List<Map<String, Object>> dataSource = new ArrayList<Map<String, Object>>();
        if (scheduleList == null || scheduleList.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Query the data before generating reports");
        } else {
            try {
                for (Schedule schedule : scheduleList) {
                    Map<String, Object> row = new HashMap<>();
                    row.put("First Name", schedule.getDoctorId().getPersonId().getFirstName());
                    row.put("Last Name", schedule.getDoctorId().getPersonId().getLastName());
                    row.put("Date", schedule.getDateStart().toString());
                    row.put("Time", schedule.getTimeStart().toString());
                    row.put("Status", schedule.getStatus().getStatusName());
                    dataSource.add(row);
                }
                JRDataSource jRDataSource = new JRBeanCollectionDataSource(dataSource);
                JasperReport jasperReport = JasperCompileManager.compileReport(this.getClass().getResourceAsStream("/com/ubt/healthcare/ui/hrManager/report/ReportShift.jrxml"));
                this.getClass().getResourceAsStream(title);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jRDataSource);
                JasperViewer jasperViewer = new JasperViewer(jasperPrint);
                jasperViewer.setVisible(true);

            } catch (JRException ex) {
                //Logger.getLogger(FW.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void fillComboBoxScheduleStatusSearch() {
        try {
            List<Object> obj = loadTable.fillComboBoxScheduleStatus();
            jcbStatusSearch.addItem("");
            for (Object o : obj) {
                jcbStatusSearch.addItem(((ScheduleStatus) o).getStatusName());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error detected while connecting on database");

        }
    }

    public int getSelectedBirthCityIndex(String city) {
        try {
            List<City> fillComboBoxEducationType = (List<City>) (Object) loadTable.fillComboBoxBirthCity();
            int i = 0;
            for (City object : fillComboBoxEducationType) {
                if (object.getCityName().equals(city)) {
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
        final ListSelectionModel selectedModel = jtDoctorListTable.getSelectionModel();
        selectedModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                int selectedRow = selectedModel.getAnchorSelectionIndex();
                if (selectedRow > -1) {
                    Person pe = scheduleTableModelViewNurse.getSchedule(selectedRow).getDoctorId().getPersonId();
                }
            }
        });
    }

    private void bindTheShiftSearchTableModel() {
        scheduleTableModelViewNurse = new ScheduleTableModel(new ArrayList<>());
        scheduleTableModelViewNurse.add(new ArrayList<>());
        jtDoctorListTable.setModel(scheduleTableModelViewNurse);
        scheduleTableModelViewNurse.fireTableDataChanged();
        shiftTableRowSelectionListener();
    }

    private void clearTheFields() {
        jtfFirstNameSearch.setText("");
        jtfLastNameSearch.setText("");
        jcbStatusSearch.setSelectedIndex(0);
        jdcDateOfShiftSearch.setDate(null);
    }
}
