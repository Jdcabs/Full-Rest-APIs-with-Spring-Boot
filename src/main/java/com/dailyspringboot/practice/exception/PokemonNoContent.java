package com.dailyspringboot.practice.exception;

public class PokemonNoContent extends RuntimeException{

    public PokemonNoContent(String message) {
        super(message);
    }
}
