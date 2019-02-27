package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class SupplierExistException extends BusnessException {
    public SupplierExistException() {
        super("supplier-6", HttpStatus.BAD_REQUEST);
    }
}
