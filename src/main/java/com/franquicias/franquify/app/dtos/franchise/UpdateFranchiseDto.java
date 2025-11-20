package com.franquicias.franquify.app.dtos.franchise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFranchiseDto {

    private String id;
    private String name;
}
