package com.xavier.softgest.repository;

import com.xavier.softgest.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Currencies extends JpaRepository<Currency, Long> {
}
