package com.franquicias.franquify.app.dtos.branch;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChangeBranchDto {

    @NotBlank( message = "no puede ser emtyp")
    private String name;
}