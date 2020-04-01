package com.atguigu.myruel;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义rule 规则
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
        //自定义随机规则
        return new RandomRule();
    }
}
