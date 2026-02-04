package com.dev_akashyadav.SmartEmployeeManagementSystem.exception;

import com.dev_akashyadav.SmartEmployeeManagementSystem.dto.response.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<Object> handleNotFound(ResourceNotFound ex){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponseDTO(
                        ex.getMessage(),
                        HttpStatus.NOT_FOUND.value(),
                        ex.getClass().getSimpleName()));
    }
}
