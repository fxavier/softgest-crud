package com.xavier.softgest.repository;

import com.xavier.softgest.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface Suppliers extends JpaRepository<Supplier, Long> {
    Optional<Supplier> findByName(String name);
}
