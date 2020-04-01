package com.atguigu.springcloud.service;

public interface HystrixService {

    String getPaymentInfo_ok(Long id);

    String getPaymentInfo_timeout(Long id);

    String getPaymentInfo_timeoutHandler(Long id);

    public String paymentCircuitBreaker(Long id);

}
