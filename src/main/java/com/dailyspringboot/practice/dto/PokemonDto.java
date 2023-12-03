package com.dailyspringboot.practice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

@Builder
public class PokemonDto {
    @Id
//    @GeneratedValue(generator = "Pokemon_Sequence", strategy = GenerationType.AUTO)
//    @SequenceGenerator(allocationSize = 1,sequenceName = "Pokemon_Sequence", name = "Pokemon_Sequence")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = 0L;
    @Column(length = 100)
    private String pokemonName;
    @Column(length = 100)
    private String pokemonType;

    public PokemonDto() {
    }

    public PokemonDto(Long id, String pokemonName, String pokemonType) {
        this.id = id;
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    public Long getId() {
        return id;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public void setPokemonType(String pokemonType) {
        this.pokemonType = pokemonType;
    }
}
