package com.fly.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author david
 * @date 04/08/18 14:16
 */
@RestController
@RequestMapping("/base")
public class BaseController<T> {

    public void validateParam(T t, Class clazz) {

    }

    public void validateInt() {

    }

    public void validateString() {

    }

    public void validateJson() {

    }

    public void validateList() {

    }

    /**
     * check param non-negative
     * @param v
     * @param defaultValue
     */
    public int validateIntNNWithDefaultValue(int v, int defaultValue) {
        if (v <= 0) {
            v = defaultValue;
        }
        return v;
    }

    @GetMapping("/get/pp")
    public String getPP(HttpServletRequest request) {
        String ip = request.getRemoteHost();
        int port = request.getRemotePort();
        return ip + ":" + port;
    }

}
