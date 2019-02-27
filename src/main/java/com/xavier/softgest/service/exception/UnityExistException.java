package com.xavier.softgest.service.exception;

import org.springframework.http.HttpStatus;

public class UnityExistException extends BusnessException {
    public UnityExistException() {
        super("unity-2", HttpStatus.BAD_REQUEST);
    }
}
