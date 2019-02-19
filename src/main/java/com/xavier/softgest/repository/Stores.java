package com.xavier.softgest.repository;

import com.xavier.softgest.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Stores extends JpaRepository<Store, Long> {

    Optional<Store> findByName(String name);
}
