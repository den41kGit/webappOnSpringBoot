package com.den.example.exception;
//TODO: а тут есть)
public class UsersNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UsersNotFoundException() {
    }

    public UsersNotFoundException(String message) {
        super(message);
    }
}
