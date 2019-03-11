package com.union.aimei.rule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 规则引擎
 *
 * @author liurenkai
 * @time 2018/5/10 16:51
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableTransactionManagement
@MapperScan(basePackages = "com.union.aimei.rule.mapper")
@ComponentScan(value = "com.union")
public class RuleServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RuleServiceApplication.class, args);
    }
}
