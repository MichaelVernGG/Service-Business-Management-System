package com.michael.sbms.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.michael.sbms.model.Customer;
import com.michael.sbms.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public Customer getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<Customer> searchByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }
}
