package com.avinash.jpatutorial.jpaTutorial.Repositories;

import com.avinash.jpatutorial.jpaTutorial.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoriy extends JpaRepository<ProductEntity,Long> {
}
