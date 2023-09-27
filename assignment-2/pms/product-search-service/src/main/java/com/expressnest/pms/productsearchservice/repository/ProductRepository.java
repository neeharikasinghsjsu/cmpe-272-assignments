package com.expressnest.pms.productsearchservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.expressnest.pms.productsearchservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	Product findByName(String name);
}
