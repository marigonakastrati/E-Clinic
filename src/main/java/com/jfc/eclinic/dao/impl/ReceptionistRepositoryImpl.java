/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.jfc.eclinic.dao.impl;

import com.jfc.eclinic.dao.ReceptionistRepository;
import com.jfc.eclinic.dao.exception.RepositoryException;
import com.jfc.eclinic.dto.Receptionist;
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
public class ReceptionistRepositoryImpl implements ReceptionistRepository {

    @PersistenceContext(unitName = "eclinicPU")
    EntityManager entityManager;

    @Override
    public void add(Receptionist t) throws RepositoryException {
        entityManager.persist(t);

    }

    @Override
    public List<Receptionist> findAll() {
        return entityManager.createNamedQuery("Receptionist.findAll").getResultList();
    }

    @Override
    public void update(Receptionist t) throws RepositoryException {
        entityManager.merge(t);

    }

    @Override
    public void remove(Receptionist t) throws RepositoryException {
        Receptionist current = null;
        if (!entityManager.contains(t)) {
            current = entityManager.merge(t);
        }
        entityManager.remove(current);

    }

    @Override
    public Receptionist findById(int t) throws RepositoryException {
        Query createNamedQuery = entityManager.createNamedQuery("Receptionist.findByReceptionistId");
        List resultList = null;

        createNamedQuery.setParameter("receptionistId", t);
        resultList = createNamedQuery.getResultList();

        return resultList != null ? (Receptionist) resultList.get(0) : null;
    }

}
