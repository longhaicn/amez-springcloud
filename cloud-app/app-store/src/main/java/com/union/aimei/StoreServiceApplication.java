package com.union.aimei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 店铺服务应用程序
 *
 * @author liurenkai
 * @time 2018/4/11 14:30
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableTransactionManagement
@MapperScan(basePackages = "com.union.aimei.store.mapper")
@ComponentScan(value = "com.union")
public class StoreServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreServiceApplication.class, args);
    }
}
