package com.dailyspringboot.practice.exception;

public class PokemonNotFound extends RuntimeException{

    public PokemonNotFound(String message) {
        super(message);
    }
}
