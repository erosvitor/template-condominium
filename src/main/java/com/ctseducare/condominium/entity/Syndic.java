package com.ctseducare.condominium.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "syndics")
public class Syndic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name", length = 80, nullable = false)
    private String name;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "syndics_condominiums",
            joinColumns = { @JoinColumn(name = "id_syndic") },
            inverseJoinColumns = { @JoinColumn(name = "id_condominium") }
    )
    Set<Condominium> condominiums = new HashSet<>();

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

    public Set<Condominium> getCondominiums() {
        return condominiums;
    }

    public void setCondominiums(Set<Condominium> condominiums) {
        this.condominiums = condominiums;
    }

}
