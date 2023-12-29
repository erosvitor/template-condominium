package com.ctseducare.condominium.dao;

import com.ctseducare.condominium.entity.Condominium;
import com.ctseducare.condominium.hibernate.HibernateUtils;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

public class CondominiumDAO extends DAO<Condominium> {

    public CondominiumDAO() {
        super(Condominium.class);
    }

    public Condominium findByName(String name) {
        String hql = "FROM Condominium WHERE name = :name";

        Session session = HibernateUtils.getSessionFactory().openSession();

        TypedQuery<Condominium> typedQuery = session.createQuery(hql, Condominium.class);
        typedQuery.setParameter("name", name);

        Condominium condominium = typedQuery.getSingleResult();

        session.close();

        return condominium;
    }

}
