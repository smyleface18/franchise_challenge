package com.franquicias.franquify.app.port;

import com.franquicias.franquify.adapter.out.entities.FranchiseEntity;
import com.franquicias.franquify.app.dtos.franchise.CreateFranchiseDto;
import com.franquicias.franquify.app.dtos.franchise.UpdateFranchiseDto;
import reactor.core.publisher.Mono;

public interface CrudFranchisePort {
    Mono<FranchiseEntity> create(CreateFranchiseDto dto);
    Mono<FranchiseEntity> Update(UpdateFranchiseDto dto);
}
