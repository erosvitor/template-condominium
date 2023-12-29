package com.ctseducare.condominium.service;

import com.ctseducare.condominium.dto.CondominiumDTO;

public class CondominiumServiceUpdateTest {

    public static void main(String[] args) {
        CondominiumDTO dto = new CondominiumDTO();
        dto.setId(2);
        dto.setName("Condomínio Residencial Jatobá");

        CondominiumService service = new CondominiumService();
        try {
            service.update(dto);
            System.out.println(dto.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}