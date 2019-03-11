package com.codingapi.tm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;


@SuppressWarnings("AlibabaClassMustHaveAuthor")
@SpringBootApplication
@EnableDiscoveryClient
@EnableRedisRepositories
public class TxManagerApplication {



    public static void main(String[] args) {
        SpringApplication.run(TxManagerApplication.class, args);
    }

}
