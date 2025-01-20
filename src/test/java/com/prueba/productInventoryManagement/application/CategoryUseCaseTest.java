package com.prueba.productInventoryManagement.application;

import com.prueba.productInventoryManagement.domain.models.Category;
import com.prueba.productInventoryManagement.domain.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class CategoryUseCaseTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    private Category category;

    @BeforeEach
    void setUp() {
        category = new Category();
        category.setCategoryName("granos");
    }

    @Test
    void getAllCategories() {
        when(this.categoryRepository.getCategories()).thenReturn(Arrays.asList(category));
        assertNotNull(this.categoryUseCase.getAllCategories());
        assertEquals(this.categoryUseCase.getAllCategories().size(), Arrays.asList(category).size());
    }
}