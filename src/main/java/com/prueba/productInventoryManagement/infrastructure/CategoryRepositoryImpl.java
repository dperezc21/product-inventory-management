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
    public void save(Category category) {
        this.categoryDBRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {
        return (List<Category>) this.categoryDBRepository.findAll();
    }
}
