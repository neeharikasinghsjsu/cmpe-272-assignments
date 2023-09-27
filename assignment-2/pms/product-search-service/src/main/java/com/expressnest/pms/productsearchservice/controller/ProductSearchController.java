package com.expressnest.pms.productsearchservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expressnest.pms.productsearchservice.entity.Product;
import com.expressnest.pms.productsearchservice.service.ProductService;

@RestController
@RequestMapping("/pms")
public class ProductSearchController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public Iterable<Product> findAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return productService.getProductById(id).get();
    }

    @GetMapping("/productByName/{name}")
    public Product findProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }
}