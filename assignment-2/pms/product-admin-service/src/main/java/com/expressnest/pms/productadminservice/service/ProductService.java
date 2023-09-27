package com.expressnest.pms.productadminservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressnest.pms.productadminservice.entity.Product;

@Service
public class ProductService {
    @Autowired
    private ProductDBService productDbService;
    
    @Autowired
    private ProductMessageService productMessageService;

    public Product saveProduct(Product product) {
    	Product savedProduct = productDbService.saveProduct(product);
    	productMessageService.publishCreateProduct(savedProduct);
        return savedProduct;
    }

    public String deleteProduct(int id) {
    	String deletedProduct = productDbService.deleteProduct(id);
    	productMessageService.publishDeleteProduct(id);
    	return deletedProduct;
    }

    public Product updateProduct(Product product) {
    	Product updatedProduct = productDbService.updateProduct(product);
    	productMessageService.publishUpdateProduct(updatedProduct);
    	return updatedProduct;      
    }


}
