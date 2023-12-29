package com.ctseducare.condominium.dao;

import com.ctseducare.condominium.entity.Tenant;
import com.ctseducare.condominium.hibernate.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class TenantDAO extends DAO<Tenant> {

    public TenantDAO() { super(Tenant.class); }

    public List<Tenant> readAllWithYourDependents() throws Exception {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Tenant> tenants;
        try {
            tenants = session.createQuery("FROM Tenant t JOIN FETCH t.dependents", Tenant.class).list();
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            session.close();
        }
        return tenants;
    }

    public Tenant updateWithoutTransaction(Tenant tenant, Session session) throws Exception {
        try {
            session.update(tenant);
            session.flush();
            return tenant;
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

}