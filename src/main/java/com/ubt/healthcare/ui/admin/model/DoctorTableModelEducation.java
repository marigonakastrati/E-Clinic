/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.model;

import com.ubt.healthcare.dto.PersonEducation;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author F
 */
public class DoctorTableModelEducation extends AbstractTableModel {

    private final String[] columnNames = {"Program Type", "Education Type", "Institution", "Date Start", "Date End"};

    private List<PersonEducation> data;

    public DoctorTableModelEducation(List<PersonEducation> data) {
        this.data = data;
    }

    public DoctorTableModelEducation() {
    }

    public void add(List<PersonEducation> data) {
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

    public PersonEducation getPersonEducation(int index) {
        return data.get(index);
    }

    public void removeAll() {

        data.removeAll(data);
    }

    public List<PersonEducation> getPersonEducation() {
        return data;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PersonEducation s = (PersonEducation) data.get(rowIndex);
        switch (columnIndex) {

            case 0: {
                return s.getEducationId().getEducationProgramId().getProgramName();
            }
            case 1: {
                return s.getEducationId().getEucationTypeId().getEducationName();
            }
            case 2: {
                return s.getEducationId().getInstitutionName();
            }
            case 3: {
                return s.getDateStart().toString();
            }
            case 4: {
                return s.getDateEnd().toString();
            }

            default:
                return null;
        }
    }
}
