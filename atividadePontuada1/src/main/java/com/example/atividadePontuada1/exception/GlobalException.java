package com.example.atividadePontuada1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler (RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRunTimeException (RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("Mensagem", ex.getMessage()));
    }
    @ExceptionHandler (IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalAccessException(IllegalArgumentException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Map.of("Mensagem", ex.getMessage()));
    }
}
