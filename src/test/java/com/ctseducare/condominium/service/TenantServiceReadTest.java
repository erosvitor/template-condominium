package com.ctseducare.condominium.service;

import com.ctseducare.condominium.dto.TenantDTO;

import java.util.List;

public class TenantServiceReadTest {

    public static void main(String[] args) {
        TenantService service = new TenantService();
        try {
            List<TenantDTO> tenants = service.readAllWithYourDependents();
            tenants.forEach(t -> {
                System.out.println(t.getId() + "," + t.getName());
                t.getDependents().forEach(d -> System.out.println("--> " + d.getName()));
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
