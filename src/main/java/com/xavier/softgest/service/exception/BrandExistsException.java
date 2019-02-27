package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class BrandExistsException extends BusnessException {
    public BrandExistsException() {
        super("brand-2", HttpStatus.BAD_REQUEST);
    }
}
