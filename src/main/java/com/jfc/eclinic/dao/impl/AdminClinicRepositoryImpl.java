/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dao.impl;

import com.jfc.eclinic.dao.AdminClinicRepository;
import com.jfc.eclinic.dao.exception.RepositoryException;
import com.jfc.eclinic.dto.Adminclinic;
import java.util.List;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author mk
 */
@Named
public class AdminClinicRepositoryImpl implements AdminClinicRepository {

    @PersistenceContext(unitName = "eclinicPU")
    EntityManager entityManager;

    @Override
    public void add(Adminclinic t) throws RepositoryException {
        entityManager.persist(t);

    }

    @Override
    public List<Adminclinic> findAll() {
        return entityManager.createNamedQuery("Adminclinic.findAll").getResultList();
    }

    @Override
    public void update(Adminclinic t) throws RepositoryException {
        entityManager.merge(t);

    }

    @Override
    public void remove(Adminclinic t) throws RepositoryException {
        Adminclinic current = null;
        if (!entityManager.contains(t)) {
            current = entityManager.merge(t);
        }
        entityManager.remove(current);

    }

    @Override
    public Adminclinic findById(int t) throws RepositoryException {
        Query createNamedQuery = entityManager.createNamedQuery("Adminclinic.findByAdminClinicId");
        List resultList = null;

        createNamedQuery.setParameter("adminClinicId", t);
        resultList = createNamedQuery.getResultList();

        return resultList != null ? (Adminclinic) resultList.get(0) : null;
    }

}
