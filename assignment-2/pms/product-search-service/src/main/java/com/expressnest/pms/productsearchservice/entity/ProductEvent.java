package com.expressnest.pms.productsearchservice.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductEvent {

    private EventType eventType;
    private Product product;
    private int productId;

    public enum EventType {
        CREATE,
        UPDATE,
        DELETE
    }
}
