package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class CountryNotFoundException extends BusnessException {
    public CountryNotFoundException() {
        super("country-3", HttpStatus.BAD_REQUEST);
    }
}
