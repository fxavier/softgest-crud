package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends BusnessException {
    public CustomerNotFoundException() {
        super("customer-7", HttpStatus.BAD_REQUEST);
    }
}
