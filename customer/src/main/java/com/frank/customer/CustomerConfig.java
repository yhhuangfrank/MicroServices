package com.frank.customer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

    @Bean
    @LoadBalanced // 使 http 請求進行負載均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
