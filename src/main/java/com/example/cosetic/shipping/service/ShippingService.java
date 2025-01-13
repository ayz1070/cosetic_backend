package com.example.cosetic.shipping.service;

import com.example.cosetic.shipping.domain.Shipping;
import com.example.cosetic.shipping.repository.ShippingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ShippingService {

    private final ShippingRepository shippingRepository;

    // 각 택배사별 URL 매핑
    private static final Map<String, String> COURIER_URLS = new HashMap<>() {{
        put("CJ대한통운", "https://www.cjlogistics.com/ko/tool/parcel/tracking?gnbInvcNo=");
        put("한진택배", "http://www.hanjin.co.kr/kor/CMS/DeliveryMgr/WaybillResult.do?mCode=MN038&wblNum=");
        // 필요한 다른 택배사도 추가
    }};

    public ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    // 배송 등록
    public Shipping createShipping(Long orderId, String trackingNumber, String carrier) {
        Shipping shipping = new Shipping(orderId, trackingNumber, carrier);
        return shippingRepository.save(shipping);
    }

    // 목록 조회
    @Transactional(readOnly = true)
    public List<Shipping> getAllShippings() {
        return shippingRepository.findAll();
    }

    // 단건 조회
    @Transactional(readOnly = true)
    public Shipping getShipping(Long id) {
        return shippingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 배송정보가 없습니다. id = " + id));
    }

    // 택배사 홈페이지 트래킹 URL 생성
    public String getTrackingLink(Shipping shipping) {
        String courier = shipping.getCarrier();
        String baseUrl = COURIER_URLS.getOrDefault(courier, null);
        if (baseUrl == null) {
            throw new RuntimeException("지원하지 않는 택배사입니다: " + courier);
        }
        return baseUrl + shipping.getTrackingNumber();
    }
}
