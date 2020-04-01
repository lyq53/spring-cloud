package com.atguigu.springcloud;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * 集群服务器1
 * eureka 服务启动类
 *
 * @since 2020-3-14
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        //SpringApplication.run(EurekaMain7001.class, args);
        SpringApplication springApplication = new SpringApplication(EurekaMain7001.class);
        springApplication.setBanner(new Banner() {
            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
                System.out.println("启动成功");
            }
        });
        springApplication.setBannerMode(Banner.Mode.CONSOLE);
        springApplication.run();
    }
}
