package com.dailyspringboot.practice.controller;

import com.dailyspringboot.practice.dto.PokemonDto;
import com.dailyspringboot.practice.dto.PokemonResponse;
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
    public ResponseEntity<List<PokemonDto>> getAllPokemon() {
        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.getAllPokemon());
    }

    @GetMapping("/pokemon/pageable")
    public ResponseEntity<List<PokemonDto>> getAllPokemonInPageable(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(pokemonService.getAllPokemonInPagination(pageNo,pageSize));
    }

    @GetMapping("/pokemon/response")
    public ResponseEntity<PokemonResponse> getAllPokemonInPokemonResponse(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(pokemonService.getPokemonByPokemonResponse(pageNo,pageSize));
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<PokemonDto> getPokemonById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(pokemonService.findPokemonById(id));
    }

    @PostMapping("/pokemon/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PokemonDto> createNewPokemon(@RequestBody PokemonDto pokemonDto) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(pokemonService.createPokemon(pokemonDto));
    }

    @PutMapping("/pokemon/{id}/updated")
    public ResponseEntity<PokemonDto> updateExistingPokemon(@RequestBody PokemonDto pokemonDto,
                                                            @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(pokemonService.updatePokemon(pokemonDto,id));
    }

    @DeleteMapping("/pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemonById(@PathVariable(name = "id") Long id) {
        pokemonService.deleteExistingPokemonById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted the pokemon");
    }
}