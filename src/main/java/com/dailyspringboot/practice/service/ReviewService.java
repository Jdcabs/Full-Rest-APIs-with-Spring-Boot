package com.dailyspringboot.practice.service;

import com.dailyspringboot.practice.dto.ReviewDto;

public interface ReviewService {
    ReviewDto createReview(Long id, ReviewDto reviewDto);
}
