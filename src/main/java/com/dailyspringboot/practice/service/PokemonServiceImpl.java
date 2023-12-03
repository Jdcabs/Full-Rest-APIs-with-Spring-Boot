package com.dailyspringboot.practice.service;

import com.dailyspringboot.practice.dto.PokemonDto;
import com.dailyspringboot.practice.model.Pokemon;
import com.dailyspringboot.practice.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;
    @Autowired
    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public PokemonDto createPokemon(PokemonDto pokemonDto) {
        Pokemon pokemon = Pokemon.builder()
                .pokemonType(pokemonDto.getPokemonType())
                .pokemonName(pokemonDto.getPokemonName())
                .id(pokemonDto.getId())
                .build();

        Pokemon newPokemon = pokemonRepository.save(pokemon);

        return new PokemonDto(newPokemon.getId(), newPokemon.getPokemonName(), newPokemon.getPokemonType());
    }
}

