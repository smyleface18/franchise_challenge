package com.franquicias.franquify.adapter.out.repoAdapters;

import com.franquicias.franquify.adapter.out.entities.ProductEntity;
import com.franquicias.franquify.adapter.out.mappers.ProductEntityMapper;
import com.franquicias.franquify.adapter.out.repositories.ProductRepository;
import com.franquicias.franquify.app.port.out.CrudProductPort;
import com.franquicias.franquify.domain.Product;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ProductPersistence implements CrudProductPort {

    private final ProductRepository repo;

    public ProductPersistence(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Mono<Product> create(Product product) {
        return this.repo.save(ProductEntityMapper.domainToEntity(product))
                .map(ProductEntityMapper::entityToDomain);
    }

    @Override
    public Mono<Product> update(Product product) {
        return this.repo.save(ProductEntityMapper.domainToEntity(product))
                .map(ProductEntityMapper::entityToDomain);
    }

    @Override
    public Mono<Product> findById(String id) {
        return this.repo.findById(id)
                .map(ProductEntityMapper::entityToDomain);
    }
}
