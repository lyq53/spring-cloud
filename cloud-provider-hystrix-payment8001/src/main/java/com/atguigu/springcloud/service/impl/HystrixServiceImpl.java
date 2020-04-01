package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.HystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HystrixServiceImpl implements HystrixService {

    @Override
    public String getPaymentInfo_ok(Long id) {
        return "当前线程" + Thread.currentThread().getName() + "getPaymentInfo_ok 传入Id=" + id;
    }

    @Override
    @HystrixCommand(fallbackMethod = "getPaymentInfo_timeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String getPaymentInfo_timeout(Long id) {
        int time = 2;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前线程" + Thread.currentThread().getName() + " getPaymentInfo_timeout 传入Id=" + id + "休眠时间" + time;
    }

    @Override
    public String getPaymentInfo_timeoutHandler(Long id) {
        return "当前线程" + Thread.currentThread().getName() + "getPaymentInfo_timeoutHandler" + "服务异常/超时";
    }

    /************************************************************服务熔断代码**********************************************************************/
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到多少后跳匝
    })
    @Override
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("**********id 不可以为 复数****************");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(Long id) {
        return "id 不能是负数。请稍后在访问 😭";
    }
}
