package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends BusnessException {
    public ProductNotFoundException() {
        super("product-7", HttpStatus.BAD_REQUEST);
    }
}
