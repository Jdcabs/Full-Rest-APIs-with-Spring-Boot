package com.dailyspringboot.practice.model;

import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class Pokemon {
    private Long id;
    private String pokemonName;
    private String pokemonType;

    public Pokemon(){}

    public Pokemon(Long id, String pokemonName, String pokemonType) {
        setId(id);
        setPokemonName(pokemonName);
        setPokemonType(pokemonType);
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

    public Long getId() {
        return id;
    }
    public String getPokemonName() {
        return pokemonName;
    }
    public String getPokemonType() {
        return pokemonType;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", pokemonName='" + pokemonName + '\'' +
                ", pokemonType='" + pokemonType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(getId(), pokemon.getId()) && Objects.equals(getPokemonName(), pokemon.getPokemonName()) && Objects.equals(getPokemonType(), pokemon.getPokemonType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPokemonName(), getPokemonType());
    }
}
