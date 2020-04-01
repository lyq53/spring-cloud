package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommentResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 支付控制器
 *
 * @author liuyuqi39
 * @since 2020-3-11
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    //获取为服务提供者信息的注解
    @Resource
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommentResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入数据结果", result);
        if (result > 0) {
            return new CommentResult(200, "插入数据成功端口号：" + serverPort, result);
        } else {
            return new CommentResult(444, "插入数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommentResult getData(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);
        log.info("查询数据结果{}", payment);
        if (payment != null) {
            return new CommentResult(200, "查询数据成功 端口号" + serverPort, payment);
        } else {
            return new CommentResult(444, "没有对应记录,查询Id为" + id, null);
        }
    }

    /**
     * 获取服务相关信息
     *
     * @return
     */
    @GetMapping(value = "/payment/discovery")
    public Object getDiscovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(server -> {
            log.info("......eureka上注册的服务" + server);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(serviceInstance -> {
            log.info(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        });
        return this.discoveryClient;
    }

    /**
     * 获取端口号
     *
     * @return
     */
    @GetMapping(value = "/payment/lb")
    public String getReport() {
        return this.serverPort;
    }

    /**
     * openFeign 超时
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String getServerPort() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
