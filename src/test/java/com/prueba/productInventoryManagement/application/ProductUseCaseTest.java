package com.prueba.productInventoryManagement.application;

import com.prueba.productInventoryManagement.domain.exceptions.CategoryNotFound;
import com.prueba.productInventoryManagement.domain.models.Category;
import com.prueba.productInventoryManagement.domain.models.Product;
import com.prueba.productInventoryManagement.domain.repositories.CategoryRepository;
import com.prueba.productInventoryManagement.domain.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProductUseCaseTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductUseCase productUseCase;

    private List<Product> products;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Category category = new Category();
        category.setCategoryName("granos");
        category.setCategoryId(1L);

        Product product = new Product("arroz",34.0, 10, category);
        product.setProductId(1L);
        products = new ArrayList<>();
        products.add(product);
    }

    @Test
    void getAllProducts() {
        when(productRepository.getAllProducts()).thenReturn(this.products);
        assertNotNull(productUseCase.getAllProducts());
        assertEquals(this.products.size(), productUseCase.getAllProducts().size());
    }

    @Test
    void getProductById() {
    }
}