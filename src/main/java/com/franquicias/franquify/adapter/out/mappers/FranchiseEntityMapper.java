package com.franquicias.franquify.adapter.out.mappers;

import com.franquicias.franquify.adapter.out.entities.FranchiseEntity;
import com.franquicias.franquify.domain.Branch;
import com.franquicias.franquify.domain.Franchise;

import java.util.ArrayList;
import java.util.Collections;

public class FranchiseEntityMapper {

    public static FranchiseEntity domainToEntity(Franchise domain) {
        return new FranchiseEntity(
                domain.getId(),
                domain.getName(),
                domain.getBranchIds()
        );
    }

    public static Franchise entityToDomain(FranchiseEntity entity) {
        Franchise franchise = new Franchise();
        franchise.setId(entity.getId());
        franchise.setName(entity.getName());
        franchise.setBranchIds(
                entity.getBranchIds() != null
                        ? new ArrayList<>(entity.getBranchIds()) // ✅ mutable
                        : new ArrayList<>()
        );
        return franchise;
    }
}
