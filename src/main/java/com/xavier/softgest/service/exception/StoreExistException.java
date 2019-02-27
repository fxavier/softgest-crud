package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class StoreExistException extends BusnessException {
    public StoreExistException() {
        super("store-2", HttpStatus.BAD_REQUEST);
    }
}
