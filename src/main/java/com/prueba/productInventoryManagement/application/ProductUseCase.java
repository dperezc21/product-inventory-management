package com.prueba.productInventoryManagement.application;

import com.prueba.productInventoryManagement.domain.exceptions.CategoryNotFound;
import com.prueba.productInventoryManagement.domain.exceptions.ProductNotFound;
import com.prueba.productInventoryManagement.domain.models.Category;
import com.prueba.productInventoryManagement.domain.models.Product;
import com.prueba.productInventoryManagement.domain.repositories.CategoryRepository;
import com.prueba.productInventoryManagement.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUseCase {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public void createProduct(String productName, Integer stock, Double price, Long categoryId) throws CategoryNotFound {
        Category getCategory = this.categoryRepository.getCategoryById(categoryId);
        if(getCategory == null) throw new CategoryNotFound("category not exists");
        Product product = new Product(productName, price, stock, getCategory);
        this.productRepository.save(product);
    }

    public void updateProduct(Long productId, String productName, Integer stock, Double price, Long categoryId) throws CategoryNotFound, ProductNotFound {
        Category getCategory = this.categoryRepository.getCategoryById(categoryId);
        if(getCategory == null) throw new CategoryNotFound("category not exists");
        Product getProduct = this.getProductById(productId);
        getProduct.setName(productName);
        getProduct.setPrice(price);
        getProduct.setCategory(getCategory);
        getProduct.setStockQuantity(stock);
        this.productRepository.updateProduct(getProduct);
    }

    public Product getProductById(Long productId) throws ProductNotFound {
        Product findProduct = this.productRepository.getProduct(productId);
        if(findProduct == null) throw new ProductNotFound("product not exists");
        return findProduct;
    }

    public List<Product> getAllProducts() {
        return this.productRepository.getAllProducts();
    }

    public void deleteProduct(Long productId) throws ProductNotFound {
        Product findProduct = this.getProductById(productId);
        this.productRepository.deleteProduct(findProduct.getProductId());
    }
}
