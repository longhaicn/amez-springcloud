package com.union.aimei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author houji
 * @date 2018/3/10  18:28
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableTransactionManagement
@EnableFeignClients
@MapperScan(basePackages = "com.union.aimei.umeng.mapper")
@ComponentScan(value = "com.union")
public class UmengPushServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmengPushServiceApplication.class, args);
    }
}
