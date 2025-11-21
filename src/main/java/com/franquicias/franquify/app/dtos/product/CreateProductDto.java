package com.franquicias.franquify.app.dtos.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {

    @NotEmpty(message = "The branch ID cannot be empty.")
    private String idBranch;

    @NotEmpty(message = "The product name cannot be empty.")
    private String name;

    @Min(value = 0, message = "The stock quantity cannot be negative")
    private int stock;
}