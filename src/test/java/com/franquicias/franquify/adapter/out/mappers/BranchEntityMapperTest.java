package com.franquicias.franquify.adapter.out.mappers;

import com.franquicias.franquify.adapter.out.entities.BranchEntity;
import com.franquicias.franquify.adapter.out.entities.ProductEntity;
import com.franquicias.franquify.domain.Branch;
import com.franquicias.franquify.domain.Product;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class BranchEntityMapperTest {

    @Test
    void testEntityToDomain_withProducts() {

        ProductEntity p1 = new ProductEntity("prod1", 10);
        ProductEntity p2 = new ProductEntity("prod2", 20);
        BranchEntity branchEntity = new BranchEntity();
        branchEntity.setId("branch1");
        branchEntity.setName("Branch 1");
        branchEntity.setProducts(Arrays.asList(p1, p2));

        Branch branch = BranchEntityMapper.entityToDomain(branchEntity);

        assertNotNull(branch);
        assertEquals("branch1", branch.getId());
        assertEquals("Branch 1", branch.getName());
        assertNotNull(branch.getProducts());
        assertEquals(2, branch.getProducts().size());
        assertEquals("prod1", branch.getProducts().get(0).getName());
        assertEquals(10, branch.getProducts().get(0).getStock());
    }

    @Test
    void testEntityToDomain_withoutProducts() {

        BranchEntity branchEntity = new BranchEntity();
        branchEntity.setId("branch2");
        branchEntity.setName("Branch 2");

        Branch branch = BranchEntityMapper.entityToDomain(branchEntity);

        assertNotNull(branch);
        assertEquals("branch2", branch.getId());
        assertEquals("Branch 2", branch.getName());
        assertNull(branch.getProducts());
    }

    @Test
    void testDomainToEntity_withProducts() {
        Product p1 = new Product("prod1", 10);
        Product p2 = new Product("prod2", 20);
        Branch branch = new Branch();
        branch.setId("branch1");
        branch.setName("Branch 1");
        branch.setProducts(Arrays.asList(p1, p2));

        BranchEntity branchEntity = BranchEntityMapper.domainToEntity(branch);

        // Assert
        assertNotNull(branchEntity);
        assertEquals("branch1", branchEntity.getId());
        assertEquals("Branch 1", branchEntity.getName());
        assertNotNull(branchEntity.getProducts());
        assertEquals(2, branchEntity.getProducts().size());
        assertEquals("prod2", branchEntity.getProducts().get(1).getName());
        assertEquals(20, branchEntity.getProducts().get(1).getStock());
    }

    @Test
    void testDomainToEntity_withoutProducts() {

        Branch branch = new Branch();
        branch.setId("branch2");
        branch.setName("Branch 2");

        BranchEntity branchEntity = BranchEntityMapper.domainToEntity(branch);

        assertNotNull(branchEntity);
        assertEquals("branch2", branchEntity.getId());
        assertEquals("Branch 2", branchEntity.getName());
        assertNull(branchEntity.getProducts());
    }
}
