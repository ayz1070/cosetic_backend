package com.example.cosetic.shipping.controller;

import com.example.cosetic.shipping.dto.ShippingResponse;
import com.example.cosetic.shipping.service.ShippingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/shipping")
public class ShippingRestController {

    private final ShippingService shippingService;

    public ShippingRestController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping("/list")
    public List<ShippingResponse> listShippings() {
        return shippingService.getAllShippings().stream()
                .map(shipping -> new ShippingResponse(
                        shipping.getId(),
                        shipping.getOrderId(),
                        shipping.getTrackingNumber(),
                        shipping.getCarrier(),
                        null,
                        shippingService.getTrackingLink(shipping)
                ))
                .collect(Collectors.toList());
    }
}