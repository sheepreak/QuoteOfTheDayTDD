package com.sheepreak.quoteoftheday.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<String> onConstraintViolation() {
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
}
