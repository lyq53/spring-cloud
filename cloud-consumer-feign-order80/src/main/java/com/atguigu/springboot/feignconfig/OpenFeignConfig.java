package com.atguigu.springboot.feignconfig;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenFeignConfig 日志打印
 */
@Configuration
public class OpenFeignConfig {

    @Bean
    Logger.Level getOpenFeignLog() {
        //OpenFeign 有四个日志级别  FUll 是最全的    NONE, BASIC, HEADERS, FULL;
        return Logger.Level.FULL;
    }
}
