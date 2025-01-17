package com.prueba.productInventoryManagement.infrastructure.database;

import com.prueba.productInventoryManagement.domain.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryDBRepository extends CrudRepository<Category, Long> { }
