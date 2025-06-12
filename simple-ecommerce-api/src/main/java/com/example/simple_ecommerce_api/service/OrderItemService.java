package com.example.simple_ecommerce_api.service;

import com.example.simple_ecommerce_api.model.OrderItem;
import com.example.simple_ecommerce_api.repository.OrderItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderItemService {
    private final OrderItemRepository repo;

    public OrderItemService(OrderItemRepository repo) {
        this.repo = repo;
    }

    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return repo.findAll()
                .stream()
                .filter(item -> item.getOrder().getId().equals(orderId))
                .toList();
    }
}