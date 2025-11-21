package com.franquicias.franquify.app.mappers;


import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import com.franquicias.franquify.domain.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ProductDtoMapperTest {

    @Test
    void createDtoToDomain_shouldMapDtoToProduct() {
        CreateProductDto dto = new CreateProductDto("Product 1", 10);

        Product product = ProductDtoMapper.createDtoToDomain(dto);

        assertNotNull(product);
        assertEquals("Product 1", product.getName());
        assertEquals(10, product.getStock());
    }

    @Test
    void createDtoToDomain_shouldReturnNullIfDtoIsNull() {
        Product product = ProductDtoMapper.createDtoToDomain(null);
        assertNull(product);
    }

    @Test
    void productEntityToDto_shouldMapProductToDto() {
        Product product = new Product("Product 1", 10);

        CreateProductDto dto = ProductDtoMapper.productEntityToDto(product);

        assertNotNull(dto);
        assertEquals("Product 1", dto.getName());
        assertEquals(10, dto.getStock());
    }

    @Test
    void productEntityToDto_shouldReturnNullIfProductIsNull() {
        CreateProductDto dto = ProductDtoMapper.productEntityToDto(null);
        assertNull(dto);
    }

    @Test
    void productDtoToEntity_shouldMapDtoToProduct() {
        CreateProductDto dto = new CreateProductDto("Product 1", 10);

        Product product = ProductDtoMapper.productDtoToEntity(dto);

        assertNotNull(product);
        assertEquals("Product 1", product.getName());
        assertEquals(10, product.getStock());
    }

    @Test
    void productDtoToEntity_shouldReturnNullIfDtoIsNull() {
        Product product = ProductDtoMapper.productDtoToEntity(null);
        assertNull(product);
    }
}