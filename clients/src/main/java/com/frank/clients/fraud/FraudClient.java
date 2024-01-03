package com.frank.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 透過 FeignClient 偽裝 http 請求，讓其他 service 直接調用 interface
@FeignClient("fraud")
public interface FraudClient {

    @GetMapping("/api/v1/fraud-check/{customerId}")
    FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);
}
