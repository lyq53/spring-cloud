package com.atguigu.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ApplicationContextConfig 配置类
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    //@LoadBalanced //给RestTemplate 开启负载功能
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
