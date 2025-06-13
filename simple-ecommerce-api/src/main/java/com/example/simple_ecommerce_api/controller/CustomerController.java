package com.example.simple_ecommerce_api.controller;

import com.example.simple_ecommerce_api.dto.OrderResponseDto;
import com.example.simple_ecommerce_api.model.Customer;
import com.example.simple_ecommerce_api.model.Order;
import com.example.simple_ecommerce_api.service.CustomerService;
import com.example.simple_ecommerce_api.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final OrderService orderService;

    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/{id}/orders")
    public List<OrderResponseDto> getCustomerOrders(@PathVariable Long id) {
        return orderService.getOrdersByCustomerId(id)
                .stream()
                .map(orderService::mapOrderToResponse)
                .toList();
    }
}