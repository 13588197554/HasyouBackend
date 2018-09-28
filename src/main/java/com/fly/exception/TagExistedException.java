package com.fly.exception;

public class TagExistedException {

    public TagExistedException() {
        throw new RuntimeException("tag has already existed!");
    }

}
