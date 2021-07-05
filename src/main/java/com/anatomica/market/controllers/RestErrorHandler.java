package com.anatomica.market.controllers;

import com.anatomica.market.exceptions.MarketError;
import com.anatomica.market.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleRNFException(ProductNotFoundException nfe) {
        MarketError error = new MarketError(HttpStatus.NOT_FOUND.value(), nfe.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}