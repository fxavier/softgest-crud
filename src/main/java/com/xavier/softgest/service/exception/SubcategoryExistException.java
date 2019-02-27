package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class SubcategoryExistException extends BusnessException {
    public SubcategoryExistException() {
        super("subcategory-3", HttpStatus.BAD_REQUEST);
    }
}
