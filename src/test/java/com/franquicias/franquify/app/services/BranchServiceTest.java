package com.franquicias.franquify.app.services;


import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import com.franquicias.franquify.app.dtos.product.UpdateProductDto;
import com.franquicias.franquify.app.port.out.CrudBranchPort;
import com.franquicias.franquify.domain.Branch;
import com.franquicias.franquify.domain.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BranchServiceTest {

    @Mock
    CrudBranchPort persistence;

    @InjectMocks
    BranchService branchService;

    @Test
    void changeName_shouldUpdateBranchName() {
        Branch branch = new Branch("Old Name");
        branch.setId("123");

        when(persistence.findById("123")).thenReturn(Mono.just(branch));
        when(persistence.Update(any(Branch.class))).thenAnswer(invocation -> Mono.just(invocation.getArgument(0)));

        StepVerifier.create(branchService.changeName("123", "New Name"))
                .expectNextMatches(b -> b.getName().equals("New Name"))
                .verifyComplete();
    }

    @Test
    void addProduct_shouldAddNewProduct() {
        Branch branch = new Branch("Sucursal 1");
        branch.setProducts(new ArrayList<>());

        CreateProductDto dto = new CreateProductDto("Producto 1", 10);

        when(persistence.findById("123")).thenReturn(Mono.just(branch));
        when(persistence.Update(any(Branch.class))).thenAnswer(invocation -> Mono.just(invocation.getArgument(0)));

        StepVerifier.create(branchService.addProduct("123", dto))
                .expectNextMatches(b -> b.getProducts().size() == 1 &&
                        b.getProducts().get(0).getName().equals("Producto 1") &&
                        b.getProducts().get(0).getStock() == 10)
                .verifyComplete();
    }

    @Test
    void setStockProduct_shouldUpdateProductStock() {
        Product product = new Product("Producto 1", 5);
        Branch branch = new Branch("Sucursal 1");
        branch.setId("123");
        branch.setProducts(new ArrayList<>());
        branch.getProducts().add(product);

        UpdateProductDto dto = new UpdateProductDto("123", "Producto 1", 20);

        when(persistence.findById("123")).thenReturn(Mono.just(branch));
        when(persistence.Update(any(Branch.class))).thenAnswer(invocation -> Mono.just(invocation.getArgument(0)));

        StepVerifier.create(branchService.setStockProduct(dto))
                .expectNextMatches(b -> b.getProducts().get(0).getStock() == 20)
                .verifyComplete();
    }
}