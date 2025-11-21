package com.franquicias.franquify.app.service;

import com.franquicias.franquify.adapter.out.repoAdapters.BranchPersistence;
import com.franquicias.franquify.app.dtos.branch.ChangeBranchDto;
import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import com.franquicias.franquify.app.dtos.product.UpdateProductDto;
import com.franquicias.franquify.app.port.in.BranchUseCase;
import com.franquicias.franquify.domain.Branch;
import com.franquicias.franquify.domain.Product;
import com.franquicias.franquify.domain.exception.EntityNotFoundException;
import com.franquicias.franquify.domain.exception.ProductAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BranchService implements BranchUseCase {

    private final BranchPersistence repo;

    @Autowired
    public BranchService(BranchPersistence repo) {
        this.repo = repo;
    }


    @Override
    public Mono<Branch> changeName(ChangeBranchDto dto) {
        return this.repo.findById(dto.getId())
                .flatMap(branch -> {
                    branch.setName(dto.getName());
                    return this.repo.Update(branch);
                });
    }

    @Override
    public Mono<Branch> findById(String id) {
        return null;
    }

    @Override
    public Mono<Branch> addProduct(CreateProductDto dto) {
        return this.repo.findById(dto.getIdBranch())
                .flatMap(branch -> {
                   boolean exist = existsProductByName(branch.getProducts(), dto.getName());

                   if(exist) return Mono.error(new ProductAlreadyExistsException(dto.getName()));

                   branch.addProduct(new Product(dto.getName(), dto.getStock()));

                    return this.repo.Update(branch);
                });
    }

    @Override
    public Mono<Branch> setStockProduct(UpdateProductDto dto) {
        return this.repo.findById(dto.getIdBranch())
                .flatMap(branch -> {
                    filterProductByName(branch.getProducts(), dto.getName()).setStock(dto.getStock());
                    return this.repo.Update(branch);
                });
    }

    private boolean existsProductByName(List<Product> products, String name) {
        return products.stream()
                .anyMatch(product -> product.getName().equalsIgnoreCase(name));
    }

    private Product filterProductByName(List<Product> products, String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Product","name",name));
    }


}
