package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class SubcategoryNotFoundException extends BusnessException {
    public SubcategoryNotFoundException() {
        super("subcategory-4", HttpStatus.BAD_REQUEST);
    }
}
