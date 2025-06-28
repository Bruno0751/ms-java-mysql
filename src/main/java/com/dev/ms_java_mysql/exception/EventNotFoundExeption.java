package com.dev.ms_java_mysql.exception;

public class EventNotFoundExeption extends RuntimeException {

    public EventNotFoundExeption() {
        super("EventNotFoundExeption");
    }

    public EventNotFoundExeption(String menssage) {
        super(menssage);
    }
}
