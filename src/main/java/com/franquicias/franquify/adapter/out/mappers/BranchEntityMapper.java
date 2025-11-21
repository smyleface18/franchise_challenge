package com.franquicias.franquify.adapter.out.mappers;

import com.franquicias.franquify.adapter.out.entities.BranchEntity;
import com.franquicias.franquify.adapter.out.entities.ProductEntity;
import com.franquicias.franquify.domain.Branch;
import com.franquicias.franquify.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class BranchEntityMapper {

    public static Branch entityToDomain(BranchEntity entity) {
        if (entity == null) return null;

        Branch branch = new Branch();
        branch.setId(entity.getId());
        branch.setName(entity.getName());

        if (entity.getProducts() != null) {
            List<Product> products = new ArrayList<>();
            for (ProductEntity productEntity : entity.getProducts()) {
                products.add(ProductEntityMapper.entityToDomain(productEntity));
            }
            branch.setProducts(products);
        }

        return branch;
    }

    public static Branch entityToDamain(BranchEntity entity) {
        if (entity == null) return null;

        Branch branch = new Branch();
        branch.setId(entity.getId());
        branch.setName(entity.getName());

        return branch;
    }

    public static BranchEntity domainToEntity(Branch domain) {
        if (domain == null) return null;

        BranchEntity entity = new BranchEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());

        if (domain.getProducts() != null) {
            List<ProductEntity> productEntities = new ArrayList<>();
            for (Product product : domain.getProducts()) {
                productEntities.add(ProductEntityMapper.domainToEntity(product));
            }
            entity.setProducts(productEntities);
        }

        return entity;
    }

}
