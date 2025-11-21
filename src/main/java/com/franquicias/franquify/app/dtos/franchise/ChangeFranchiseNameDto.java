package com.franquicias.franquify.app.dtos.franchise;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangeFranchiseNameDto {


    @NotBlank(message = "The franchise name cannot be empty.")
    private String name;
}
