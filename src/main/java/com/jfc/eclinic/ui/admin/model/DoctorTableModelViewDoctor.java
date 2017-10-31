/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.model;

import com.ubt.healthcare.dto.Contact;
import com.ubt.healthcare.dto.Doctor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author F
 */
public class DoctorTableModelViewDoctor extends AbstractTableModel {

    private final String[] columnNames = {"First Name", "Last Name", "City", "Phone Number"};

    private List<Doctor> data;

    public DoctorTableModelViewDoctor(List<Doctor> data) {
        this.data = data;
    }

    public DoctorTableModelViewDoctor() {
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
    public String getColumnName(int col){
        return columnNames[col];
    }
    public void remove(int row){
        data.remove(row);
    }
    
    public void removeAll()
    {
        
        data.removeAll(data);
    }

    public Doctor getDoctor(int index){
        return data.get(index);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Doctor s = (Doctor)data.get(rowIndex);
        switch(columnIndex){
            
            case 0:
                return s.getPersonId().getFirstName();
            case 1:
                return s.getPersonId().getLastName();
            case 2:
                return s.getPersonId().getAddressId().getCityId().getCityName(); 
            case 3: 
             {
                 for(Contact c : s.getPersonId().getContactCollection())
                 {
                    if(c.getType().trim().equals("MOB"))
                    {
                        return c.getValue();
                    }
                 }
                  return "";
             }
            default:
                return null;
        }
    }
    
    public List<Doctor> getDoctorList()
    {
        return data;
    }
}
