package com.example.simple_ecommerce_api.dto;

import lombok.Data;

@Data
public class OrderItemRequestDto {
    private Long product_id;
    private Integer quantity;
}