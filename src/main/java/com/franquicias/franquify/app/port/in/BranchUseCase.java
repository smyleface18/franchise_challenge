package com.franquicias.franquify.app.port.in;

import com.franquicias.franquify.app.dtos.branch.CreateBranchDto;
import com.franquicias.franquify.app.dtos.branch.UpdateBranchDto;
import com.franquicias.franquify.domain.Branch;
import reactor.core.publisher.Mono;

public interface BranchUseCase {

    Mono<Branch> create(CreateBranchDto dto);
    Mono<Branch> Update(UpdateBranchDto dto);
}
