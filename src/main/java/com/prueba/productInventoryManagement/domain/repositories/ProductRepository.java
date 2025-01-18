package com.prueba.productInventoryManagement.domain.repositories;

import com.prueba.productInventoryManagement.domain.models.Product;

import java.util.List;

public interface ProductRepository {
    Long save(Product product);
    void updateProduct(Product product);
    void deleteProduct(Long productId);
    Product getProduct(Long productId);
    List<Product> getAllProducts();
}
