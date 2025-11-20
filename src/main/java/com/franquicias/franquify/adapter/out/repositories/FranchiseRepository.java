package com.franquicias.franquify.adapter.out.repositories;

import com.franquicias.franquify.adapter.out.entities.FranchiseEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FranchiseRepository extends ReactiveMongoRepository<FranchiseEntity,String> {
}
