package com.franquicias.franquify.app.mappers;

import com.franquicias.franquify.adapter.out.entities.ProductEntity;
import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import com.franquicias.franquify.app.dtos.product.UpdateProductDto;
import com.franquicias.franquify.domain.Product;

public class ProductDtoMapper {

    public static Product createDtoToDomain(CreateProductDto dto) {
        if (dto == null) return null;
        return new Product(dto.getName(), dto.getStock());
    }

    public static  CreateProductDto productEntityToDto(Product product) {
        if (product == null) {
            return null;
        }

        CreateProductDto dto = new CreateProductDto();
        dto.setName(product.getName());
        dto.setStock(product.getStock());

        return dto;
    }

    public static  Product productDtoToEntity(CreateProductDto dto) {
        if (dto == null) {
            return null;
        }

        return new Product(
                dto.getName(),
                dto.getStock()
        );
    }

}
