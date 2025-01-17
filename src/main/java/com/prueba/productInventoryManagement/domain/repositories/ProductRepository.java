package com.prueba.productInventoryManagement.domain.repositories;

import com.prueba.productInventoryManagement.domain.models.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
    Product getProduct(Long productId);
    List<Product> getAllProducts();
}
