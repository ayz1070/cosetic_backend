CREATE TABLE reviews
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,                               -- 리뷰 ID
    user_id      BIGINT       NOT NULL,                                           -- 사용자 ID
    product_id   BIGINT       NOT NULL,                                           -- 상품 ID
    skin_trouble VARCHAR(255) NOT NULL,                                           -- 피부 고민
    rating DOUBLE NOT NULL CHECK (rating BETWEEN 1 AND 5),                        -- 평점 (1~5)
    content      TEXT,                                                            -- 리뷰 내용 (선택)
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,                             -- 생성 시간
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 수정 시간
    image_urls   JSON,                                                            -- 이미지 URL 리스트
    FOREIGN KEY (user_id) REFERENCES users (id),                                  -- 유저 테이블과 연결
    FOREIGN KEY (product_id) REFERENCES products (id)                             -- 상품 테이블과 연결
);