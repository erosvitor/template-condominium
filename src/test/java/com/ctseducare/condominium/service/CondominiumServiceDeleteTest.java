package com.ctseducare.condominium.service;

import com.ctseducare.condominium.dto.CondominiumDTO;

public class CondominiumServiceDeleteTest {

    public static void main(String[] args) {
        CondominiumDTO dto = new CondominiumDTO();
        dto.setId(3);
        dto.setName("Condomínio Residencial Jatobá");

        CondominiumService service = new CondominiumService();
        try {
            service.delete(dto);
            System.out.println("Excluído!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}