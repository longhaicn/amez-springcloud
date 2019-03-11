package com.union.aimei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
/**
 * app  learn服务应用程序
 * @author caizhaoming
 * @create 2018-05-08 17:31
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableTransactionManagement
@MapperScan(basePackages = "com.union.aimei.learn.mapper")
@ComponentScan(value = "com.union")
@EnableAsync
public class LearnServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnServiceApplication.class, args);
    }




}

