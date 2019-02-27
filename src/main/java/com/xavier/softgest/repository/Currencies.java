package com.xavier.softgest.repository;

import com.xavier.softgest.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Currencies extends JpaRepository<Currency, Long> {
    Optional<Currency> findByNameAndCode(String name, String code);
}
