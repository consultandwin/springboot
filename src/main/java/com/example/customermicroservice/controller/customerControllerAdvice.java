package com.example.customermicroservice.controller;

import com.example.customermicroservice.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class customerControllerAdvice {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> processValidationError(CustomerNotFoundException ex) {
        String result = ex.getErrorMessage();
        System.out.println("########### "+result);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);

    }

}
