package com.example.cosetic.review.service;

import com.example.cosetic.review.domain.Review;
import com.example.cosetic.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    // 리뷰 추가
    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    // 특정 상품의 최신순 리뷰 조회
    public List<Review> getLatestReviewsByProductId(Long productId) {
        return reviewRepository.findByProductIdOrderByCreatedAtDesc(productId);
    }

    // 특정 상품의 평점 높은 순 리뷰 조회
    public List<Review> getTopRatedReviewsByProductId(Long productId) {
        return reviewRepository.findByProductIdOrderByRatingDesc(productId);
    }

    // 특정 상품의 평점 낮은 순 리뷰 조회
    public List<Review> getLowestRatedReviewsByProductId(Long productId) {
        return reviewRepository.findByProductIdOrderByRatingAsc(productId);
    }

    // 리뷰 수정
    public Review updateReview(Long reviewId, Review updatedReview) {
        return reviewRepository.findById(reviewId).map(review -> {
            review.setRating(updatedReview.getRating());
            review.setContent(updatedReview.getContent());
            review.setSkinTrouble(updatedReview.getSkinTrouble());
            review.setImageUrls(updatedReview.getImageUrls());
            return reviewRepository.save(review);
        }).orElseThrow(() -> new RuntimeException("Review not found with id " + reviewId));
    }

    // 리뷰 삭제
    public void deleteReview(Long reviewId) {
        if (reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
        } else {
            throw new RuntimeException("Review not found with id " + reviewId);
        }
    }
}