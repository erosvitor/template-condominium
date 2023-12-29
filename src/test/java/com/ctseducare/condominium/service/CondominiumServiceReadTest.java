package com.ctseducare.condominium.service;

import com.ctseducare.condominium.dto.CondominiumDTO;

import java.util.List;

public class CondominiumServiceReadTest {

    public static void main(String[] args) {
        CondominiumService service = new CondominiumService();
        try {
            List<CondominiumDTO> condominiums = service.readAll();
            condominiums.stream().forEach( c -> {
                System.out.println(c.getId() + ", " + c.getName());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
