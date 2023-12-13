package com.jisu.load.loadapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jisu.load.loadapi.playload.ApiResponse;

@RestControllerAdvice
public class GlobalExHandler {

    @ExceptionHandler(LoadNotFoundException.class)
    public ResponseEntity<ApiResponse> handleNotFoundException(Exception ex) {
        ApiResponse response = new ApiResponse();
        response.setMsg(ex.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND);
        response.setSuccess(false);

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
