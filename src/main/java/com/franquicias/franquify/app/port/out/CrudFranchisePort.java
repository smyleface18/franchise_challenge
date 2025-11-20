package com.franquicias.franquify.app.port.out;


import com.franquicias.franquify.app.dtos.franchise.CreateFranchiseDto;
import com.franquicias.franquify.app.dtos.franchise.UpdateFranchiseDto;
import com.franquicias.franquify.domain.Franchise;
import reactor.core.publisher.Mono;

public interface CrudFranchisePort {
    Mono<Franchise> create(Franchise franchise);
    Mono<Franchise> Update(Franchise franchise);
}
