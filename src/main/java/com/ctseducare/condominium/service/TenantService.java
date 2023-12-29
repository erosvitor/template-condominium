package com.ctseducare.condominium.service;

import com.ctseducare.condominium.dao.TenantDAO;
import com.ctseducare.condominium.dao.TenantDependentDAO;
import com.ctseducare.condominium.dto.TenantDTO;
import com.ctseducare.condominium.dto.TenantDependentDTO;
import com.ctseducare.condominium.entity.Tenant;
import com.ctseducare.condominium.entity.TenantDependent;
import com.ctseducare.condominium.hibernate.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TenantService {

    private final TenantDAO dao;

    TenantService() {
        dao = new TenantDAO();
    }

    public TenantDTO create(TenantDTO dto) throws Exception {
        Tenant tenant = dtoToModel(dto);
        dao.create(tenant);
        dto.setId(tenant.getId());
        return dto;
    }

    private Tenant dtoToModel(TenantDTO dto) {
        Tenant tenant = new Tenant();
        tenant.setName(dto.getName());
        tenant.setIdCondominium(dto.getIdCondominium());

        Set<TenantDependent> dependents = dto.getDependents().stream().map(d -> {
            TenantDependent td = new TenantDependent();
            td.setName(d.getName());
            td.setTenant(tenant);
            return td;
        }).collect(Collectors.toSet());

        tenant.setDependents(dependents);

        return tenant;
    }

    public List<TenantDTO> readAllWithYourDependents() throws Exception {
        List<Tenant> tenants = dao.readAllWithYourDependents();
        return tenants.stream().map(this::modelToDto).toList();
    }

    private TenantDTO modelToDto(Tenant model) {
        TenantDTO tenant = new TenantDTO();
        tenant.setId(model.getId());
        tenant.setName(model.getName());

        List<TenantDependentDTO> dependents = model.getDependents().stream().map(d -> {
            TenantDependentDTO td = new TenantDependentDTO();
            td.setId(d.getId());
            td.setName(d.getName());
            return td;
        }).toList();

        tenant.setDependents(dependents);

        return tenant;
    }

    public TenantDTO update(TenantDTO dto) throws Exception {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Tenant tenant = new Tenant();
            tenant.setId(dto.getId());
            tenant.setName(dto.getName());
            tenant.setIdCondominium(dto.getIdCondominium());
            dao.updateWithoutTransaction(tenant, session);

            TenantDependentDAO dependentDAO = new TenantDependentDAO();
            List<TenantDependent> dependents = dependentDAO.readByTenantId(tenant.getId());
            for (TenantDependent d : dependents) {
                dependentDAO.deleteWithoutTransaction(d, session);
            }

            for (TenantDependentDTO d : dto.getDependents()) {
                TenantDependent dependent = new TenantDependent();
                dependent.setName(d.getName());
                dependent.setTenant(tenant);
                dependentDAO.insertWithoutTransaction(dependent, session);
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(e);
        } finally {
            session.close();
        }
        return dto;
    }

    public void delete(Integer id) throws Exception {
        dao.delete(id);
    }

}