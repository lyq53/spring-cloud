package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommentResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/zk")
    public CommentResult getZk() {
        return new CommentResult(200, serverPort + "\t" + UUID.randomUUID().toString(), null);
    }
}
