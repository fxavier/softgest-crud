package com.xavier.softgest.repository;

import com.xavier.softgest.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Brands extends JpaRepository<Brand, Long> {
    Optional<Brand> findByName(String name);
}
