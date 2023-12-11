package com.dailyspringboot.practice.service;

import com.dailyspringboot.practice.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto createReview(Long id, ReviewDto reviewDto);

    List<ReviewDto> findReviewByPokemonId(Long id);
}
