package com.thoughtworks.capability.gtb.restfulapidesign.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleIllegalArgumentException(IllegalArgumentException ex) {
        CommonError commonError = new CommonError(HttpStatus.BAD_REQUEST.value(),ex.getMessage());
        return ResponseEntity.badRequest().body(commonError);
    }
}