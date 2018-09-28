package com.fly.pojo.vo;

import java.util.Map;

/**
 * @author david
 * @date 04/08/18 18:49
 */
public class InputParam {

    private Map body;

    public Map getBody() {
        return body;
    }

    public void setBody(Map body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "InputParam{" +
                "body=" + body +
                '}';
    }
}
