package com.xavier.softgest.repository;

import com.xavier.softgest.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Banks extends JpaRepository<Bank, Long> {
    Optional<Bank> findByName(String name);
}
