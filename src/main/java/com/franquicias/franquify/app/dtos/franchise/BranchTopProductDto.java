package com.franquicias.franquify.app.dtos.franchise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BranchTopProductDto {
    private String branchName;
    private String productName;
    private int stock;


}