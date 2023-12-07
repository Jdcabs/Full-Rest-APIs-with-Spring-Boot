package com.dailyspringboot.practice.service;

import com.dailyspringboot.practice.dto.PokemonDto;
import com.dailyspringboot.practice.dto.PokemonResponse;

import java.util.List;

public interface PokemonService {
    PokemonDto createPokemon(PokemonDto pokemonDto);
    List<PokemonDto> getAllPokemon();
    PokemonDto findPokemonById(Long id);
    PokemonDto updatePokemon(PokemonDto pokemonDto, Long id);
    void deleteExistingPokemonById(Long id);
    List<PokemonDto> getAllPokemonInPagination(int page, int pageSize);

    PokemonResponse getPokemonByPokemonResponse(int page, int pageSize);
}
