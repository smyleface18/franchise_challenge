package com.franquicias.franquify.app.port.out;


import com.franquicias.franquify.domain.Franchise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CrudFranchisePort {
    Mono<Franchise> create(Franchise franchise);
    Mono<Franchise> update(Franchise franchise);
    Mono<Franchise> findById(String id);
    Flux<Franchise> getAll();
}
