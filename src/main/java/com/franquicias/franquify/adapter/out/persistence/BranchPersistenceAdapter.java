package com.franquicias.franquify.adapter.out.persistence;

import com.franquicias.franquify.adapter.out.mappers.BranchEntityMapper;
import com.franquicias.franquify.adapter.out.mappers.ProductEntityMapper;
import com.franquicias.franquify.adapter.out.repositories.BranchRepository;
import com.franquicias.franquify.app.port.out.CrudBranchPort;
import com.franquicias.franquify.domain.Branch;
import com.franquicias.franquify.domain.Product;
import com.franquicias.franquify.domain.exception.EntityNotFoundException;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class BranchPersistenceAdapter  implements CrudBranchPort {

    private final BranchRepository repo;

    public BranchPersistenceAdapter (BranchRepository repo) {
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

    @Override
    public Mono<Product> findTopProductByStock(String branchId) {
        return this.repo.findTopProductByStock(branchId)
                .map(ProductEntityMapper::entityToDomain);
    }
}
