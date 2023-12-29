package com.ctseducare.condominium.dto;

import java.util.ArrayList;
import java.util.List;

public class SyndicDTO {

    private Integer id;
    private String name;
    private List<CondominiumDTO> condominiums = new ArrayList<>(0);

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

    public List<CondominiumDTO> getCondominiums() {
        return condominiums;
    }

    public void setCondominiums(List<CondominiumDTO> condominiums) {
        this.condominiums = condominiums;
    }

}
