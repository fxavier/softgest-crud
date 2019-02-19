package com.xavier.softgest.repository;

import com.xavier.softgest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Products extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
}
