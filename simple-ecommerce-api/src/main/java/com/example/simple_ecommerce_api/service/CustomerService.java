package com.example.simple_ecommerce_api.service;

import com.example.simple_ecommerce_api.model.Customer;
import com.example.simple_ecommerce_api.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }
}
