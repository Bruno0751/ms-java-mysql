package com.dev.ms_java_mysql.exception;

public class EventFullException extends RuntimeException {

    public EventFullException() {
        super("EventFullException");
    }

    public EventFullException(String menssage) {
        super(menssage);
    }

}
