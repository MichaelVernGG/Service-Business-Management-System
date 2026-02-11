package com.michael.sbms.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.michael.sbms.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByNameContainingIgnoreCase(String name);

    List<Customer> findByContactNumberContaining(String contactNumber);
}
