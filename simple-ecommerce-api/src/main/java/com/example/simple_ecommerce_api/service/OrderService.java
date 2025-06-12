package com.example.simple_ecommerce_api.service;

import com.example.simple_ecommerce_api.model.Order;
import com.example.simple_ecommerce_api.model.Customer;
import com.example.simple_ecommerce_api.model.OrderItem;
import com.example.simple_ecommerce_api.model.Product;
import com.example.simple_ecommerce_api.repository.OrderRepository;
import com.example.simple_ecommerce_api.repository.CustomerRepository;
import com.example.simple_ecommerce_api.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Service
public class OrderService {
    private final OrderRepository orderRepo;
    private final CustomerRepository customerRepo;
    private final ProductRepository productRepo;

    public OrderService(OrderRepository orderRepo, CustomerRepository customerRepo, ProductRepository productRepo) {
        this.orderRepo = orderRepo;
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
    }

    public Order createOrder(Order order) {
//        Long customerId = order.getCustomer().getId();
//        List<OrderItem> items = order.getOrderItems();
        return orderRepo.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepo.findByCustomerId(customerId);
    }
}