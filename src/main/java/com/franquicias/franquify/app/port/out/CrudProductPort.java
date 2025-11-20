package com.franquicias.franquify.app.port.out;

import com.franquicias.franquify.adapter.out.entities.ProductEntity;
import com.franquicias.franquify.domain.Product;
import reactor.core.publisher.Mono;

public interface CrudProductPort {

    Mono<Product> create(Product product);
    Mono<Product> update(Product product);
    Mono<Product> findById(String id);
}
