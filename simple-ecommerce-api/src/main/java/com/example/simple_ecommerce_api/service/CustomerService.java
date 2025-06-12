package com.example.simple_ecommerce_api.service;

import com.example.simple_ecommerce_api.model.Customer;
import com.example.simple_ecommerce_api.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public Customer createCustomer(Customer customer) {
        return repo.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    }

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }
}