package com.franquicias.franquify.app.service;

import com.franquicias.franquify.app.dtos.branch.CreateBranchDto;
import com.franquicias.franquify.app.dtos.franchise.ChangeFranchiseNameDto;
import com.franquicias.franquify.app.dtos.franchise.CreateFranchiseDto;
import com.franquicias.franquify.app.port.in.BranchUseCase;
import com.franquicias.franquify.app.port.in.FranchiseUseCase;
import com.franquicias.franquify.app.port.out.CrudFranchisePort;
import com.franquicias.franquify.domain.Branch;
import com.franquicias.franquify.domain.Franchise;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class FranchiseService implements FranchiseUseCase {

    private final CrudFranchisePort persistence;
    private final BranchUseCase branchUseCase;

    public FranchiseService(BranchUseCase branchUseCase, CrudFranchisePort persistence) {
        this.branchUseCase = branchUseCase;
        this.persistence = persistence;
    }

    @Override
    public Mono<Franchise> create(CreateFranchiseDto dto) {
        Mono<List<String>> branchIdsMono = Flux.fromIterable(dto.getBranches())
                .flatMap(branchUseCase::create)
                .map(Branch::getId)
                .collectList();

        return branchIdsMono.flatMap(branchIds -> {
            Franchise franchise = new Franchise();
            franchise.setName(dto.getName());
            franchise.setBranchIds(new ArrayList<>());
            branchIds.forEach(franchise.getBranchIds()::add);

            return this.persistence.create(franchise);
        });
    }


    @Override
    public Mono<Franchise> changeName(String idFranchise,ChangeFranchiseNameDto dto) {
        return this.persistence.findById(idFranchise)
                .flatMap(franchise -> {
                    franchise.setName(dto.getName());
                    return this.persistence.update(franchise);
                });
    }

    @Override
    public Mono<Franchise> addBranch(String idFranchise, CreateBranchDto dto) {
        return this.persistence.findById(idFranchise)
                .flatMap( franchise -> this.branchUseCase.create(dto)
                        .flatMap(branch -> {
                            franchise.getBranchIds().add(branch.getId());
                            return this.persistence.update(franchise);
                        }));
    }

    @Override
    public Flux<Franchise> getAll() {
        return this.persistence.getAll();
    }
}
