package com.ctseducare.condominium.service;

import com.ctseducare.condominium.dao.SyndicDAO;
import com.ctseducare.condominium.dto.SyndicDTO;
import com.ctseducare.condominium.entity.Condominium;
import com.ctseducare.condominium.entity.Syndic;

import java.util.Set;
import java.util.stream.Collectors;

public class SyndicService {

    private final SyndicDAO dao;

    SyndicService() {
        dao = new SyndicDAO();
    }

    public SyndicDTO create(SyndicDTO dto) throws Exception {
        Syndic syndic = dtoToModel(dto);
        dao.create(syndic);
        dto.setId(syndic.getId());
        return dto;
    }

    private Syndic dtoToModel(SyndicDTO dto) {
        Syndic syndic = new Syndic();
        syndic.setName(dto.getName());

        Set<Condominium> condominiums = dto.getCondominiums().stream().map(c -> {
            Condominium c2 = new Condominium();
            c2.setName(c.getName());
            return c2;
        }).collect(Collectors.toSet());

        syndic.setCondominiums(condominiums);

        return syndic;
    }

}
