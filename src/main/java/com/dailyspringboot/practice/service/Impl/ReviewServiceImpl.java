package com.dailyspringboot.practice.service.Impl;

import com.dailyspringboot.practice.dto.ReviewDto;
import com.dailyspringboot.practice.exception.PokemonNotFound;
import com.dailyspringboot.practice.model.Pokemon;
import com.dailyspringboot.practice.model.Review;
import com.dailyspringboot.practice.repository.PokemonRepository;
import com.dailyspringboot.practice.repository.ReviewRepository;
import com.dailyspringboot.practice.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final PokemonRepository pokemonRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository, PokemonRepository pokemonRepository) {
        this.reviewRepository = reviewRepository;
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public ReviewDto createReview(Long id, ReviewDto reviewDto) {
        Review review = mapToReview(reviewDto);

        Pokemon pokemon =
               pokemonRepository.findById(id).orElseThrow(() -> new PokemonNotFound("Pokemon with Id of " + id + " doesn't exist"));

        review.setPokemons(pokemon);

        Review saveReview = reviewRepository.save(review);

        return mapToReviewDto(saveReview);
    }

    private ReviewDto mapToReviewDto(Review review) {
        return ReviewDto.builder()
                .id(review.getId())
                .stars(review.getStar())
                .title(review.getTitle())
                .content(review.getContent())
                .build();
    }

    private Review mapToReview(ReviewDto reviewDto) {
        return Review.builder()
                .stars(reviewDto.getStars())
                .content(reviewDto.getContent())
                .title(reviewDto.getTitle())
                .build();
    }
}
