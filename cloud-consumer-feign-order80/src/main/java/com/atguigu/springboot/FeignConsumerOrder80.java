package com.atguigu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignConsumerOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerOrder80.class, args);
    }
}
