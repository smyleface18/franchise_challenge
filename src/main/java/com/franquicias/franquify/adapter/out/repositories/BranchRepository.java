package com.franquicias.franquify.adapter.out.repositories;

import com.franquicias.franquify.adapter.out.entities.BranchEntity;
import com.franquicias.franquify.adapter.out.entities.ProductEntity;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


public interface BranchRepository extends ReactiveMongoRepository<BranchEntity,String> {

    @Aggregation(pipeline = {
            "{ $match: { _id: ObjectId(?0) } }",
            "{ $project: { " +
                    "hasProducts: { $gt: [ { $size: { $ifNull: ['$products', []] } }, 0 ] }, " +
                    "products: 1 " +
                    "} }",
            "{ $match: { hasProducts: true } }",
            "{ $unwind: '$products' }",
            "{ $sort: { 'products.stock': -1 } }",
            "{ $limit: 1 }",
            "{ $replaceRoot: { newRoot: '$products' } }"
    })
    Mono<ProductEntity> findTopProductByStock(String branchId);

}