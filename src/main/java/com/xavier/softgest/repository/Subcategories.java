package com.xavier.softgest.repository;


import com.xavier.softgest.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Subcategories extends JpaRepository<Subcategory, Long> {
     Optional<Subcategory> findByName(String name);
     Optional<Subcategory> findByCategoryId(Long categoryId);
}
