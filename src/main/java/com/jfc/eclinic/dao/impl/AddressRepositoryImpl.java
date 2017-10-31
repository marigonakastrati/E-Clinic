/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dao.impl;

import com.jfc.eclinic.dao.exception.RepositoryException;
import com.jfc.eclinic.dao.AddressRepository;
import com.jfc.eclinic.dto.Address;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jfc
 */
public class AddressRepositoryImpl implements AddressRepository {

    @PersistenceContext(unitName = "eclinicPU")
    EntityManager entityManager;

    @Override
    public void add(Address t) throws RepositoryException {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(t);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
                throw ex;
            }
        }
    }

    @Override
    public List<Address> findAll() {
        return entityManager.createNamedQuery("Address.findAll").getResultList();
    }

    @Override
    public void update(Address t) throws RepositoryException {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(t);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
                throw ex;
            }
        }
    }

    @Override
    public void remove(int t) throws RepositoryException {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(t);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
                throw ex;
            }
        }
    }

    @Override
    public Address findById(int t) throws RepositoryException {
        EntityTransaction transaction = entityManager.getTransaction();
        Query createNamedQuery = entityManager.createNamedQuery("Address.findByAddressId");
        List resultList = null;
        try {
            transaction.begin();
            createNamedQuery.setParameter("addressId", t);
            resultList = createNamedQuery.getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
                throw ex;
            }
        }
        return resultList != null ? (Address) resultList.get(0) : null;
    }

}
