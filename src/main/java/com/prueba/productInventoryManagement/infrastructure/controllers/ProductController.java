package com.prueba.productInventoryManagement.infrastructure.controllers;

import com.prueba.productInventoryManagement.application.ProductUseCase;
import com.prueba.productInventoryManagement.domain.GenericResponse;
import com.prueba.productInventoryManagement.domain.ProductBody;
import com.prueba.productInventoryManagement.domain.exceptions.CategoryNotFound;
import com.prueba.productInventoryManagement.domain.exceptions.ProductNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductUseCase productUseCase;

    @PostMapping
    public ResponseEntity<ProductBody> saveProduct(@RequestBody ProductBody product) {
        try {
            Long productId = this.productUseCase.createProduct(product.getProductName(), product.getStock(), product.getProductPrice(), product.getCategory().getId());
            if(productId == null) ResponseEntity.ok("product not created");
            product.setId(productId);
        } catch (CategoryNotFound e) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(product);
    }

    @PutMapping(path = "/{productId}")
    public ResponseEntity<GenericResponse<String>> updateProduct(@PathVariable Long productId, @RequestBody ProductBody product) {
        try {
            this.productUseCase.updateProduct(productId, product.getProductName(), product.getStock(), product.getProductPrice(), product.getCategory().getId());
        } catch (ProductNotFound | CategoryNotFound e) {
            return ResponseEntity.badRequest().body(new GenericResponse<>(e.getMessage(), null));
        }
        return ResponseEntity.ok(new GenericResponse<>("product updated", null));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<ProductBody>> getProducts() {
        List<ProductBody> productBodyList;
        try {
            productBodyList = this.productUseCase.getAllProducts();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
        return ResponseEntity.ok(productBodyList);
    }

    @DeleteMapping(path = "/{productId}")
    public ResponseEntity<GenericResponse<String>> deleteProduct(@PathVariable Long productId) {
        try {
            this.productUseCase.deleteProduct(productId);
        } catch (ProductNotFound e) {
            return ResponseEntity.badRequest().body(new GenericResponse<>(e.getMessage(), null));
        }
        return ResponseEntity.ok(new GenericResponse<>("product deleted", null));
    }

}
