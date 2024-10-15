package com.avinash.jpatutorial.jpaTutorial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(
        name ="Products",
        uniqueConstraints = {
                @UniqueConstraint(name = "sku_uniqe", columnNames = "sku") ,
                @UniqueConstraint(name = "title_x_price",columnNames = "title_x,price")
        },
        indexes = {
                @Index(name="sku_index",columnList = "sku")
        }

)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 20)
    private String sku;

    @Column(name = "title_x")
    private String title;                       //// by defaul column name is : title, but with help of @Column, we cqn change it

    private BigDecimal price;  //// by default column name is : price

    private Integer quantity;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;
}

