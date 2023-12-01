package com.dailyspringboot.practice.controller;

import com.dailyspringboot.practice.model.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PokemonController {

    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        List<Pokemon> listOfPokemon =
                new ArrayList<>(List.of(
                        new Pokemon(1L, "Charmander", "Fire"),
                        new Pokemon(2L,"Pickachu", "Lightning")));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listOfPokemon);
    }
}
