package com.dailyspringboot.practice.controller;

import com.dailyspringboot.practice.dto.PokemonDto;
import com.dailyspringboot.practice.model.Pokemon;
import com.dailyspringboot.practice.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PokemonController {

    private final PokemonService pokemonService;
    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

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
    public ResponseEntity<PokemonDto> createNewPokemon(@RequestBody PokemonDto pokemonDto) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(pokemonService.createPokemon(pokemonDto));
    }
}