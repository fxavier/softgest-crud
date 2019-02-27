package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class StoreNotFoundException extends BusnessException {
    public StoreNotFoundException() {
        super("store-3", HttpStatus.BAD_REQUEST);
    }
}
