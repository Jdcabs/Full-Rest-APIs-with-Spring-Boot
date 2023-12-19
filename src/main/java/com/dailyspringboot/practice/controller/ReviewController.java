package com.dailyspringboot.practice.controller;

import com.dailyspringboot.practice.dto.ReviewDto;
import com.dailyspringboot.practice.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/review/created/{pokemonId}")
    public ResponseEntity<ReviewDto> createNewReview(@PathVariable("pokemonId") Long id, @RequestBody ReviewDto reviewDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.createReview(id, reviewDto));
    }

    @GetMapping("/review/{id}/pokemon")
    public ResponseEntity<List<ReviewDto>> getAllReviewsByPokemonId(@PathVariable("id") Long pokemonId) {
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.findAllReviewByPokemonId(pokemonId));
    }

    @GetMapping("/pokemon/{pokemonId}/review/{reviewId}")
    public ResponseEntity<ReviewDto> getReviewByPokemonId(
            @PathVariable(name = "pokemonId") Long pokemonId,
            @PathVariable(name = "reviewId") Long reviewId)
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(reviewService.findReviewByPokemonId(pokemonId, reviewId));
    }

    @PutMapping("/pokemon/{pokemonId}/review/{reviewId}/updated")
    public ResponseEntity<ReviewDto> updateExistingReview(
            @PathVariable(name = "pokemonId") Long pokemonId,
            @PathVariable(name = "reviewId") Long reviewId,
            @RequestBody ReviewDto reviewDto)
    {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(reviewService.updateReview(pokemonId,reviewId,reviewDto));
    }
}
