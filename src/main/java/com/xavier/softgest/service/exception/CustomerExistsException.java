package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class CustomerExistsException extends BusnessException {
    public CustomerExistsException() {
        super("customer-6", HttpStatus.BAD_REQUEST);
    }
}
