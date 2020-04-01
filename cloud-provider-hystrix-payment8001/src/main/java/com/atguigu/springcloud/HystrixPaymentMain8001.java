package com.atguigu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * HystrixPayment 启动类
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixPaymentMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentMain8001.class, args);
    }

    /**
     * 为了服务监控配置，与服务容器本身无关  springCloud审计后的坑
     * ServletRegistrationBean 因为Springcloud的默认路径不是/hystrix.stream
     * 配置如下servlet即可
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
