package com.atguitu.springboot.service.impl;

import com.atguitu.springboot.service.OpenFeignService;
import org.springframework.stereotype.Component;

/**
 * 服务降级 结合 openFeign配置  fallback类
 */
@Component
public class OpenFeignServiceImpl implements OpenFeignService {

    @Override
    public String getPaymentInfo_ok(Long id) {
        return "getPaymentInfo_ok,fallBack:类";
    }

    @Override
    public String getPaymentInfo_timeout(Long id) {
        return "getPaymentInfo_timeout,fallBack:类";
    }

}


