package com.prueba.productInventoryManagement.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "product")
public class Product {

    public Product() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Column(name = "product_price", nullable = false)
    private Double price;

    @Column(name = "stock", nullable = false)
    private Integer stockQuantity;

    @ManyToOne
    @JoinColumn(name = "product_category_id", nullable = false)
    private Category category;

    public Product(String productName, Double price, Integer stock, Category category) {
        this.name = productName;
        this.price = price;
        this.stockQuantity = stock;
        this.category = category;
    }
}
