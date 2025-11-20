package com.franquicias.franquify.adapter.out.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "franchise")
public class FranchiseEntity {

    private String id;
    private String name;
    private List<BranchEntity> branches;
}
