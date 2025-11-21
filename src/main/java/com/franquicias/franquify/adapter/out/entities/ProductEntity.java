package com.franquicias.franquify.adapter.out.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductEntity {

    private String name;
    private int stock;

}
