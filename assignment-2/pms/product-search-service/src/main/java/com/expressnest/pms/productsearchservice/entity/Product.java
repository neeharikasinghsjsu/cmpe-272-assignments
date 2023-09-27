package com.expressnest.pms.productsearchservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="PRODUCTS")
public class Product {

	@Id
    private int id;
    private String name;
    private int quantity;
    private double price;
}

