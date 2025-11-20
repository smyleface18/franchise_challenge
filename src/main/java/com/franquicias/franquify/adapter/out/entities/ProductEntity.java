package com.franquicias.franquify.adapter.out.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "product")
public class ProductEntity {

    private String id;
    private String name;
    private int stock;

}
