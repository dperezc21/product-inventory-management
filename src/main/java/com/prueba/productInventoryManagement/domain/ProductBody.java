package com.prueba.productInventoryManagement.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductBody {
    private Long id;
    private String productName;
    private Integer stock;
    private Double productPrice;
    private CategoryBody category;
}
