package com.dailyspringboot.practice.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "tbl_pokemon")
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String pokemonName;
    @Column(length = 100)
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
