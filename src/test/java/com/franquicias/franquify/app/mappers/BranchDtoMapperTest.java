package com.franquicias.franquify.app.mappers;

import com.franquicias.franquify.app.dtos.branch.CreateBranchDto;
import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import com.franquicias.franquify.domain.Branch;
import com.franquicias.franquify.domain.Product;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.bson.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class BranchDtoMapperTest {

    @Test
    void createDtotoDomain_shouldMapDtoToBranch() {
        CreateProductDto p1 = new CreateProductDto("Product 1", 10);
        CreateProductDto p2 = new CreateProductDto("Product 2", 5);

        CreateBranchDto dto = new CreateBranchDto();
        dto.setName("Sucursal 1");
        dto.setProducts(Arrays.asList(p1, p2));

        Branch branch = BranchDtoMapper.CreateDtotoDomain(dto);

        assertNotNull(branch);
        assertEquals("Sucursal 1", branch.getName());
        assertNotNull(branch.getProducts());
        assertEquals(2, branch.getProducts().size());
        assertEquals("Product 1", branch.getProducts().get(0).getName());
        assertEquals(10, branch.getProducts().get(0).getStock());
        assertEquals("Product 2", branch.getProducts().get(1).getName());
        assertEquals(5, branch.getProducts().get(1).getStock());
    }

    @Test
    void createDtotoDomain_shouldReturnNullIfDtoIsNull() {
        Branch branch = BranchDtoMapper.CreateDtotoDomain(null);
        assertNull(branch);
    }

    @Test
    void entityToDomainWithoutProducts_shouldMapBranchWithoutProducts() {
        Product product = new Product("Product 1", 10);
        Branch branch = new Branch();
        branch.setId("b1");
        branch.setName("Sucursal 1");
        branch.setProducts(Arrays.asList(product));

        Branch mapped = BranchDtoMapper.entityToDomainWithoutProducts(branch);

        assertNotNull(mapped);
        assertEquals("b1", mapped.getId());
        assertEquals("Sucursal 1", mapped.getName());
        assertNull(mapped.getProducts());
    }

    @Test
    void domaintoDto_shouldMapBranchToDto() {
        Product p1 = new Product("Product 1", 10);
        Product p2 = new Product("Product 2", 5);

        Branch branch = new Branch();
        branch.setName("Sucursal 1");
        branch.setProducts(Arrays.asList(p1, p2));

        CreateBranchDto dto = BranchDtoMapper.DomaintoDto(branch);

        assertNotNull(dto);
        assertEquals("Sucursal 1", dto.getName());
        assertNotNull(dto.getProducts());
        assertEquals(2, dto.getProducts().size());
        assertEquals("Product 1", dto.getProducts().get(0).getName());
        assertEquals(10, dto.getProducts().get(0).getStock());
        assertEquals("Product 2", dto.getProducts().get(1).getName());
        assertEquals(5, dto.getProducts().get(1).getStock());
    }

    @Test
    void domaintoDto_shouldReturnNullIfBranchIsNull() {
        CreateBranchDto dto = BranchDtoMapper.DomaintoDto(null);
        assertNull(dto);
    }
}