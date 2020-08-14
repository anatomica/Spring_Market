package com.anatomica.market.controllers;

import com.anatomica.market.exceptions.NotFoundException;
import com.anatomica.market.utils.SecurityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public SecurityResponse handleSecurityException(NotFoundException nfe) {
        SecurityResponse response = new SecurityResponse(nfe.getMessage());
        return response;
    }
}