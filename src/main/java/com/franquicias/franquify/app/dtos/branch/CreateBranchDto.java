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

    @NotEmpty(message = "El nombre de la sucursal no puede estar vacío")
    private String name;

    private List<CreateProductDto> products;
}