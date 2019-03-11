package com.union.aimei;

import com.union.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * SystemServiceApplication
 *
 * @author liufeihua
 * @date 2017/12/4 16:03
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2Doc
@EnableFeignClients
@EnableTransactionManagement
@MapperScan(value = {"com.union.aimei.pc.system.mapper"})
@ComponentScan("com.union")
@EnableAsync
public class SystemServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemServiceApplication.class, args);
    }
}
