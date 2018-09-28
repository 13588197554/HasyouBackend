package com.fly.enums;

/**
 * @author david
 * @date 27/08/18 14:54
 */
public enum  ScopeEnum {

    ALL("ALL"),
    TOP5("TOP5");

    private String name;

    ScopeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeEnum{" +
                "name='" + name + '\'' +
                '}';
    }

}
