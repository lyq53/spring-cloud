package com.atguitu.springboot.service;

import com.atguitu.springboot.service.impl.OpenFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = OpenFeignServiceImpl.class)
public interface OpenFeignService {

    @GetMapping("/hystrix/getOk/{id}")
    String getPaymentInfo_ok(@PathVariable("id") Long id);

    @GetMapping("/hystrix/getTimeout/{id}")
    String getPaymentInfo_timeout(@PathVariable("id") Long id);
}
