package com.fly.exception;

/**
 * @author david
 * @date 23/08/18 16:42
 */
public class SqlErrorException extends RuntimeException {

    private String message;

    public SqlErrorException(String message) {
        this.message = message;
    }
}
