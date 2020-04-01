package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalanced;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * 订单控制器
 */
@RestController
@Slf4j
public class OrderController {
    //单机版
    // private static final String PAYMENT_URL = "http://localhost:8001";
    //集群版 不再指定地址  使用eureka中注册服务的别名
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;//通过这个注解可以获取到集群上机器的信息
    @Resource
    private LoadBalanced loadBalanced;

    @GetMapping("/consumer/payment/create")
    public CommentResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommentResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommentResult.class);
    }

    @GetMapping(value = "consumer/payment/lb")
    public String getReport() {
        List<ServiceInstance> instancesList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instances = loadBalanced.instances(instancesList);
        URI uri = instances.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }
}

