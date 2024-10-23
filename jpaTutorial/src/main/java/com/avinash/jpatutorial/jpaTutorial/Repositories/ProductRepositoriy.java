package com.avinash.jpatutorial.jpaTutorial.Repositories;

import com.avinash.jpatutorial.jpaTutorial.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepositoriy extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findByCreatedAtAfter(LocalDate after);

    List<ProductEntity> findByQuantityGreaterThanOrPriceLessThan(int quantity, BigDecimal price);


    @Query("select e from ProductEntity e where e.title = ?1 and e.price= ?2")
    Optional<ProductEntity>findByTitleAndPrice(String title,BigDecimal price);


    @Query("select e from ProductEntity e where e.price=:price")
    Optional<ProductEntity>findByPrice(BigDecimal price);


     List<ProductEntity> findByTitleOrderByPrice(String title);



     @Query("select e from ProductEntity e order by e.price asc")
     List<ProductEntity> findAllByPrice();

}
