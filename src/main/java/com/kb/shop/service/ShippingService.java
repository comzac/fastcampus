package com.kb.shop.service;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.domain.enums.ShippingStatus;
import com.kb.shop.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShippingService {

    @Autowired
    ShippingRepository shippingRepository;

    public ShippingInfo getShippingInfo(Long id) {
        return shippingRepository.selectShippingInfo(id);
    }

    public ShippingInfo setShippingInfo(ShippingInfo shippingInfo) {
        return shippingRepository.setShippingInfo(shippingInfo); // 예시로 저장하고 반환
    }

    public void updateShippingStatus(Long id, ShippingStatus status) {
        shippingRepository.updateShippingStatus(id, status);
    }
}
