package com.atguigu.springboot.service;

import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * openFeign service
 */
@Component
//开启openFeign  指定value 告诉 openFeign去找那个微服务
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OpenFeignService {

    @GetMapping("/payment/get/{id}")
    CommentResult<Payment> getData(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/feign/timeout")
    String getServerPort();
}
