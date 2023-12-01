package com.dailyspringboot.practice.controller;

import com.dailyspringboot.practice.model.Pokemon;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
public class PokemonController {

    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        List<Pokemon> listOfPokemon = new ArrayList<>(List.of(
                        new Pokemon(1L, "Charmander", "Fire"),
                        new Pokemon(2L,"Pickachu", "Lightning")));
        return ResponseEntity.status(HttpStatus.OK).body(listOfPokemon);
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Long id) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("custom-header", "FOUND A POKEMON");
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .headers(httpHeaders)
                .body(new Pokemon(1L, "Pokemon", "Lightning"));
    }

    @PostMapping("/pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pokemon> createNewPokemon(@RequestBody Pokemon pokemon) {
        System.out.println(pokemon.getPokemonName());
        System.out.println(pokemon.getPokemonType());
        return  ResponseEntity.status(HttpStatus.CREATED).body(pokemon);
    }
}