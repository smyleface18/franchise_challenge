package com.franquicias.franquify.app.services;


import com.franquicias.franquify.app.dtos.branch.CreateBranchDto;
import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import com.franquicias.franquify.app.dtos.product.UpdateProductDto;
import com.franquicias.franquify.app.mappers.BranchDtoMapper;
import com.franquicias.franquify.app.port.in.BranchUseCase;
import com.franquicias.franquify.app.port.out.CrudBranchPort;
import com.franquicias.franquify.domain.Branch;
import com.franquicias.franquify.domain.Product;
import com.franquicias.franquify.domain.exception.EntityNotFoundException;
import com.franquicias.franquify.domain.exception.ProductAlreadyExistsException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BranchService implements BranchUseCase {

    private final CrudBranchPort persistence;

    public BranchService(CrudBranchPort persistence) {
        this.persistence = persistence;
    }


    @Override
    public Mono<Branch> changeName(String branchId, String newName) {
        return this.persistence.findById(branchId)
                .flatMap(branch -> {
                    branch.setName(newName);
                    return this.persistence.Update(branch);
                });
    }

    @Override
    public Mono<Branch> findById(String id) {
        return null;
    }

    @Override
    public Mono<Branch> addProduct(String branchId,CreateProductDto dto) {
        return this.persistence.findById(branchId)
                .flatMap(branch -> {
                   boolean exist = existsProductByName(branch.getProducts(), dto.getName());

                   if(exist) return Mono.error(new ProductAlreadyExistsException(dto.getName()));

                   branch.getProducts().add(new Product(dto.getName(), dto.getStock()));

                    return this.persistence.Update(branch);
                });
    }

    @Override
    public Mono<Branch> setStockProduct(UpdateProductDto dto) {
        return this.persistence.findById(dto.getIdBranch())
                .flatMap(branch -> {
                    filterProductByName(branch.getProducts(), dto.getName()).setStock(dto.getStock());
                    return this.persistence.Update(branch);
                });
    }

    @Override
    public Mono<Branch> create(CreateBranchDto dto) {
        return this.persistence.create(BranchDtoMapper.CreateDtotoDomain(dto));
    }

    @Override
    public Mono<Branch> createBranchForFranchise(String franchiseId, CreateBranchDto dto) {
        return null;
    }

    @Override
    public Mono<Branch> deleteProduct(String branchId, String productName) {
        return this.persistence.findById(branchId)
                .flatMap(branch -> {
                    boolean exist = existsProductByName(branch.getProducts(), productName);

                    if(exist) return Mono.error(new ProductAlreadyExistsException(productName));

                    branch.getProducts()
                            .removeIf(product -> product.getName().equalsIgnoreCase(productName));

                    return this.persistence.Update(branch);
                });
    }

    private boolean existsProductByName(List<Product> products, String name) {
        if (products == null || products.isEmpty()) {
            return false;
        }
        return products.stream()
                .anyMatch(product -> product.getName().equalsIgnoreCase(name));
    }

    private Product filterProductByName(List<Product> products, String name) {
        if (products == null || products.isEmpty()) {
            throw new EntityNotFoundException("Product", "name", name);
        }
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Product", "name", name));
    }


}
