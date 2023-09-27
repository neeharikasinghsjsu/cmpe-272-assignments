package com.expressnest.pms.productsearchservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressnest.pms.productsearchservice.entity.ProductEvent;
import com.expressnest.pms.productsearchservice.entity.ProductEvent.EventType;

@Service
public class ProductMessageService {

	@Autowired
	private ProductService productService;

	@RabbitListener(queues = "product-queue")
	public void handleMessage(ProductEvent productEvent) throws Exception {
		EventType productEventType = productEvent.getEventType();
		switch (productEventType) {
		case CREATE:
			productService.saveProduct(productEvent.getProduct());
			break;
		case UPDATE:
			productService.updateProduct(productEvent.getProduct());
			break;
		case DELETE:
			productService.deleteProduct(productEvent.getProductId());
			break;
		default:
			throw new Exception("No such Event");
		}
	}

}
