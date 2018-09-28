package com.fly.exception;

public class FileUploadException extends Throwable {

    public FileUploadException() {
        throw new RuntimeException("File upload fail!");
    }

}
