package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 订单 consul 控制器
 */
@RestController
@Slf4j
public class OrderConsulController {
    private static final String INVOKER_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String getPaymentZkInfo() {
        return restTemplate.getForObject(INVOKER_URL + "/payment/consul", String.class);
    }
}
