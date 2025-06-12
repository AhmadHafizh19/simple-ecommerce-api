package com.example.simple_ecommerce_api.repository;

import com.example.simple_ecommerce_api.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    @Query("SELECT new map(oi.product.id as product_id, oi.product.name as name, SUM(oi.quantity) as quantity_sold) " +
            "FROM OrderItem oi GROUP BY oi.product.id, oi.product.name ORDER BY quantity_sold DESC")
    List<Map<String, Object>> findBestSellingProducts();
}