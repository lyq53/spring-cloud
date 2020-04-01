package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * gateway 网关启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9528 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9528.class, args);
    }
}
