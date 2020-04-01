package com.atguitu.springboot.controller;

import cn.hutool.core.util.IdUtil;
import com.atguitu.springboot.service.OpenFeignService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "getPaymentInfo_timeoutHandlerGlobal")  配合默认 fallback回调方法
public class OrderHystrixController {

    @Resource
    private OpenFeignService openFeignService;

    @GetMapping("/consumer/hystrix/getOk/{id}")
    public String getPaymentInfo_ok(@PathVariable("id") Long id) {
        String paymentInfo_ok = openFeignService.getPaymentInfo_ok(id);
        log.info(paymentInfo_ok);
        return paymentInfo_ok;
    }


    @GetMapping("/consumer/hystrix/getTimeout/{id}")
    @HystrixCommand(fallbackMethod = "getPaymentInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    //@HystrixCommand   不指定 则使用 默认的回调方法 可以减少代码
    public String getPaymentInfo_timeout(@PathVariable("id") Long id) {
        String paymentInfo_timeout = openFeignService.getPaymentInfo_timeout(id);
        log.info(paymentInfo_timeout);
        return paymentInfo_timeout;
    }

    public String getPaymentInfo_timeoutHandler(@PathVariable("id") Long id) {
        return "我是服务段兜底方案，支付为服务出错 或是超时 ";
    }

    //全局fallback方法
    public String getPaymentInfo_timeoutHandlerGlobal() {
        return "Global我是服务段兜底方案，支付为服务出错 或是超时 ";
    }



    //******************************************************服务熔断****************************************************



}
