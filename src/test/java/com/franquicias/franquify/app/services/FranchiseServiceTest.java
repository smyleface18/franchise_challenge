package com.franquicias.franquify.app.services;

import com.franquicias.franquify.app.dtos.branch.CreateBranchDto;
import com.franquicias.franquify.app.dtos.franchise.ChangeFranchiseNameDto;
import com.franquicias.franquify.app.dtos.franchise.CreateFranchiseDto;
import com.franquicias.franquify.app.port.in.BranchUseCase;
import com.franquicias.franquify.app.port.out.CrudFranchisePort;
import com.franquicias.franquify.domain.Branch;
import com.franquicias.franquify.domain.Franchise;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FranchiseServiceTest {

    @Mock
    CrudFranchisePort persistence;

    @Mock
    BranchUseCase branchUseCase;

    @InjectMocks
    FranchiseService franchiseService;

    @Test
    void create_shouldReturnFranchiseWithBranches() {
        Branch branch1 = new Branch("Sucursal 1");
        branch1.setId("b1");
        Branch branch2 = new Branch("Sucursal 2");
        branch2.setId("b2");

        CreateFranchiseDto dto = new CreateFranchiseDto();
        dto.setName("Franquicia 1");
        dto.setBranches(Arrays.asList(
                new CreateBranchDto("Sucursal 1"),
                new CreateBranchDto("Sucursal 2")
        ));

        when(branchUseCase.create(any(CreateBranchDto.class)))
                .thenReturn(Mono.just(branch1))
                .thenReturn(Mono.just(branch2));

        when(persistence.create(any(Franchise.class)))
                .thenAnswer(invocation -> Mono.just(invocation.getArgument(0)));

        StepVerifier.create(franchiseService.create(dto))
                .expectNextMatches(franchise ->
                        franchise.getName().equals("Franquicia 1") &&
                                franchise.getBranchIds().size() == 2 &&
                                franchise.getBranchIds().containsAll(List.of("b1", "b2")))
                .verifyComplete();
    }

    @Test
    void changeName_shouldUpdateFranchiseName() {
        Franchise franchise = new Franchise();
        franchise.setId("f1");
        franchise.setName("Old Name");

        ChangeFranchiseNameDto dto = new ChangeFranchiseNameDto();
        dto.setName("New Name");

        when(persistence.findById("f1")).thenReturn(Mono.just(franchise));
        when(persistence.update(any(Franchise.class))).thenAnswer(invocation -> Mono.just(invocation.getArgument(0)));

        StepVerifier.create(franchiseService.changeName("f1", dto))
                .expectNextMatches(f -> f.getName().equals("New Name"))
                .verifyComplete();
    }

    @Test
    void addBranch_shouldAddBranchToFranchise() {
        Franchise franchise = new Franchise();
        franchise.setId("f1");
        franchise.setBranchIds(Arrays.asList("b1"));

        Branch newBranch = new Branch("Sucursal 2");
        newBranch.setId("b2");

        CreateBranchDto dto = new CreateBranchDto("Sucursal 2");

        when(persistence.findById("f1")).thenReturn(Mono.just(franchise));
        when(branchUseCase.create(dto)).thenReturn(Mono.just(newBranch));
        when(persistence.update(any(Franchise.class))).thenAnswer(invocation -> Mono.just(invocation.getArgument(0)));

        StepVerifier.create(franchiseService.addBranch("f1", dto))
                .expectNextMatches(f -> f.getBranchIds().size() == 2 &&
                        f.getBranchIds().containsAll(List.of("b1", "b2")))
                .verifyComplete();
    }

    @Test
    void getAll_shouldReturnAllFranchises() {
        Franchise f1 = new Franchise();
        f1.setId("f1");
        Franchise f2 = new Franchise();
        f2.setId("f2");

        when(persistence.getAll()).thenReturn(Flux.just(f1, f2));

        StepVerifier.create(franchiseService.getAll())
                .expectNext(f1)
                .expectNext(f2)
                .verifyComplete();
    }
}
