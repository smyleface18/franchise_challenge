package com.franquicias.franquify.adapter.out.repositories;

import com.franquicias.franquify.adapter.out.entities.BranchEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


public interface BranchRepository extends ReactiveMongoRepository<BranchEntity,String> {
}
