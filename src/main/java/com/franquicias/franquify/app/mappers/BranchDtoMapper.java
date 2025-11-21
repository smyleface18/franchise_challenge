package com.franquicias.franquify.app.mappers;

import com.franquicias.franquify.app.dtos.branch.CreateBranchDto;
import com.franquicias.franquify.app.dtos.product.CreateProductDto;
import com.franquicias.franquify.domain.Branch;
import com.franquicias.franquify.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public class BranchDtoMapper {

    public static Branch CreateDtotoDomain(CreateBranchDto dto) {
        if (dto == null) {
            return null;
        }

        Branch branch = new Branch();
        branch.setName(dto.getName());

        if (dto.getProducts() != null && !dto.getProducts().isEmpty()) {
            List<Product> products = dto.getProducts()
                    .stream()
                    .map(ProductDtoMapper::productDtoToEntity)
                    .collect(Collectors.toList());
            branch.setProducts(products);
        }

        return branch;
    }


    public static Branch entityToDomainWithoutProducts(Branch branch) {
        return new Branch(branch.getId(), branch.getName());
    }


    public static CreateBranchDto DomaintoDto(Branch branch) {
        if (branch == null) {
            return null;
        }

        CreateBranchDto dto = new CreateBranchDto();
        dto.setName(branch.getName());

        if (branch.getProducts() != null && !branch.getProducts().isEmpty()) {
            List<CreateProductDto> products = branch.getProducts()
                    .stream()
                    .map(ProductDtoMapper::productEntityToDto)
                    .collect(Collectors.toList());
            dto.setProducts(products);
        }

        return dto;
    }


}
