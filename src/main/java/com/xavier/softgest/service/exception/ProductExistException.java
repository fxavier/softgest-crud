package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class ProductExistException extends BusnessException {
    public ProductExistException() {
        super("product-7", HttpStatus.BAD_REQUEST);
    }
}
