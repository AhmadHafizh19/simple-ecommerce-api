package com.example.simple_ecommerce_api.service;

import com.example.simple_ecommerce_api.repository.OrderItemRepository;
import com.example.simple_ecommerce_api.repository.OrderRepository;
import com.example.simple_ecommerce_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    private final OrderRepository orderRepo;
    private final OrderItemRepository orderItemRepo;

    public DashboardService(OrderRepository orderRepo, OrderItemRepository orderItemRepo) {
        this.orderRepo = orderRepo;
        this.orderItemRepo = orderItemRepo;
    }

    public long getTotalOrders() {
        return orderRepo.count();
    }

    public int getTotalRevenue() {
        return orderRepo.findAll().stream().mapToInt(o -> o.getTotalPrice()).sum();
    }

    public List<Map<String, Object>> getBestSellingProducts() {
        return orderItemRepo.findBestSellingProducts();
    }
}