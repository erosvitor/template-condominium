package com.ctseducare.condominium.dao;

import com.ctseducare.condominium.entity.TenantDependent;
import com.ctseducare.condominium.hibernate.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class TenantDependentDAO extends DAO<TenantDependent> {

    public TenantDependentDAO() { super(TenantDependent.class); }

    public List<TenantDependent> readByTenantId(Integer idTenant) throws Exception {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<TenantDependent> dependents;
        try {
            dependents = session.createQuery("FROM TenantDependent WHERE tenant.id = " + idTenant, TenantDependent.class).list();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            session.close();
        }
        return dependents;
    }

    public TenantDependent insertWithoutTransaction(TenantDependent dependent, Session session) throws Exception {
        try {
            session.persist(dependent);
            session.flush();
            return dependent;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public TenantDependent deleteWithoutTransaction(TenantDependent dependent, Session session) throws Exception {
        try {
            session.remove(dependent);
            session.flush();
            return dependent;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}