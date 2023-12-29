package com.ctseducare.condominium.service;

import com.ctseducare.condominium.dto.TenantDTO;
import com.ctseducare.condominium.dto.TenantDependentDTO;

public class TenantServiceUpdateTest {

    public static void main(String[] args) {
        TenantDependentDTO td1 = new TenantDependentDTO();
        td1.setName("Dependente 1");
        TenantDependentDTO td2 = new TenantDependentDTO();
        td2.setName("Dependente 2");

        TenantDTO tenantNew = new TenantDTO();
        tenantNew.setName("Titular");
        tenantNew.getDependents().add(td1);
        tenantNew.getDependents().add(td2);
        tenantNew.setIdCondominium(1);  // 1 - DEFAULT

        TenantService service = new TenantService();
        try {
            TenantDTO tenantSaved = service.create(tenantNew);

            tenantSaved.setName("Titular Master");
            TenantDependentDTO td = new TenantDependentDTO();
            td.setName("Dependente 3");
            tenantSaved.getDependents().add(td);

            service.update(tenantSaved);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
