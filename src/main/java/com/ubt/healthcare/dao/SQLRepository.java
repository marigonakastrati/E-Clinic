/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author F
 */
public class SQLRepository implements PersistenceInterface {

    @Override
    public void add(Object entity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
                throw ex;
            }
        } finally {
            session.close();
        }

    }

    @Override
    public void update(Object entity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(entity);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
                throw ex;
            }
        } finally {
            session.close();
        }
    }

    @Override
    public void remove(Object entity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                tx.rollback();
                throw ex;
            }
        } finally {
            session.close();
        }
    }

    @Override
    public List<Object> findAll(String entity) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Object> list = null;
        try {
            tx = session.beginTransaction();
            //Query query = session.createQuery("From Patient"); HQL
            Query query = session.getNamedQuery(entity);
            list = query.list();
            tx.commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public Object findById(int id, String entity, String attribute) throws Exception {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Object> object = null;
        try {
            tx = session.beginTransaction();
            Query query = session.getNamedQuery(entity);
            query.setParameter(attribute, id);
            object = query.list();
            tx.commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            session.close();
        }

        return object != null ? object.get(0) : null;
    }

}
