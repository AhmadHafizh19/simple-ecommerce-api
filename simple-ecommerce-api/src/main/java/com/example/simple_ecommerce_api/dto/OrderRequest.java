package com.example.simple_ecommerce_api.dto;

import com.example.simple_ecommerce_api.model.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private Long customerId;
    private List<OrderItem> items;

    public Long getCustomer_id() {
        return customerId;
    }
}