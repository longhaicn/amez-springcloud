package com.union.aimei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 财务服务应用程序
 *
 * @author liurenkai
 * @time 2018/1/2 17:38
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableTransactionManagement
@MapperScan(basePackages = "com.union.aimei.pc.financial.mapper")
@ComponentScan("com.union")
public class FinancialServiceApplication {
    /**
     * 应用启动入口
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(FinancialServiceApplication.class, args);
    }
}
