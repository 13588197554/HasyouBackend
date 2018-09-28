package com.fly.enums;

public enum TypeEnum {

    HOT("HOT"),
    LATEST("LATEST"),
    HIGH_ANON("高匿"),
    TRANSPARENCY("透明");

    private String name;

    TypeEnum(String name) {
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
