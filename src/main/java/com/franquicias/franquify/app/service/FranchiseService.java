package com.franquicias.franquify.app.service;

import com.franquicias.franquify.app.dtos.franchise.CreateFranchiseDto;
import com.franquicias.franquify.app.dtos.franchise.UpdateFranchiseDto;
import com.franquicias.franquify.app.port.in.FranchiseUseCase;
import com.franquicias.franquify.domain.Franchise;
import reactor.core.publisher.Mono;

public class FranchiseService implements FranchiseUseCase {



    @Override
    public Mono<Franchise> create(CreateFranchiseDto dto) {
        return null;
    }

    @Override
    public Mono<Franchise> Update(UpdateFranchiseDto dto) {
        return null;
    }
}
