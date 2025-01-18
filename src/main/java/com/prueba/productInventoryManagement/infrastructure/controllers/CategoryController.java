package com.prueba.productInventoryManagement.infrastructure.controllers;

import com.prueba.productInventoryManagement.application.CategoryUseCase;
import com.prueba.productInventoryManagement.domain.CategoryBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/categories")
public class CategoryController {

    @Autowired
    private CategoryUseCase categoryUseCase;

    @PostMapping
    public ResponseEntity<CategoryBody> createCategory(@RequestBody CategoryBody category) {
        try {
            Long categoryId = this.categoryUseCase.createCategory(category.getCategoryName());
            if(categoryId == null) ResponseEntity.ok(null);
            category.setId(categoryId);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null); //"Error while create category, try again"
        }
        return ResponseEntity.ok(category);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<CategoryBody>> getAllCategories() {
        List<CategoryBody> categories = new ArrayList<>();
        try {
            categories = this.categoryUseCase.getAllCategories();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(null);
        }
        return ResponseEntity.ok(categories);
    }
}
