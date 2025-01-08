package com.example.cosetic.shipping.controller;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShippingForm {
    private Long orderId;
    private String trackingNumber;
    private String carrier;
}