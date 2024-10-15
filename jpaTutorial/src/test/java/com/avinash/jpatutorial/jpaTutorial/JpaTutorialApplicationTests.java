package com.avinash.jpatutorial.jpaTutorial;

import com.avinash.jpatutorial.jpaTutorial.Repositories.ProductRepositoriy;
import com.avinash.jpatutorial.jpaTutorial.entities.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepositoriy productRepositoriy;


	@Test
	void contextLoads() {
	}

	@Test
	void testRepositories()
	{
		ProductEntity productentity = ProductEntity.builder()
				.sku("Nestle24")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(123.45))
				.quantity(10)
				.build();

		ProductEntity savedProductEntity = productRepositoriy.save(productentity);
		System.out.println("saved product :: " + savedProductEntity);
	}

	@Test
	void getAllEntitiy()
	{
		List<ProductEntity> enties = productRepositoriy.findAll();
		System.out.println(enties);
	}

}
