package com.franquicias.franquify.adapter.in;

import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import com.franquicias.franquify.app.service.ProductService;
import com.franquicias.franquify.domain.Product;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody @Valid CreateProductDto dto){
        return productService.create(dto);
    }

}
