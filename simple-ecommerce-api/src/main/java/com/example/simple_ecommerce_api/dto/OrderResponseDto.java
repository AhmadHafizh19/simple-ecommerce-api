package com.example.simple_ecommerce_api.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponseDto {
    private Long order_id;
    private Long customer_id;
    private LocalDateTime order_date;
    private Integer total_price;
    private List<OrderItemResponseDto> items;
}