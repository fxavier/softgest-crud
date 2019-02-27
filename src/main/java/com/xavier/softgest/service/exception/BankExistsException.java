package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class BankExistsException extends BusnessException {
    public BankExistsException() {
        super("bank-2", HttpStatus.BAD_REQUEST);
    }
}
