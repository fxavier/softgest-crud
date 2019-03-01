package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class UnityNotFoundException extends BusnessException {
    public UnityNotFoundException() {
        super("unity-3", HttpStatus.BAD_REQUEST);
    }
}
