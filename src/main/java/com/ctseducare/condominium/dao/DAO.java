package com.ctseducare.condominium.dao;

import com.ctseducare.condominium.hibernate.HibernateUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public abstract class DAO<T> {

    private final Class<T> persistedClass;

    protected DAO(Class<T> persistedClass) {
        this.persistedClass = persistedClass;
    }

    public T create(T entity) throws Exception {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.persist(entity);
            session.flush();

            transaction.commit();

            return entity;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(e);
        } finally {
            session.close();
        }
    }

    public List<T> readAll() throws Exception {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<T> entities;
        try {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<T> query = cb.createQuery(persistedClass);
            query.from(persistedClass);
            entities = session.createQuery(query).getResultList();
            return entities;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            session.close();
        }
    }

    public T readById(int id) throws Exception {
        Session session = HibernateUtils.getSessionFactory().openSession();
        T entity;
        try {
            entity = session.find(persistedClass, id);
            return entity;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            session.close();
        }
    }

    public T update(T entity) throws Exception {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.update(entity);
            session.flush();

            transaction.commit();

            return entity;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(e);
        } finally {
            session.close();
        }
    }

    public void delete(Integer id) throws Exception {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            T entity = session.find(persistedClass, id);

            session.remove(entity);
            session.flush();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(e);
        } finally {
            session.close();
        }
    }

    public void delete(T entity) throws Exception {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            session.remove(entity);
            session.flush();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(e);
        } finally {
            session.close();
        }
    }

}
