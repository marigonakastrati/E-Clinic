/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.jfc.eclinic.dao;

import com.jfc.eclinic.dao.exception.RepositoryException;
import com.jfc.eclinic.dto.Receptionist;
import java.util.List;

/**
 *
 * @author mk
 */
public interface ReceptionistRepository {

    /**
     * @param t
     * @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public void add(Receptionist t) throws RepositoryException;

    /**
     * @return @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public List<Receptionist> findAll() throws RepositoryException;

    /**
     * @param t
     *
     * @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public void update(Receptionist t) throws RepositoryException;

    /**
     * @param t
     * @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public void remove(Receptionist t) throws RepositoryException;

    /**
     * @param t
     * @return
     * @throws com.jfc.eclinic.dao.exception.RepositoryException
     */
    public Receptionist findById(int t) throws RepositoryException;

}
