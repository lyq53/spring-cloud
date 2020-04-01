package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * consul 启动类
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderConsulMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderConsulMain8006.class, args);
    }
}
