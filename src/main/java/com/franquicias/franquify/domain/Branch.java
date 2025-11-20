package com.franquicias.franquify.domain;

import lombok.Data;

import java.util.List;

@Data
public class Branch {

    private String id;
    private String name;
    private List<Product> products;
}
