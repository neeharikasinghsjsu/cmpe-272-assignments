package com.expressnest.pms.productsearchservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressnest.pms.productsearchservice.entity.Product;
import com.expressnest.pms.productsearchservice.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productSearchRepository;
		
	public Iterable<Product> getAllProducts() {
		return productSearchRepository.findAll();
	}
	
	public Optional<Product> getProductById(int id) {
		return productSearchRepository.findById(id);
	}
	
	public Product getProductByName(String name) {
		return productSearchRepository.findByName(name);
	}
	
	public Product saveProduct(Product product) {
		return productSearchRepository.save(product);
	}
	
	public String deleteProduct(int id) {
		productSearchRepository.deleteById(id);
		return "Product deleted ID : " + id;
	}

	public Product updateProduct(Product product) {
		Product existingProduct = productSearchRepository.findById(product.getId()).get();
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return productSearchRepository.save(existingProduct);
	}
	
}
