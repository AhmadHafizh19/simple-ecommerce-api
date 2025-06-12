package com.example.simple_ecommerce_api.service;

import com.example.simple_ecommerce_api.dto.OrderItemRequestDto;
import com.example.simple_ecommerce_api.dto.OrderRequestDto;
import com.example.simple_ecommerce_api.model.*;
import com.example.simple_ecommerce_api.repository.CustomerRepository;
import com.example.simple_ecommerce_api.repository.OrderRepository;
import com.example.simple_ecommerce_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public Order createOrder(OrderRequestDto request) {
        Customer customer = customerRepo.findById(request.getCustomer_id())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        List<OrderItem> orderItems = new ArrayList<>();
        int totalPrice = 0;

        for (OrderItemRequestDto itemRequest : request.getItems()) {
            Product product = productRepo.findById(itemRequest.getProduct_id())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            if (product.getStock() < itemRequest.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }

            product.setStock(product.getStock() - itemRequest.getQuantity());
            productRepo.save(product);

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setUnitPrice(product.getPrice().intValue());

            totalPrice += product.getPrice().intValue() * itemRequest.getQuantity();
            orderItems.add(orderItem);
        }

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalPrice(totalPrice);
        order.setOrderItems(orderItems); // Use the correct setter here
        for (OrderItem item : orderItems) {
            item.setOrder(order);
        }

        return orderRepo.save(order);
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepo.findByCustomerId(customerId);
    }

    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }
    public OrderResponseDto mapOrderToResponse(Order order) {
    OrderResponseDto dto = new OrderResponseDto();
    dto.setOrder_id(order.getId());
    dto.setCustomer_id(order.getCustomer().getId());
    dto.setOrder_date(order.getOrderDate());
    dto.setTotal_price(order.getTotalPrice());

    List<OrderItemResponseDto> items = order.getItems().stream().map(item -> {
        OrderItemResponseDto itemDto = new OrderItemResponseDto();
        itemDTO.setProduct_id(item.getProduct().getId());
        itemDTO.setProduct_name(item.getProduct().getName());
        itemDTO.setQuantity(item.getQuantity());
        itemDTO.setUnit_price(item.getUnitPrice());
        return itemDto;
    }).toList();

    dto.setItems(items);
    return dto;
}

}