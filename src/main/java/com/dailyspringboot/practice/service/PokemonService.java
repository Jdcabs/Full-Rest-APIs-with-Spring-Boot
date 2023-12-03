package com.dailyspringboot.practice.service;

import com.dailyspringboot.practice.dto.PokemonDto;

import java.util.List;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);

    List<PokemonDto> getAllPokemon();
    PokemonDto findPokemonById(Long id);

}
