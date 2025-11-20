package com.franquicias.franquify.app.port.in;


import com.franquicias.franquify.app.dtos.franchise.CreateFranchiseDto;
import com.franquicias.franquify.app.dtos.franchise.UpdateFranchiseDto;
import com.franquicias.franquify.domain.Franchise;
import reactor.core.publisher.Mono;

public interface FranchiseUseCase {
    Mono<Franchise> create(CreateFranchiseDto dto);
    Mono<Franchise> Update(UpdateFranchiseDto dto);
}
