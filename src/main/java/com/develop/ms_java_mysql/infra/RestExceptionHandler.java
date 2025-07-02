package com.develop.ms_java_mysql.infra;

import com.develop.ms_java_mysql.exception.EventFullException;
import com.develop.ms_java_mysql.exception.EventNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EventFullException.class)
    private ResponseEntity<String> eventFullHandler(EventFullException exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Event is full");
    }

    @ExceptionHandler(EventNotFoundExeption.class)
    private ResponseEntity<String> eventNotFoundHandler(EventNotFoundExeption exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found");
    }
}
