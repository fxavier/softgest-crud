package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class SupplierNotFoundException extends BusnessException {
    public SupplierNotFoundException() {
        super("supplier-7", HttpStatus.BAD_REQUEST);
    }
}
