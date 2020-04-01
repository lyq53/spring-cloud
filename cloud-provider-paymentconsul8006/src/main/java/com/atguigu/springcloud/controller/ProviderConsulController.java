package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommentResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * consul payment 控制器
 */
@RestController
@Slf4j
public class ProviderConsulController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/consul")
    public CommentResult getZk() {
        return new CommentResult(200, serverPort + "\\t" + UUID.randomUUID().toString(), null);
    }
}
