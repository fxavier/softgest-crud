package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class BankNotFoundException extends BusnessException {
    public BankNotFoundException() {
        super("bank-3", HttpStatus.BAD_REQUEST);
    }
}
