package com.franquicias.franquify.adapter.out.mappers;

import com.franquicias.franquify.adapter.out.entities.ProductEntity;
import com.franquicias.franquify.domain.Product;

public class ProductEntityMapper {

    public static Product entityToDomain(ProductEntity entity) {
        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());
        product.setStock(entity.getStock());
        return product;
    }

    public static ProductEntity domainToEntity(Product domain) {
        ProductEntity entity = new ProductEntity();
        entity.setName(domain.getName());
        entity.setStock(domain.getStock());
        entity.setId(domain.getId());
        return entity;
    }
}
