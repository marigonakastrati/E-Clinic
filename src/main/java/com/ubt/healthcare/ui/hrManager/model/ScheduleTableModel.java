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

    private List<Schedule> data;

    public ScheduleTableModel(List<Schedule> data) {
        this.data = data;
    }

    public ScheduleTableModel() {
    }

    public void add(List<Schedule> data) {
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

    public Schedule getSchedule(int index) {
        return data.get(index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Schedule s = (Schedule) data.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return s.getDoctorId().getPersonId().getFirstName();
            case 1:
                return s.getDoctorId().getPersonId().getLastName();
            case 2:
                return s.getDateStart().toString();
            case 3:
                return s.getTimeStart().toString();
            case 4: {
                return s.getStatus().getStatusName();
            }
            default:
                return null;
        }
    }

    public List<Schedule> getSchedulestList() {
        return data;
    }
}
