package com.franquicias.franquify.adapter.in;

import com.franquicias.franquify.app.dtos.branch.ChangeBranchDto;
import com.franquicias.franquify.app.dtos.branch.CreateBranchDto;
import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import com.franquicias.franquify.app.dtos.product.UpdateProductDto;
import com.franquicias.franquify.app.port.in.BranchUseCase;
import com.franquicias.franquify.domain.Branch;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/branch")
public class BranchController {

    private final BranchUseCase branchUseCase;

    public BranchController(BranchUseCase branchUseCase) {
        this.branchUseCase = branchUseCase;
    }


    @PostMapping("/franchise/{franchiseId}")
    public Mono<Branch> createBranchForFranchise(
            @PathVariable String franchiseId,
            @RequestBody @Valid CreateBranchDto dto
    ) {
        return branchUseCase.createBranchForFranchise(franchiseId, dto);
    }

    @PostMapping("/{branchId}/product")
    public Mono<Branch> addProductToBranch(
            @PathVariable String branchId,
            @RequestBody @Valid CreateProductDto dto
    ) {
        return branchUseCase.addProduct(branchId, dto);
    }

    @DeleteMapping("/{branchId}/product/{productId}")
    public Mono<Branch> deleteProduct(
            @PathVariable String branchId,
            @PathVariable String productId
    ) {
        return branchUseCase.deleteProduct(branchId, productId);
    }

    @PutMapping("/{branchId}/product/{productId}/stock")
    public Mono<Branch> updateStock(
            @PathVariable String branchId,
            @PathVariable String productId,
            @RequestBody @Valid UpdateProductDto dto
    ) {
        return branchUseCase.setStockProduct(dto);
    }

    @PutMapping("/{branchId}/name")
    public Mono<Branch> updateBranchName(
            @PathVariable String branchId,
            @RequestBody @Valid ChangeBranchDto dto
    ) {
        return branchUseCase.changeName(branchId, dto.getName());
    }
}