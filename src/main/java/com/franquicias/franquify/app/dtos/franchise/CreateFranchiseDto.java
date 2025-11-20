package com.franquicias.franquify.app.dtos.franchise;

import com.franquicias.franquify.app.dtos.branch.CreateBranchDto;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFranchiseDto {

    @NotEmpty(message = "The franchise name cannot be empty.")
    private String name;

    private List<CreateBranchDto> branches;
}
