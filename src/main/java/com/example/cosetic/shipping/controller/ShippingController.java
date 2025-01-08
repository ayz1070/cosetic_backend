package com.example.cosetic.shipping.controller;

import com.example.cosetic.shipping.domain.Shipping;
import com.example.cosetic.shipping.service.ShippingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/shipping")
public class ShippingController {

    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    // 배송 목록 조회
    @GetMapping("/list")
    public String listShippings(Model model) {
        model.addAttribute("shippings", shippingService.getAllShippings());
        return "shippings/shipping-list";
    }

    // 배송 등록 페이지
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("shippingForm", new ShippingForm());
        return "shippings/shipping-form";
    }

    // 특정 ID의 배송 상세 조회 + 택배사 홈페이지 리다이렉트
    @GetMapping("/{id}/track")
    public String trackShipping(@PathVariable Long id) {
        Shipping shipping = shippingService.getShipping(id);
        String trackingLink = shippingService.getTrackingLink(shipping);
        return "redirect:" + trackingLink; // 택배사 홈페이지로 리다이렉트
    }

    @PostMapping("/new")
    public String createShipping(@ModelAttribute("shippingForm") ShippingForm form) {
        shippingService.createShipping(form.getOrderId(), form.getTrackingNumber(), form.getCarrier());
        return "redirect:/shipping/list"; // 등록 후 목록 페이지로 리다이렉트
    }
}