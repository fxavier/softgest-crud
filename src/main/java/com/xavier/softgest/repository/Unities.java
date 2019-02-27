package com.xavier.softgest.repository;

import com.xavier.softgest.model.Unity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Unities extends JpaRepository<Unity, Long> {
    Optional<Unity> findByName(String name);
}
