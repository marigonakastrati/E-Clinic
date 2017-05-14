/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.model;

import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.PersonEducation;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author F
 */
public class DoctorTableModelEducation extends AbstractTableModel {

    private final String[] columnNames = {"Emri", "Mbiemri", "Ditelindja", "Mosha"};

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
    public String getColumnName(int col){
        return columnNames[col];
    }
    public void remove(int row){
        data.remove(row);
    }

    public PersonEducation getDoctor(int index){
        return data.get(index);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PersonEducation s = (PersonEducation)data.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return s.getPersonId().getFirstName();
            case 1:
                return s.getPersonId().getLastName();
            case 2:
                return s.getPersonId().getDateOfBirth(); 
             case 3: 
                 return s.getPersonId().getDateOfBirth();    
            
            default:
                return null;
        }
    }
}
