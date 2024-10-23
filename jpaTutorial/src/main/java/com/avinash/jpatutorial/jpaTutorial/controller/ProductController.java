package com.avinash.jpatutorial.jpaTutorial.controller;


import com.avinash.jpatutorial.jpaTutorial.Repositories.ProductRepositoriy;
import com.avinash.jpatutorial.jpaTutorial.entities.ProductEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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



}
