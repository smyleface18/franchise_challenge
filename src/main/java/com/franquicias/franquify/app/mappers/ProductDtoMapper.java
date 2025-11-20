package com.franquicias.franquify.app.mappers;

import com.franquicias.franquify.adapter.out.entities.ProductEntity;
import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import com.franquicias.franquify.app.dtos.product.UpdateProductDto;
import com.franquicias.franquify.domain.Product;

public class ProductDtoMapper {

    public static Product createDtoToDomain(CreateProductDto dto) {
        return new Product(dto.getName(), dto.getStock());
    }

}
