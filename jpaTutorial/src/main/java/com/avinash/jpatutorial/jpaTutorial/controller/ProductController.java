package com.avinash.jpatutorial.jpaTutorial.controller;


import com.avinash.jpatutorial.jpaTutorial.Repositories.ProductRepositoriy;
import com.avinash.jpatutorial.jpaTutorial.entities.ProductEntity;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepositoriy productRepositoriy;

   public ProductController(ProductRepositoriy productRepository)
   {
       this.productRepositoriy = productRepository;
   }


   @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(required = false) String title)
   {
       return productRepositoriy.findByTitleOrderByPrice(title);
   }

   @GetMapping("/all")
    public List<ProductEntity> getAllByPrice()
   {
       return productRepositoriy.findAllByPrice();
   }

   @GetMapping("/all/{sortBy}")
    public List<ProductEntity> getAllProductSortBy(@PathVariable String sortBy)
   {
       return productRepositoriy.findBy(Sort.by(sortBy));
   }

    @GetMapping("/all/desc/{sortBy}")
    public List<ProductEntity> getAllProductSortBy1(@PathVariable String sortBy)
    {
        return productRepositoriy.findBy(Sort.by(Sort.Direction.DESC,sortBy));
    }


    @GetMapping("/all/twoparams/{sortBy}")
    public List<ProductEntity> getAllProductSortBy2(@PathVariable String sortBy)
    {
        return productRepositoriy.findBy(Sort.by(Sort.Direction.DESC,sortBy,"price"));
    }


    @GetMapping("/all/twoparams/asc-desc/{sortBy}")
    public List<ProductEntity> getAllProductSortBy3(@PathVariable String sortBy)
    {
        return productRepositoriy.findBy(Sort.by(
                Sort.Order.desc(sortBy),
                Sort.Order.asc("price")));
    }
}
