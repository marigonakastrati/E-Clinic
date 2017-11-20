/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dao;

import com.jfc.eclinic.dao.exception.RepositoryException;
import com.jfc.eclinic.dto.Country;
import java.util.List;

/**
 *
 * @author jfc
 */
public interface CountryRepository  {
    
    /**
     * @param t
     * @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public void add(Country t) throws RepositoryException;
    /**
     * @return
     * @throws com.jfc.eclinic.dao.exception.RepositoryException */
    public List<Country> findAll() throws RepositoryException;
    /**
     * @param t*
     * @throws com.jfc.eclinic.dao.exception.RepositoryException*/
    public void update(Country t) throws RepositoryException;
    /**
     * @param t
     * @throws com.jfc.eclinic.dao.exception.RepositoryException*/
    public void remove(int t) throws RepositoryException;
    /**
     * @param t
     * @return
     * @throws com.jfc.eclinic.dao.exception.RepositoryException*/
    public Country findById(int t) throws RepositoryException;

}
