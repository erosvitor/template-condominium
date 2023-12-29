package com.ctseducare.condominium.service;

import com.ctseducare.condominium.dto.TenantDTO;
import com.ctseducare.condominium.dto.TenantDependentDTO;

public class TenantServiceCreateTest {

    public static void main(String[] args) {
        TenantDependentDTO td1 = new TenantDependentDTO();
        td1.setName("Daniele");
        TenantDependentDTO td2 = new TenantDependentDTO();
        td2.setName("Talita");

        TenantDTO t = new TenantDTO();
        t.setName("Eros Vitor");
        t.getDependents().add(td1);
        t.getDependents().add(td2);
        t.setIdCondominium(1);  // 1 - DEFAULT

        TenantService service = new TenantService();
        try {
            service.create(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}