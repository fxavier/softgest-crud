package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class CurrencyExistsException extends BusnessException {
    public CurrencyExistsException() {
        super("currency-2", HttpStatus.BAD_REQUEST);
    }
}
