package com.avinash.jpatutorial.jpaTutorial;

import com.avinash.jpatutorial.jpaTutorial.Repositories.ProductRepositoriy;
import com.avinash.jpatutorial.jpaTutorial.entities.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepositoriy productRepositoriy;


	@Test
	void contextLoads() {
	}
//
//	@Test
//	void testRepositories()
//	{
//		ProductEntity productentity = ProductEntity.builder()
//				.sku("Nestle25")
//				.title("Nestle Chocolate1")
//				.price(BigDecimal.valueOf(120.45))
//				.quantity(20)
//				.build();
//
//		ProductEntity savedProductEntity = productRepositoriy.save(productentity);
//		System.out.println("saved product :: " + savedProductEntity);
//	}

//	@Test
//	void getAllEntitiy()
//	{
//		List<ProductEntity> enties = productRepositoriy.findAll();
//		System.out.println(enties);
//	}

//	@Test
//	void getAllByDate()
//	{
//		List<ProductEntity> entities = productRepositoriy.findByCreatedAtAfter(LocalDate.of(2024, 10, 18));
//		System.out.println(entities);
//	}

}
