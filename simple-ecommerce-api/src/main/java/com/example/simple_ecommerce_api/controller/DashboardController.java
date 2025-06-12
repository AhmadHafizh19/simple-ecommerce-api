package com.example.simple_ecommerce_api.controller;

import com.example.simple_ecommerce_api.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public Map<String, Object> getDashboard() {
        return Map.of(
                "total_orders", dashboardService.getTotalOrders(),
                "total_revenue", dashboardService.getTotalRevenue()
        );
    }
}
