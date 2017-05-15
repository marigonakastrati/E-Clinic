/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.ui.admin.model;

import com.ubt.healthcare.dto.City;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author F
 */
public class DoctorComboBoxModelCity extends AbstractListModel<City> implements ComboBoxModel<City> {

    private List<City> data;
    private City selectedElement;

    public DoctorComboBoxModelCity(List<City> data) 
    {

        this.data = data;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public City getElementAt(int i) {
        return data.get(i);
    }

    @Override
    public void setSelectedItem(Object obj) {
        selectedElement = (City) obj;
    }

    @Override
    public Object getSelectedItem() {

        return selectedElement;
    }
}
