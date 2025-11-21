package com.franquicias.franquify.app.dtos.branch;


import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBranchDto {

    @NotEmpty(message = "The Franchise ID cannot be empty.")
    private String idFranchise;

    @NotEmpty(message = "The branch name cannot be empty.")
    private String name;

    private List<CreateProductDto> products;
}