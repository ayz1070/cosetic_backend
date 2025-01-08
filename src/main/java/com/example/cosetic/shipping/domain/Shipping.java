package com.example.cosetic.shipping.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name = "shipping")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private String trackingNumber;  // 수동 입력
    private String carrier;         // "CJ대한통운", "한진택배" 등

    public Shipping() {
    }

    public Shipping(Long orderId, String trackingNumber, String carrier) {
        this.orderId = orderId;
        this.trackingNumber = trackingNumber;
        this.carrier = carrier;
    }

}