package com.xavier.softgest.repository;

import com.xavier.softgest.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Categories extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);
}
