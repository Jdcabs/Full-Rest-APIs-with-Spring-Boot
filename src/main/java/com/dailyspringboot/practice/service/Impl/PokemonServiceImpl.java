package com.dailyspringboot.practice.service.Impl;

import com.dailyspringboot.practice.dto.PokemonDto;
import com.dailyspringboot.practice.model.Pokemon;
import com.dailyspringboot.practice.repository.PokemonRepository;
import com.dailyspringboot.practice.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<PokemonDto> getAllPokemon() {
        List<Pokemon> listPokemon = pokemonRepository.findAll();
        return listPokemon.stream().map(p -> mapToPokemongDto(p)).collect(Collectors.toList());
    }

    private PokemonDto mapToPokemongDto(Pokemon pokemon) {
        PokemonDto pokemonDto = PokemonDto.builder()
                .id(pokemon.getId())
                .pokemonName(pokemon.getPokemonName())
                .pokemonType(pokemon.getPokemonType())
                .build();
        return pokemonDto;
    }

    private Pokemon mapToPokemon(PokemonDto pokemonDto) {
        Pokemon pokemon = Pokemon.builder()
                .pokemonName(pokemonDto.getPokemonName())
                .pokemonType(pokemonDto.getPokemonType())
                .build();
        return  pokemon;
    }
}

