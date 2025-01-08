package com.example.cosetic.shipping.domain;

public enum ShippingStatus {
    READY,     // 배송 준비 중
    SHIPPED,   // 배송 중
    DELIVERED  // 배송 완료 (수동으로 변경)
}