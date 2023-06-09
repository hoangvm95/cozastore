package com.example.CozaStore.exception;

public class UserNotFoundException extends RuntimeException {
    private int statusCode;

    private String message;

    public UserNotFoundException( int statusCode,String message) {
        this.message=message;
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
