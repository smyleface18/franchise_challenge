package com.franquicias.franquify.app.port.in;

import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import com.franquicias.franquify.app.dtos.product.UpdateProductDto;
import com.franquicias.franquify.domain.Product;
import reactor.core.publisher.Mono;

public interface ProductUseCase {

    Mono<Product> create(CreateProductDto dto);
    Mono<Product> update(UpdateProductDto dto);
}
