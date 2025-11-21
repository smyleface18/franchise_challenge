package com.franquicias.franquify.app.port.in;

import com.franquicias.franquify.app.dtos.branch.ChangeBranchDto;
import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import com.franquicias.franquify.app.dtos.product.UpdateProductDto;
import com.franquicias.franquify.domain.Branch;
import reactor.core.publisher.Mono;

public interface BranchUseCase {

    Mono<Branch> changeName(ChangeBranchDto dto);
    Mono<Branch> findById(String id);
    Mono<Branch> addProduct(CreateProductDto dto);
    Mono<Branch> setStockProduct(UpdateProductDto dto);
}
