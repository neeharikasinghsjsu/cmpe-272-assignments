package com.expressnest.pms.productadminservice.service;

import java.util.Collections;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expressnest.pms.productadminservice.configuration.RabbitMQConfig;
import com.expressnest.pms.productadminservice.entity.Product;
import com.expressnest.pms.productadminservice.entity.ProductEvent;
import com.expressnest.pms.productadminservice.entity.ProductEvent.EventType;

@Service
public class ProductMessageService {

	@Autowired
    private RabbitTemplate rabbitTemplate;

    public void publishUpdateProduct(Product product) {
    	ProductEvent productEvent = new ProductEvent();
    	productEvent.setEventType(EventType.UPDATE);
    	productEvent.setProduct(product);
        rabbitTemplate.convertAndSend(RabbitMQConfig.ROUTING_KEY, productEvent);
    }
    
    public void publishCreateProduct(Product product) {
    	ProductEvent productEvent = new ProductEvent();
    	productEvent.setEventType(EventType.CREATE);
    	productEvent.setProduct(product);
        rabbitTemplate.convertAndSend(RabbitMQConfig.ROUTING_KEY, productEvent);
    }
    
    public void publishDeleteProduct(int productId) {
    	ProductEvent productEvent = new ProductEvent();
    	productEvent.setEventType(EventType.DELETE);
    	productEvent.setProductId(productId);
        rabbitTemplate.convertAndSend(RabbitMQConfig.ROUTING_KEY, productEvent);
    }
}
