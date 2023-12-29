package com.ctseducare.condominium.service;

import com.ctseducare.condominium.dto.CondominiumDTO;

public class CondominiumServiceFindByNameTest {

    public static void main(String[] args) {
        CondominiumDTO dto = new CondominiumDTO();
        dto.setName("Condomínio Rosa dos Ventos");

        CondominiumService service = new CondominiumService();
        try {
            service.create(dto);

            CondominiumDTO returned = service.findByName("Condominio Rosa dos Ventos");
            System.out.println(returned.getId() + ", " + returned.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
