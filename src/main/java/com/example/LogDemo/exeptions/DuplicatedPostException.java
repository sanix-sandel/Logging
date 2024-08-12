package com.example.LogDemo.exeptions;

public class DuplicatedPostException extends RuntimeException{

    public DuplicatedPostException(String message) {
        super(message);
    }
}
