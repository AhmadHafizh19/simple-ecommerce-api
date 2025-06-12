//package com.example.simple_ecommerce_api.service;
//
//import com.example.simple_ecommerce_api.model.OrderItem;
//import com.example.simple_ecommerce_api.repository.OrderItemRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OrderItemService {
//
//    private final OrderItemRepository orderItemRepo;
//
//    public OrderItemService(OrderItemRepository orderItemRepo) {
//        this.orderItemRepo = orderItemRepo;
//    }
//
//    public List<OrderItem> getAll() {
//        return orderItemRepo.findAll();
//    }
//
//    public OrderItem getById(Long id) {
//        return orderItemRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("OrderItem not found"));
//    }
//
//    public OrderItem save(OrderItem item) {
//        return orderItemRepo.save(item);
//    }
//
//    public void delete(Long id) {
//        orderItemRepo.deleteById(id);
//    }
//}