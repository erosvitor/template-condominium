package com.ctseducare.condominium.service;

import com.ctseducare.condominium.dto.CondominiumDTO;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CondominiumServiceTest {

    private static CondominiumService service;

    @BeforeAll
    public static void setup() {
        service = new CondominiumService();
    }

    @Test
    @Order(1)
    public void create() throws Exception {
        CondominiumDTO dtoToCreate = new CondominiumDTO();
        dtoToCreate.setName("Condomínio Jatobá");

        CondominiumDTO dtoToCreated = service.create(dtoToCreate);
        Assertions.assertNotNull(dtoToCreated.getId());
    }

}
