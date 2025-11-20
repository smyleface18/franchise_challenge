package com.franquicias.franquify.adapter.out.repositories;

import com.franquicias.franquify.adapter.out.entities.ProductEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<ProductEntity, String> {
}
