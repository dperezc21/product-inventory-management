package com.prueba.productInventoryManagement.infrastructure;

import com.prueba.productInventoryManagement.domain.models.Product;
import com.prueba.productInventoryManagement.domain.repositories.ProductRepository;
import com.prueba.productInventoryManagement.infrastructure.database.ProductDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductDBRepository productDBRepository;

    @Override
    public Long save(Product product) {
        return this.productDBRepository.save(product).getProductId();
    }

    @Override
    public void updateProduct(Product product) {
        this.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        this.productDBRepository.deleteById(productId);
    }

    @Override
    public Product getProduct(Long productId) {
        return this.productDBRepository.findById(productId).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) this.productDBRepository.findAll();
    }
}
