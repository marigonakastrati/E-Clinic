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
public interface PersistenceInterface {
    
    public void add(Object student)throws Exception;
    public void update(Object student)throws Exception;
    public void remove(Object student)throws Exception;
    public List<Object> findAll(String entity)throws Exception;
    public Object findById(int id, String entity, String atribute)throws Exception;
}
