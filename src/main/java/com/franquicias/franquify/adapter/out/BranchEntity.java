package com.franquicias.franquify.adapter.out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "branch")
public class BranchEntity {

    private String id;
    private String name;
    private List<ProductEntity> products;
}
