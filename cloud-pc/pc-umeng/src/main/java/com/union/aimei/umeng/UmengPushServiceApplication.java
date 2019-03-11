package com.union.aimei.umeng;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author houji
 * @describe 
 * @time 2018/3/9,14:30
*/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableTransactionManagement
@MapperScan(basePackages = "com.union.aimei.umeng.mapper")
@ComponentScan("com.union")
public class UmengPushServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UmengPushServiceApplication.class, args);
    }
}
