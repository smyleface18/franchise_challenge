package com.franquicias.franquify.adapter.out.repoAdapters;

import com.franquicias.franquify.adapter.out.repositories.FranchiseRepository;
import com.franquicias.franquify.app.port.out.CrudFranchisePort;
import com.franquicias.franquify.domain.Franchise;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class FranchisePersistenceAdapter implements CrudFranchisePort {

    private final FranchiseRepository repo;

    public FranchisePersistenceAdapter(FranchiseRepository repo) {
        this.repo = repo;
    }


    @Override
    public Mono<Franchise> create(Franchise franchise) {
        return null;
    }

    @Override
    public Mono<Franchise> Update(Franchise franchise) {
        return null;
    }
}
