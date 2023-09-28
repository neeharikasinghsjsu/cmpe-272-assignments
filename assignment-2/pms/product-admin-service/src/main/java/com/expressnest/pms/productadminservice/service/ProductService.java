package com.expressnest.pms.productadminservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressnest.pms.productadminservice.entity.Product;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
    @Autowired
    private ProductDBService productDbService;
    
    @Autowired
    private ProductMessageService productMessageService;

    @Transactional
    public Product saveProduct(Product product) {
    	Product savedProduct = productDbService.saveProduct(product);
    	productMessageService.publishCreateProduct(savedProduct);
        return savedProduct;
    }

    @Transactional
    public String deleteProduct(int id) {
    	String deletedProduct = productDbService.deleteProduct(id);
    	productMessageService.publishDeleteProduct(id);
    	return deletedProduct;
    }

    @Transactional
    public Product updateProduct(Product product) {
    	Product updatedProduct = productDbService.updateProduct(product);
    	productMessageService.publishUpdateProduct(updatedProduct);
    	return updatedProduct;      
    }


}
