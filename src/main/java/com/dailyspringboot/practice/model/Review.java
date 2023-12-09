package com.dailyspringboot.practice.model;

import jakarta.persistence.*;
import lombok.Builder;

@Entity(name = "tbl_review")
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 150)
    private String title;
    private String content;
    private int stars;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemons;

    public Review(){}

    public Review(Long id, String title, String content, int stars, Pokemon pokemons) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.stars = stars;
        this.pokemons = pokemons;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getStar() {
        return stars;
    }

    public Pokemon getPokemons() {
        return pokemons;
    }

    public void setPokemons(Pokemon pokemons) {
        this.pokemons = pokemons;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
