package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Hystrix控制器
 */
@RestController
@Slf4j
public class HystrixPaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private HystrixService hystrixService;

    @GetMapping("/hystrix/getOk/{id}")
    public String getPaymentInfo_ok(@PathVariable("id") Long id) {
        String result = hystrixService.getPaymentInfo_ok(id);
        log.info(result);
        return result;
    }

    @GetMapping("/hystrix/getTimeout/{id}")
    public String getPaymentInfo_timeout(@PathVariable("id") Long id) {
        String result = hystrixService.getPaymentInfo_timeout(id);
        log.info(result);
        return result;
    }

    @GetMapping("/payment/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        String result = hystrixService.paymentCircuitBreaker(id);
        log.info(result);
        return result;
    }
}
