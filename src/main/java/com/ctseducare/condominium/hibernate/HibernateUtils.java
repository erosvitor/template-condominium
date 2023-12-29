package com.ctseducare.condominium.hibernate;

import com.ctseducare.condominium.entity.Condominium;
import com.ctseducare.condominium.entity.Syndic;
import com.ctseducare.condominium.entity.Tenant;
import com.ctseducare.condominium.entity.TenantDependent;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {

    private static SessionFactory sessionFactory = null;

    private HibernateUtils() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

            registryBuilder.loadProperties("hibernate.properties");

            StandardServiceRegistry registry = registryBuilder.build();

            try {
                MetadataSources metadataSources = new MetadataSources(registry);
                metadataSources.addAnnotatedClass(Condominium.class);
                metadataSources.addAnnotatedClass(Tenant.class);
                metadataSources.addAnnotatedClass(TenantDependent.class);
                metadataSources.addAnnotatedClass(Syndic.class);

                sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
                StandardServiceRegistryBuilder.destroy(registry);
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

}
