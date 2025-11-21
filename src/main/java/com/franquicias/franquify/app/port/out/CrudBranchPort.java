package com.franquicias.franquify.app.port.out;

import com.franquicias.franquify.domain.Branch;
import reactor.core.publisher.Mono;

public interface CrudBranchPort {

    Mono<Branch> create(Branch branch);
    Mono<Branch> Update(Branch branch);
    Mono<Branch> findById(String id);
}
