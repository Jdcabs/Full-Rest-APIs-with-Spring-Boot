package com.dailyspringboot.practice.repository;

import com.dailyspringboot.practice.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon,Long> {

    Optional<Pokemon> findByPokemonNameStartsWithIgnoreCase(@NonNull String pokemonName);

    Optional<Pokemon> findByIdBetween(Long idStart, Long idEnd);

}
