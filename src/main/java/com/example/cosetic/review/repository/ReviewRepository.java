package com.example.cosetic.review.repository;

import com.example.cosetic.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // 특정 상품의 리뷰 조회
    List<Review> findByProductId(Long productId);
    // 특정 사용자의 리뷰 조회
    List<Review> findByUserId(Long userId);
    // 특정 상품의 리뷰를 최신순으로 가져오기
    List<Review> findByProductIdOrderByCreatedAtDesc(Long productId);
    // 특정 상품의 리뷰를 평점 높은 순으로 가져오기
    List<Review> findByProductIdOrderByRatingDesc(Long productId);
    // 특정 상품의 리뷰를 평점 낮은 순으로 가져오기
    List<Review> findByProductIdOrderByRatingAsc(Long productId);
}