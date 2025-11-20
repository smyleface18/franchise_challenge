package com.franquicias.franquify.app.port;

import com.franquicias.franquify.app.dtos.branch.CreateBranchDto;
import com.franquicias.franquify.app.dtos.branch.UpdateBranchDto;
import com.franquicias.franquify.domain.Branch;
import reactor.core.publisher.Mono;

public interface CrudBranchPort {

    Mono<Branch> create(CreateBranchDto dto);
    Mono<Branch> Update(UpdateBranchDto dto);
}
