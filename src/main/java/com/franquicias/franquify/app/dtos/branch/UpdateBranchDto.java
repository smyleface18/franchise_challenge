package com.franquicias.franquify.app.dtos.branch;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBranchDto {
    private String id;
    private String name;
}
