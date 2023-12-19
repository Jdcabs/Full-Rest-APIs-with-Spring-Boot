package com.dailyspringboot.practice.service;

import com.dailyspringboot.practice.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(Long id, ReviewDto reviewDto);

    List<ReviewDto> findAllReviewByPokemonId(Long id);

    ReviewDto findReviewByPokemonId(Long pokemonId, Long reviewId);
    ReviewDto updateReview(Long pokemonId, Long reviewId, ReviewDto reviewDto);
}
