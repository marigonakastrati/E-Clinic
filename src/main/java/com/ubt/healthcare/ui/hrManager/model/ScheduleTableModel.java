/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.hrManager.model;

import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Schedule;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author F
 */
public class ScheduleTableModel extends AbstractTableModel {

    private final String[] columnNames = {"FirstName", "LastName", "Date", "Time", "Status"};

    private List<Doctor> data;

    public ScheduleTableModel(List<Doctor> data) {
        this.data = data;
    }

    public ScheduleTableModel() {
    }

    public void add(List<Doctor> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public void remove(int row) {
        data.remove(row);
    }

    public void removeAll() {

        data.removeAll(data);
    }

    public Doctor getSchedule(int index) {
        return data.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Doctor s = (Doctor) data.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return s.getPersonId().getFirstName();
            case 1:
                return s.getPersonId().getLastName();
            case 2:
                for (Schedule c : s.getPersonId().getDoctor().getScheduleCollection()) {
                    return c.getDateStart();
                }
                return "";
            case 3:
                for (Schedule c : s.getPersonId().getDoctor().getScheduleCollection()) {
                    return c.getTimeStart();
                }
                return "";
            case 4: {

                for (Schedule c : s.getPersonId().getDoctor().getScheduleCollection()) {
                    return c.getStatus().getStatusName();
                }
                return "";
            }
            default:
                return null;
        }
    }

    public List<Doctor> getSchedulestList() {
        return data;
    }
}
