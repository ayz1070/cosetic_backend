package com.example.cosetic.shipping.dto;

import com.example.cosetic.shipping.domain.ShippingStatus;
import lombok.Getter;

@Getter
public class ShippingResponse {

    // getter
    private final Long shippingId;
    private final Long orderId;
    private final String trackingNumber;
    private final String carrier;
    private final ShippingStatus status;

    // 택배사 홈페이지 링크 (프론트엔드에서 생성해도 되고, 백엔드에서 생성해도 됨)
    private final String trackingLink;

    public ShippingResponse(Long shippingId, Long orderId, String trackingNumber,
                            String carrier, ShippingStatus status, String trackingLink) {
        this.shippingId = shippingId;
        this.orderId = orderId;
        this.trackingNumber = trackingNumber;
        this.carrier = carrier;
        this.status = status;
        this.trackingLink = trackingLink;
    }
}