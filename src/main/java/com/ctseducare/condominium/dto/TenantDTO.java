package com.ctseducare.condominium.dto;

import java.util.ArrayList;
import java.util.List;

public class TenantDTO {

    private Integer id;
    private String name;
    private List<TenantDependentDTO> dependents = new ArrayList<>(0);
    private Integer idCondominium;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TenantDependentDTO> getDependents() {
        return dependents;
    }

    public void setDependents(List<TenantDependentDTO> dependents) {
        this.dependents = dependents;
    }

    public Integer getIdCondominium() {
        return idCondominium;
    }

    public void setIdCondominium(Integer idCondominium) {
        this.idCondominium = idCondominium;
    }

}