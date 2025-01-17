package com.prueba.productInventoryManagement.infrastructure.database;

import com.prueba.productInventoryManagement.domain.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDBRepository extends CrudRepository<Product, Long> { }
