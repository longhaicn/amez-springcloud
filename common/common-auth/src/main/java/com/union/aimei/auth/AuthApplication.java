package com.union.aimei.auth;

import com.union.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 认证应用程序
 *
 * @author liurenkai
 * @time 2018/8/23 10:20
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@SpringBootApplication(scanBasePackages = "com.union")
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@EnableSwagger2Doc
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
