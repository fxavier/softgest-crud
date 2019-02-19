package com.xavier.softgest.repository;

import com.xavier.softgest.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Customers extends JpaRepository<Customer, Long> {
    Optional<Customer> findByNameAndEmail(String name, String email);
}
