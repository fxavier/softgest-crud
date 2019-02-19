package com.xavier.softgest.repository;

import com.xavier.softgest.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Countries extends JpaRepository<Country, Long> {
    Optional<Country> findByName(String name);
}
