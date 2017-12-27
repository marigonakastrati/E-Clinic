/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dao;

import com.jfc.eclinic.dao.exception.RepositoryException;
import com.jfc.eclinic.dto.Adminclinic;
import java.util.List;

/**
 *
 * @author jfc
 */
public interface AdminClinicRepository {

    /**
     * @param t
     * @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public void add(Adminclinic t) throws RepositoryException;

    /**
     * @return @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public List<Adminclinic> findAll() throws RepositoryException;

    /**
     * @param t
     *
     * @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public void update(Adminclinic t) throws RepositoryException;

    /**
     * @param t
     * @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public void remove(Adminclinic t) throws RepositoryException;

    /**
     * @param t
     * @return
     * @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public Adminclinic findById(int t) throws RepositoryException;

}
