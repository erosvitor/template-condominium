package com.ctseducare.condominium.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tenants")
public class Tenant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 80, nullable = false)
    private String name;
    @Column(name = "id_condominium", nullable = false)
    private Integer idCondominium;
    @OneToMany(mappedBy = "tenant", cascade = CascadeType.PERSIST)
    private Set<TenantDependent> dependents = new HashSet<>(0);

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

    public Integer getIdCondominium() {
        return idCondominium;
    }

    public void setIdCondominium(Integer idCondominium) {
        this.idCondominium = idCondominium;
    }

    public Set<TenantDependent> getDependents() {
        return dependents;
    }

    public void setDependents(Set<TenantDependent> dependents) {
        this.dependents = dependents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tenant tenant = (Tenant) o;
        return Objects.equals(id, tenant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
