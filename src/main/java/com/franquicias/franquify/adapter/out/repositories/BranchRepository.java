package com.franquicias.franquify.adapter.out.repositories;

import com.franquicias.franquify.adapter.out.entities.BranchEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BranchRepository extends ReactiveMongoRepository<BranchEntity,String> {
}
