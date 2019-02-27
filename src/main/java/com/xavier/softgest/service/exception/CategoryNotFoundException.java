package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class CategoryNotFoundException extends BusnessException {
    public CategoryNotFoundException() {
        super("category-3", HttpStatus.BAD_REQUEST);
    }
}
