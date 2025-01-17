package com.prueba.productInventoryManagement.domain.repositories;

import com.prueba.productInventoryManagement.domain.models.Category;

import java.util.List;

public interface CategoryRepository {
    void save(Category category);
    List<Category> getCategories();
}
