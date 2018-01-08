/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dao.impl;

import com.jfc.eclinic.dao.GuardianRepository;
import com.jfc.eclinic.dao.exception.RepositoryException;
import com.jfc.eclinic.dto.Guardian;
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
public class GuardianRepositoryImpl implements GuardianRepository {

    @PersistenceContext(unitName = "eclinicPU")
    EntityManager entityManager;

    @Override
    public void add(Guardian t) throws RepositoryException {
        entityManager.persist(t);

    }

    @Override
    public List<Guardian> findAll() {
        return entityManager.createNamedQuery("Guardian.findAll").getResultList();
    }

    @Override
    public void update(Guardian t) throws RepositoryException {
        entityManager.merge(t);

    }

    @Override
    public void remove(Guardian t) throws RepositoryException {
        Guardian current = null;
        if (!entityManager.contains(t)) {
            current = entityManager.merge(t);
        }
        entityManager.remove(current);

    }

    @Override
    public Guardian findById(int t) throws RepositoryException {
        Query createNamedQuery = entityManager.createNamedQuery("Guardian.findByGuardianId");
        List resultList = null;

        createNamedQuery.setParameter("guardianId", t);
        resultList = createNamedQuery.getResultList();

        return resultList != null ? (Guardian) resultList.get(0) : null;
    }

}
