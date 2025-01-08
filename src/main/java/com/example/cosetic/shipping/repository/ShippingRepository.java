package com.example.cosetic.shipping.repository;

import com.example.cosetic.shipping.domain.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {

}
