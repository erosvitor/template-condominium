package com.ctseducare.condominium.service;

import com.ctseducare.condominium.dao.CondominiumDAO;
import com.ctseducare.condominium.dto.CondominiumDTO;
import com.ctseducare.condominium.entity.Condominium;

import java.util.List;

public class CondominiumService {

    private final CondominiumDAO dao;

    CondominiumService() {
        dao = new CondominiumDAO();
    }

    public CondominiumDTO create(CondominiumDTO dto) throws Exception {
        Condominium condominium = new Condominium();
        condominium.setName(dto.getName());

        dao.create(condominium);

        dto.setId(condominium.getId());
        return dto;
    }

    public List<CondominiumDTO> readAll() throws Exception {
        List<Condominium> condominiums = dao.readAll();
        return condominiums.stream().map( c -> {
            CondominiumDTO dto = new CondominiumDTO();
            dto.setId(c.getId());
            dto.setName(c.getName());
            return dto;
        }).toList();
    }

    public void update(CondominiumDTO dto) throws Exception {
        Condominium condominium = new Condominium();
        condominium.setId(dto.getId());
        condominium.setName(dto.getName());

        dao.update(condominium);
    }

    public void delete(CondominiumDTO dto) throws Exception {
        Condominium condominium = new Condominium();
        condominium.setId(dto.getId());
        condominium.setName(dto.getName());

        dao.delete(condominium);
    }

    public CondominiumDTO findByName(String name) {
        Condominium condominium = dao.findByName(name);
        CondominiumDTO dto = new CondominiumDTO();
        dto.setId(condominium.getId());
        dto.setName(condominium.getName());

        return dto;
    }

}