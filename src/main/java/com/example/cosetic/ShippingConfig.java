package com.example.cosetic;

import com.example.cosetic.shipping.controller.ShippingController;
import com.example.cosetic.shipping.repository.ShippingRepository;
import com.example.cosetic.shipping.service.ShippingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShippingConfig {

    /**
     * 스프링 데이터 JPA가 ShippingRepository를 구현체로 자동 빈 등록해주므로
     * 생성자 파라미터로 주입받을 수 있다.
     */
    private final ShippingRepository shippingRepository;

    // 스프링이 ShippingRepository 빈을 찾아 주입해준다.
    public ShippingConfig(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    // 1) ShippingService를 직접 @Bean 등록
    @Bean
    public ShippingService shippingService() {
        return new ShippingService(shippingRepository);
    }

    // 2) ShippingController도 직접 @Bean 등록하려면:
    //   (단, 중복 빈 등록되지 않도록 클래스에서 @RestController 제거해야 함)
    @Bean
    public ShippingController shippingController() {
        return new ShippingController(shippingService());
    }
}
