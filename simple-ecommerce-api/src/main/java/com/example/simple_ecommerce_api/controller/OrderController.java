package com.example.simple_ecommerce_api.controller;

import com.example.simple_ecommerce_api.dto.OrderRequest;
import com.example.simple_ecommerce_api.model.Order;
import com.example.simple_ecommerce_api.model.OrderItem;
import com.example.simple_ecommerce_api.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}