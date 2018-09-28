package com.fly.pojo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {

    private Integer code = 200;
    private String message = "operate success!";
    private StackTraceElement[] stackTrace;
    private T data;

    public Result ok(T o) {
        this.data = o;
        return this;
    }

    public Result error(Integer code, String message, StackTraceElement[] stackTrace) {
        this.code = code;
        this.message = message;
        this.stackTrace = stackTrace;
        return this;
    }

    public Result error(Integer code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public StackTraceElement[] getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(StackTraceElement[] stackTrace) {
        this.stackTrace = stackTrace;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", stackTrace='" + stackTrace + '\'' +
                ", data=" + data +
                '}';
    }
}
