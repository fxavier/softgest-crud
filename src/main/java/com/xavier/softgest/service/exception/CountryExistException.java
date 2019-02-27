package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class CountryExistException extends BusnessException {
    public CountryExistException() {
        super("country-2", HttpStatus.BAD_REQUEST);
    }
}
