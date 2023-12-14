package com.dailyspringboot.practice.exception;

public class ReviewNotFound extends RuntimeException{

    public ReviewNotFound(String message) {
        super(message);
    }
}
