package com.example.simple_ecommerce_api.dto;

import lombok.Data;

@Data
public class OrderItemResponseDto {
    private Long product_id;
    private String product_name;
    private Integer quantity;
    private Integer unit_price;
}
