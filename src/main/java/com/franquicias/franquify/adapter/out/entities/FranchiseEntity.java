package com.franquicias.franquify.adapter.out.entities;

import com.franquicias.franquify.domain.Franchise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "franchise")
public class FranchiseEntity extends Franchise {

    @Id
    private String id;
    private String name;
    private List<BranchEntity> branches;
}
