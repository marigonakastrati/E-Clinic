/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.dao.impl;

import com.jfc.eclinic.dao.exception.RepositoryException;
import com.jfc.eclinic.dao.CountryRepository;
import com.jfc.eclinic.dto.Country;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author jfc
 */
public class CountryRepositoryImpl implements CountryRepository {

    @PersistenceContext(unitName = "eclinicPU")
    EntityManager entityManager;

    @Override
    public void add(Country t) throws RepositoryException {
        entityManager.persist(t);

    }

    @Override
    public List<Country> findAll() {
        return entityManager.createNamedQuery("Country.findAll").getResultList();
    }

    @Override
    public void update(Country t) throws RepositoryException {
        entityManager.merge(t);

    }

    @Override
    public void remove(int t) throws RepositoryException {
        entityManager.remove(t);

    }

    @Override
    public Country findById(int t) throws RepositoryException {
        Query createNamedQuery = entityManager.createNamedQuery("Country.findByCountryId");
        List resultList = null;

        createNamedQuery.setParameter("countryId", t);
        resultList = createNamedQuery.getResultList();

        return resultList != null ? (Country) resultList.get(0) : null;
    }

}
