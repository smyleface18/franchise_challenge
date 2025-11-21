package com.franquicias.franquify.app.dtos.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductDto {

    @NotBlank(message = "The product name cannot be empty.")
    private String idBranch;

    @NotBlank(message = "The product name cannot be empty.")
    private String name;

    private int stock;
}
