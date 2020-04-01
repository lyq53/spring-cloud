package com.atguigu.springboot.controller;

import com.atguigu.springboot.service.OpenFeignService;
import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {

    @Resource
    private OpenFeignService openFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommentResult<Payment> getData(@PathVariable("id") Long id){
        return openFeignService.getData(id);
    }

    /**
     * openFeign 超时
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String getServerPort() {
     return openFeignService.getServerPort();
    }

}
