/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dao;

import com.jfc.bookingengine.dao.exception.RepositoryException;
import com.jfc.eclinic.dto.Address;
import java.util.List;

/**
 *
 * @author jfc
 */
public interface AddressRepository  {
    
    /**
     * @param <T>
     * @param t
     * @throws com.jfc.bookingengine.dao.impl.RepositoryException
     */
    public void add(Address t) throws RepositoryException;
    /**
     * @param <T>
     * @return
     * @throws com.jfc.bookingengine.dao.impl.RepositoryException */
    public List<Address> findAll() throws RepositoryException;
    /**
     * @param <T>
     * @param t*
     * @throws com.jfc.bookingengine.dao.impl.RepositoryException*/
    public void update(Address t) throws RepositoryException;
    /**
     * @param <T>
     * @param t
     * @throws com.jfc.bookingengine.dao.impl.RepositoryException*/
    public void remove(int t) throws RepositoryException;
    /**
     * @param <T>
     * @param t
     * @return
     * @throws com.jfc.bookingengine.dao.impl.RepositoryException*/
    public Address findById(int t) throws RepositoryException;

}
