package com.dev.ms_java_mysql.exception.infra;

import com.dev.ms_java_mysql.exception.EventFullException;
import com.dev.ms_java_mysql.exception.EventNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.w3c.dom.events.EventException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(EventFullException.class)
//    private ResponseEntity<String> eventFullHandler(EventFullException exception) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Event is full");
//    }

    @ExceptionHandler(EventNotFoundExeption.class)
    private ResponseEntity<String> eventNotFoundHandler(EventNotFoundExeption exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Event not found");
    }
}
