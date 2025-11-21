package com.franquicias.franquify.adapter.in;

import com.franquicias.franquify.app.dtos.branch.CreateBranchDto;
import com.franquicias.franquify.app.dtos.franchise.BranchTopProductDto;
import com.franquicias.franquify.app.dtos.franchise.ChangeFranchiseNameDto;
import com.franquicias.franquify.app.dtos.franchise.CreateFranchiseDto;
import com.franquicias.franquify.app.port.in.FranchiseUseCase;
import com.franquicias.franquify.domain.Franchise;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/franchise")
public class FranchiseController {
    private final FranchiseUseCase franchiseUseCase;

    public FranchiseController(FranchiseUseCase franchiseUseCase) {
        this.franchiseUseCase = franchiseUseCase;
    }

    @PostMapping
    public Mono<Franchise> createFranchise(@RequestBody CreateFranchiseDto dto) {
        return franchiseUseCase.create(dto);
    }

    @PostMapping("/{idFranchise}/branch")
    public Mono<Franchise> addBranchToFranchise(
            @PathVariable String idFranchise,
            @RequestBody CreateBranchDto dto
    ) {
        return franchiseUseCase.addBranch(idFranchise,dto);
    }

    @PutMapping("/{idFranchise}/name")
    public Mono<Franchise> changeFranchiseName(
            @PathVariable String idFranchise,
            @RequestBody @Valid ChangeFranchiseNameDto dto
    ) {
        return franchiseUseCase.changeName(idFranchise,dto);
    }

    @GetMapping
    public Flux<Franchise> getAll(){
        return franchiseUseCase.getAll();
    }
    @GetMapping("/{id}/top-products")
    public Flux<BranchTopProductDto> getTopProducts(@PathVariable String id) {
        return this.franchiseUseCase.getTopProductByBranch(id);
    }
}
