package com.expressnest.pms.productadminservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.expressnest.pms.productadminservice.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}