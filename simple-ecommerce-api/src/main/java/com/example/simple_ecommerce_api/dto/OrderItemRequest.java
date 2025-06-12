package com.example.simple_ecommerce_api.dto;

import lombok.Data;

@Data
public class OrderItemRequest {
    private Long product_id;
    private Integer quantity;
}