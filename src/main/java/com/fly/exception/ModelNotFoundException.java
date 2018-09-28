package com.fly.exception;

public class ModelNotFoundException extends RuntimeException {

    private String message;

    public ModelNotFoundException(String message) {
        this.message = "Model not found exception : " + message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
