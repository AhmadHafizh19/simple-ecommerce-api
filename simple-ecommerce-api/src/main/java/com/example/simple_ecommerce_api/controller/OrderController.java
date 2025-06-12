package com.example.simple_ecommerce_api.controller;

import com.example.simple_ecommerce_api.dto.OrderRequestDto;
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
    public OrderResponseDto createOrder(@RequestBody OrderRequest request) {
        Order order = orderService.createOrder(request);
        return orderService.mapOrderToResponse(order);
}

    @GetMapping("/{id}")
    public OrderResponseDto getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return orderService.mapOrderToResponse(order);
}
    
}