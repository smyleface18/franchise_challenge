package com.franquicias.franquify.adapter.out.persistence;

import com.franquicias.franquify.adapter.out.mappers.FranchiseEntityMapper;
import com.franquicias.franquify.adapter.out.repositories.BranchRepository;
import com.franquicias.franquify.adapter.out.repositories.FranchiseRepository;
import com.franquicias.franquify.app.port.out.CrudFranchisePort;
import com.franquicias.franquify.domain.Franchise;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class FranchisePersistenceAdapter implements CrudFranchisePort {

    private final FranchiseRepository FranchiseRepo;
    private final BranchRepository  branchRepo;

    public FranchisePersistenceAdapter(BranchRepository branchRepo, FranchiseRepository franchiseRepo) {
        this.branchRepo = branchRepo;
        FranchiseRepo = franchiseRepo;
    }

    @Override
    public Mono<Franchise> create(Franchise franchise) {
        return this.FranchiseRepo.save(FranchiseEntityMapper.domainToEntity(franchise))
                .map(FranchiseEntityMapper::entityToDomain);
    }

    @Override
    public Mono<Franchise> update(Franchise franchise) {
        return this.FranchiseRepo.save(FranchiseEntityMapper.domainToEntity(franchise))
                .map(FranchiseEntityMapper::entityToDomain);
    }

    @Override
    public Mono<Franchise> findById(String id) {
        return this.FranchiseRepo.findById(id)
                .map(FranchiseEntityMapper::entityToDomain);
    }

    @Override
    public Flux<Franchise> getAll() {
        return this.FranchiseRepo.findAll()
                .map(FranchiseEntityMapper::entityToDomain);
    }

}
