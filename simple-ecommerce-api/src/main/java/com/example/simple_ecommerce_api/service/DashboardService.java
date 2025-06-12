package com.example.simple_ecommerce_api.service;

import com.example.simple_ecommerce_api.repository.OrderRepository;
import com.example.simple_ecommerce_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DashboardService {

    private final OrderRepository orderRepo;

    public DashboardService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    public long getTotalOrders() {
        return orderRepo.count();
    }

    public int getTotalRevenue() {
        return orderRepo.findAll().stream().mapToInt(o -> o.getTotalPrice()).sum();
    }
}