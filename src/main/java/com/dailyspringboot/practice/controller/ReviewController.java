package com.dailyspringboot.practice.controller;

import com.dailyspringboot.practice.dto.ReviewDto;
import com.dailyspringboot.practice.model.Review;
import com.dailyspringboot.practice.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/review/created/{pokemonId}")
    public ResponseEntity<ReviewDto> createNewReview(@PathVariable("pokemonId") Long id, @RequestBody ReviewDto reviewDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.createReview(id, reviewDto));
    }
}
