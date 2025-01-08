package com.example.cosetic.shipping.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShippingCreateRequest {

    private Long orderId;
    private String trackingNumber;
    private String carrier;

}
