package com.example.simple_ecommerce_api.dto;

import com.example.simple_ecommerce_api.model.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
    private Long customer_id;
    private List<OrderItemRequestDto> items;
}