package com.franquicias.franquify.adapter.out.repoAdapters;

import com.franquicias.franquify.adapter.out.repositories.BranchRepository;
import com.franquicias.franquify.adapter.out.repositories.ProductRepository;
import com.franquicias.franquify.app.port.out.CrudBranchPort;
import com.franquicias.franquify.domain.Branch;
import reactor.core.publisher.Mono;

public class BranchPersistence implements CrudBranchPort {

    private final BranchRepository repo;

    public BranchPersistence(BranchRepository repo) {
        this.repo = repo;
    }

    @Override
    public Mono<Branch> create(Branch branch) {
        return this.repo.save();
    }

    @Override
    public Mono<Branch> Update(Branch branch) {
        return null;
    }
}
