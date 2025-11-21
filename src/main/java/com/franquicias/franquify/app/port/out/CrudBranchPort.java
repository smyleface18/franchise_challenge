package com.franquicias.franquify.app.port.out;

import com.franquicias.franquify.adapter.out.entities.ProductEntity;
import com.franquicias.franquify.domain.Branch;
import com.franquicias.franquify.domain.Product;
import reactor.core.publisher.Mono;

public interface CrudBranchPort {

    Mono<Branch> create(Branch branch);
    Mono<Branch> Update(Branch branch);
    Mono<Branch> findById(String id);
    Mono<Product> findTopProductByStock(String branchId);
}
