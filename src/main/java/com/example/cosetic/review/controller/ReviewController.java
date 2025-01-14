package com.example.cosetic.review.controller;

import com.example.cosetic.review.domain.Review;
import com.example.cosetic.review.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 리뷰 추가
    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        Review savedReview = reviewService.addReview(review);
        return ResponseEntity.ok(savedReview);
    }

    // 특정 상품의 최신순 리뷰 조회
    @GetMapping("/product/{productId}/latest")
    public ResponseEntity<List<Review>> getLatestReviews(@PathVariable Long productId) {
        List<Review> reviews = reviewService.getLatestReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    // 특정 상품의 평점 높은 순 리뷰 조회
    @GetMapping("/product/{productId}/top-rated")
    public ResponseEntity<List<Review>> getTopRatedReviews(@PathVariable Long productId) {
        List<Review> reviews = reviewService.getTopRatedReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    // 특정 상품의 평점 낮은 순 리뷰 조회
    @GetMapping("/product/{productId}/lowest-rated")
    public ResponseEntity<List<Review>> getLowestRatedReviews(@PathVariable Long productId) {
        List<Review> reviews = reviewService.getLowestRatedReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    // 리뷰 수정
    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable Long reviewId, @RequestBody Review updatedReview) {
        Review updated = reviewService.updateReview(reviewId, updatedReview);
        return ResponseEntity.ok(updated);
    }

    // 리뷰 삭제
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }
}