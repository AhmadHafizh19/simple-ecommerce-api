package com.example.simple_ecommerce_api.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/dashboard")
public class DashboardController {
    @GetMapping
    public Map<String, Object> getDashboard() {
        // Dummy response, replace with real logic
        Map<String, Object> response = new HashMap<>();
        response.put("total_orders", 120);
        response.put("total_revenue", 12500000);
        List<Map<String, Object>> bestSelling = new ArrayList<>();
        bestSelling.add(Map.of("product_id", 3, "name", "usb_keyboard", "quantity_sold", 65));
        bestSelling.add(Map.of("product_id", 2, "name", "wireless_mouse", "quantity_sold", 40));
        response.put("best_selling_products", bestSelling);
        return response;
    }
}