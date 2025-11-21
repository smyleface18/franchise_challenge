package com.franquicias.franquify.app.port.in;

import com.franquicias.franquify.app.dtos.branch.ChangeBranchDto;
import com.franquicias.franquify.app.dtos.branch.CreateBranchDto;
import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import com.franquicias.franquify.app.dtos.product.UpdateProductDto;
import com.franquicias.franquify.domain.Branch;
import reactor.core.publisher.Mono;

public interface BranchUseCase {

    Mono<Branch> changeName(String branchId,String newName);
    Mono<Branch> findById(String id);
    Mono<Branch> addProduct(String branchId,CreateProductDto dto);
    Mono<Branch> setStockProduct(UpdateProductDto dto);
    Mono<Branch> create(CreateBranchDto dto);
    Mono<Branch> createBranchForFranchise(String franchiseId,CreateBranchDto dto);
    Mono<Branch> deleteProduct(String branchId, String ProductName);
}
