package com.franquicias.franquify.app.port.in;


import com.franquicias.franquify.app.dtos.branch.CreateBranchDto;
import com.franquicias.franquify.app.dtos.franchise.BranchTopProductDto;
import com.franquicias.franquify.app.dtos.franchise.ChangeFranchiseNameDto;
import com.franquicias.franquify.app.dtos.franchise.CreateFranchiseDto;
import com.franquicias.franquify.domain.Franchise;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FranchiseUseCase {
    Mono<Franchise> create(CreateFranchiseDto dto);
    Mono<Franchise> changeName(String idFranchise,ChangeFranchiseNameDto dto);
    Mono<Franchise> addBranch(String idFranchise ,CreateBranchDto dto);
    Flux<Franchise> getAll();
    Flux<BranchTopProductDto>  getTopProductByBranch(String idFranchise);
}
