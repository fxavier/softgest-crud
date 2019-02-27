package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class CurrencyNotFoundException extends BusnessException {
    public CurrencyNotFoundException() {
        super("currency-3", HttpStatus.BAD_REQUEST);
    }
}
