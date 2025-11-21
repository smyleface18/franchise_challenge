package com.franquicias.franquify.adapter.out.repoAdapters;

import com.franquicias.franquify.adapter.out.mappers.BranchEntityMapper;
import com.franquicias.franquify.adapter.out.repositories.BranchRepository;
import com.franquicias.franquify.adapter.out.repositories.ProductRepository;
import com.franquicias.franquify.app.port.out.CrudBranchPort;
import com.franquicias.franquify.domain.Branch;
import com.franquicias.franquify.domain.exception.EntityNotFoundException;
import reactor.core.publisher.Mono;

public class BranchPersistence implements CrudBranchPort {

    private final BranchRepository repo;

    public BranchPersistence(BranchRepository repo) {
        this.repo = repo;
    }

    @Override
    public Mono<Branch> create(Branch branch) {
        return this.repo.save(BranchEntityMapper.domainToEntity(branch))
                .map(BranchEntityMapper::entityToDomain);
    }

    @Override
    public Mono<Branch> Update(Branch branch) {
        return this.repo.save(BranchEntityMapper.domainToEntity(branch))
                .map(BranchEntityMapper::entityToDomain);
    }

    @Override
    public Mono<Branch> findById(String id) {
        return this.repo.findById(id)
                .map(BranchEntityMapper::entityToDomain)
                .switchIfEmpty(Mono.error(new EntityNotFoundException("Branch",id)));
    }
}
