package com.union.aimei.aimeicloud.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author liufeihua
 */
@SpringBootApplication
@EnableEurekaServer
public class AimeiCloudCommonEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AimeiCloudCommonEurekaApplication.class, args);
    }
}
