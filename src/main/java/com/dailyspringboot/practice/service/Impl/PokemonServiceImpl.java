package com.dailyspringboot.practice.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import com.dailyspringboot.practice.dto.PokemonResponse;
import com.dailyspringboot.practice.exception.PokemonNoContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dailyspringboot.practice.dto.PokemonDto;
import com.dailyspringboot.practice.exception.PokemonNotFound;
import com.dailyspringboot.practice.model.Pokemon;
import com.dailyspringboot.practice.repository.PokemonRepository;
import com.dailyspringboot.practice.service.PokemonService;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;
    
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

        return mapToPokemongDto(newPokemon);
    }

    @Override
    public List<PokemonDto> getAllPokemon() {
        List<Pokemon> listPokemon = pokemonRepository.findAll();
        if(listPokemon.isEmpty()) {
            throw new PokemonNotFound("There is no existing Pokemon in the Database.");
        }
        return listPokemon.stream().map(p -> mapToPokemongDto(p)).collect(Collectors.toList());
    }

    @Override
    public PokemonDto findPokemonById(Long id) {
        if(pokemonRepository.findById(id).isEmpty()){
            throw new PokemonNotFound("Pokemon with id of " + id + " doesn't exist in the database.");
        }
        Pokemon pokemon = pokemonRepository.findById(id).get();
        return mapToPokemongDto(pokemon);
    }
    
    @Override
    public PokemonDto updatePokemon(PokemonDto pokemonDto, Long id) {
        Pokemon pokemon =
                pokemonRepository.findById(id).orElseThrow(() -> new PokemonNotFound("Pokemon Cannot be updated."));

        pokemon.setPokemonName(pokemonDto.getPokemonName());
        pokemon.setPokemonType(pokemonDto.getPokemonType());

        Pokemon pokemonSave = pokemonRepository.save(pokemon);
        return mapToPokemongDto(pokemonSave);
    }

    @Override
    public void deleteExistingPokemonById(Long id) {
        Pokemon pokemon = pokemonRepository
                .findById(id).orElseThrow(() -> new PokemonNoContent("No pokemon to delete."));
        pokemonRepository.delete(pokemon);
    }

    @Override
    public List<PokemonDto> getAllPokemonInPagination(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Pokemon> pokemons = pokemonRepository.findAll(pageable);
        List<Pokemon> listOfPokemons = pokemons.getContent();
        return listOfPokemons.stream().map(p -> mapToPokemongDto(p)).collect(Collectors.toList());
    }

    @Override
    public PokemonResponse getPokemonByPokemonResponse(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Pokemon> pokemons = pokemonRepository.findAll(pageable);
        List<Pokemon> listOfPokemons = pokemons.getContent();

        List<PokemonDto> content = listOfPokemons.stream().map(p -> mapToPokemongDto(p))
                .collect(Collectors.toList());

        if(pokemons.isLast()) {
            throw new PokemonNoContent("No More Pokemons");
        }
        return  PokemonResponse.builder()
                .content(content)
                .pageNumber(pokemons.getNumber())
                .totalElements(pokemons.getTotalElements())
                .totalPages(pokemons.getTotalPages())
                .pageSize(pokemons.getSize())
                .last(pokemons.isLast())
                .build();
    }

    private PokemonDto mapToPokemongDto(Pokemon pokemon) {
        return PokemonDto.builder()
                .id(pokemon.getId())
                .pokemonName(pokemon.getPokemonName())
                .pokemonType(pokemon.getPokemonType())
                .build();
    }

    private Pokemon mapToPokemon(PokemonDto pokemonDto) {
        return Pokemon.builder()
                .pokemonName(pokemonDto.getPokemonName())
                .pokemonType(pokemonDto.getPokemonType())
                .build();
    }

}

