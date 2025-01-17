package com.prueba.productInventoryManagement.application;

import com.prueba.productInventoryManagement.domain.CategoryBody;
import com.prueba.productInventoryManagement.domain.models.Category;
import com.prueba.productInventoryManagement.domain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryUseCase {

    @Autowired
    private CategoryRepository repository;

    public void createCategory(String categoryName) {
        Category categoryToCreate = new Category();
        categoryToCreate.setCategoryName(categoryName);
        repository.save(categoryToCreate);
    }

    public List<CategoryBody> getAllCategories() {
        return this.repository.getCategories().stream().map(CategoryUseCase::mapCategory).toList();
    }

    public static CategoryBody mapCategory(Category category) {
        CategoryBody categoryResponse = new CategoryBody();
        categoryResponse.setId(category.getCategoryId());
        categoryResponse.setCategoryName(category.getCategoryName());
        return categoryResponse;
    }
}
