package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * zkOrder
 */
@RestController
@Slf4j
public class orderZkController {

    private static final String INVOKER_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String getPaymentZkInfo() {
        return restTemplate.getForObject(INVOKER_URL + "/payment/zk", String.class);
    }
}
