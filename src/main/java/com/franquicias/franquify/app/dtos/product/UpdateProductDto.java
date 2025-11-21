package com.franquicias.franquify.app.dtos.product;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductDto {


    @NotBlank(message = "The branch ID cannot be empty.")
    private String idBranch;

    @NotBlank(message = "The product name cannot be empty.")
    private String name;

    @Schema(
            description = "Cantidad en stock del producto",
            example = "25",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    private int stock;
}