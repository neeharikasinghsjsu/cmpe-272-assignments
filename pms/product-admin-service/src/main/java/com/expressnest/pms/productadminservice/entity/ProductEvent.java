package com.expressnest.pms.productadminservice.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ProductEvent {

    private EventType eventType;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Product product;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int productId;

    public enum EventType {
        CREATE,
        UPDATE,
        DELETE
    }
}

