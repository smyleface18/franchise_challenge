package com.franquicias.franquify.app.service;

import com.franquicias.franquify.adapter.out.mappers.ProductEntityMapper;
import com.franquicias.franquify.adapter.out.repoAdapters.ProductPersistence;
import com.franquicias.franquify.adapter.out.repositories.ProductRepository;
import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import com.franquicias.franquify.app.dtos.product.UpdateProductDto;
import com.franquicias.franquify.app.mappers.ProductDtoMapper;
import com.franquicias.franquify.app.port.in.ProductUseCase;
import com.franquicias.franquify.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.resilience.annotation.EnableResilientMethods;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductService implements ProductUseCase {

    private final ProductPersistence repo;
    private final BranchService branchService;

    @Autowired
    public ProductService(BranchService branchService, ProductPersistence repo) {
        this.branchService = branchService;
        this.repo = repo;
    }


    @Override
    public Mono<Product> create(CreateProductDto dto) {
        return null;
    }

    @Override
    public Mono<Product> update(UpdateProductDto dto) {
        return null;
    }

}
