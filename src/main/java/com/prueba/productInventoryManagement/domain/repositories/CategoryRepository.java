package com.prueba.productInventoryManagement.domain.repositories;

import com.prueba.productInventoryManagement.domain.models.Category;

import java.util.List;

public interface CategoryRepository {
    Long save(Category category);
    List<Category> getCategories();
    Category getCategoryById(Long id);
}
