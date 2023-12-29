package com.ctseducare.condominium.service;

import com.ctseducare.condominium.dto.CondominiumDTO;

public class CondominiumServiceCreateTest {

    public static void main(String[] args) {
        CondominiumDTO dto = new CondominiumDTO();
        dto.setName("Condomínio Jatobá");

        CondominiumService service = new CondominiumService();
        try {
            service.create(dto);
            System.out.println(dto.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}