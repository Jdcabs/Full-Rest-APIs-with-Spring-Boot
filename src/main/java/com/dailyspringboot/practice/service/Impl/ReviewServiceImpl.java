package com.dailyspringboot.practice.service.Impl;

import com.dailyspringboot.practice.dto.ReviewDto;
import com.dailyspringboot.practice.exception.PokemonNotFound;
import com.dailyspringboot.practice.exception.ReviewNotFound;
import com.dailyspringboot.practice.model.Pokemon;
import com.dailyspringboot.practice.model.Review;
import com.dailyspringboot.practice.repository.PokemonRepository;
import com.dailyspringboot.practice.repository.ReviewRepository;
import com.dailyspringboot.practice.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public List<ReviewDto> findAllReviewByPokemonId(Long id) {
        List<Review> listOfReviews = reviewRepository.findByPokemonsId(id);

        return listOfReviews.stream().map(list -> mapToReviewDto(list)).collect(Collectors.toList());
    }

    @Override
    public ReviewDto findReviewByPokemonId(Long pokemonId, Long reviewId) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new PokemonNotFound("Pokemon not found"));

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new ReviewNotFound("Review not found"));

        if(!pokemon.getId().equals(review.getId())) {
            throw new ReviewNotFound("Review with pokemon id doesn't exist");
        }

        return mapToReviewDto(review);
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
