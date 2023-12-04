package com.dailyspringboot.practice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PokemonNotFound.class)
    public ResponseEntity<ErrorObject> handlePokemonNotFoundException(PokemonNotFound ex, WebRequest webRequest) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value())
                .body(new ErrorObject(HttpStatus.NOT_FOUND.value(), ex.getMessage(), new Date()));
    }

    @ExceptionHandler(PokemonNoContent.class)
    public ResponseEntity<ErrorObject> handlePokemonNotFoundExceptionForDeleteMapping(PokemonNoContent ex, WebRequest webRequest) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT.value())
                .body(new ErrorObject(HttpStatus.NO_CONTENT.value(), ex.getMessage(), new Date()));
    }
}
