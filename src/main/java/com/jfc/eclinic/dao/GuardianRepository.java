/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dao;

import com.jfc.eclinic.dao.exception.RepositoryException;
import com.jfc.eclinic.dto.Guardian;
import java.util.List;

/**
 *
 * @author mk
 */
public interface GuardianRepository {

    /**
     * @param t
     * @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public void add(Guardian t) throws RepositoryException;

    /**
     * @return @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public List<Guardian> findAll() throws RepositoryException;

    /**
     * @param t
     *
     * @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public void update(Guardian t) throws RepositoryException;

    /**
     * @param t
     * @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public void remove(Guardian t) throws RepositoryException;

    /**
     * @param t
     * @return
     * @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public Guardian findById(int t) throws RepositoryException;

}
