package com.ctseducare.condominium.service;

import com.ctseducare.condominium.dto.CondominiumDTO;
import com.ctseducare.condominium.dto.SyndicDTO;

public class SyndicServiceCreateTest {

    public static void main(String[] args) {
        CondominiumDTO c1 = new CondominiumDTO();
        c1.setName("Condominio 1");

        SyndicDTO s = new SyndicDTO();
        s.setName("Eros Vitor");
        s.getCondominiums().add(c1);

        SyndicService service = new SyndicService();
        try {
            service.create(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
