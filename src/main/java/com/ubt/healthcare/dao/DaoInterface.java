/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dao;

import java.util.List;

/**
 *
 * @author F
 */
public interface DaoInterface {
    
    public void add(Object student);
    public void edit(Object student);
    public void remove(Object student);
    public List<Object> findAll();
    public Object findById(int id);
}
