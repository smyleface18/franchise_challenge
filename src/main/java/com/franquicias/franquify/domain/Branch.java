package com.franquicias.franquify.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

    private String id;
    private String name;
    private List<Product> products;
}
