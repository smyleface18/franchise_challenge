package com.franquicias.franquify.adapter.out.mappers;

import com.franquicias.franquify.adapter.out.entities.FranchiseEntity;
import com.franquicias.franquify.domain.Franchise;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class FranchiseEntityMapperTest {

    @Test
    void testEntityToDomain_withBranchIds() {

        FranchiseEntity entity = new FranchiseEntity();
        entity.setId("franchise1");
        entity.setName("Franchise 1");
        entity.setBranchIds(Arrays.asList("b1", "b2"));

        Franchise domain = FranchiseEntityMapper.entityToDomain(entity);

        assertNotNull(domain);
        assertEquals("franchise1", domain.getId());
        assertEquals("Franchise 1", domain.getName());
        assertNotNull(domain.getBranchIds());
        assertEquals(2, domain.getBranchIds().size());
        assertEquals("b1", domain.getBranchIds().get(0));
    }

    @Test
    void testEntityToDomain_withoutBranchIds() {

        FranchiseEntity entity = new FranchiseEntity();
        entity.setId("franchise2");
        entity.setName("Franchise 2");
        entity.setBranchIds(null);

        Franchise domain = FranchiseEntityMapper.entityToDomain(entity);

        assertNotNull(domain);
        assertEquals("franchise2", domain.getId());
        assertEquals("Franchise 2", domain.getName());
        assertNotNull(domain.getBranchIds()); // Debe ser lista vacía
        assertTrue(domain.getBranchIds().isEmpty());
    }

    @Test
    void testDomainToEntity_withBranchIds() {

        Franchise domain = new Franchise();
        domain.setId("franchise1");
        domain.setName("Franchise 1");
        domain.setBranchIds(Arrays.asList("b1", "b2"));

        FranchiseEntity entity = FranchiseEntityMapper.domainToEntity(domain);

        assertNotNull(entity);
        assertEquals("franchise1", entity.getId());
        assertEquals("Franchise 1", entity.getName());
        assertNotNull(entity.getBranchIds());
        assertEquals(2, entity.getBranchIds().size());
        assertEquals("b2", entity.getBranchIds().get(1));
    }

    @Test
    void testDomainToEntity_withoutBranchIds() {

        Franchise domain = new Franchise();
        domain.setId("franchise2");
        domain.setName("Franchise 2");
        domain.setBranchIds(null);


        FranchiseEntity entity = FranchiseEntityMapper.domainToEntity(domain);

        assertNotNull(entity);
        assertEquals("franchise2", entity.getId());
        assertEquals("Franchise 2", entity.getName());
        assertNull(entity.getBranchIds());
    }
}