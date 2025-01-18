package com.prueba.productInventoryManagement.infrastructure;

import com.prueba.productInventoryManagement.domain.models.Category;
import com.prueba.productInventoryManagement.domain.repositories.CategoryRepository;
import com.prueba.productInventoryManagement.infrastructure.database.CategoryDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private CategoryDBRepository categoryDBRepository;

    @Override
    public Long save(Category category) {
        return this.categoryDBRepository.save(category).getCategoryId();
    }

    @Override
    public List<Category> getCategories() {
        return (List<Category>) this.categoryDBRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return this.categoryDBRepository.findById(categoryId).orElse(null);
    }
}
