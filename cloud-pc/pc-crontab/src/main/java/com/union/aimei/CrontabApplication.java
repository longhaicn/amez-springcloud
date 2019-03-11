package com.union.aimei;

import com.union.aimei.pc.crontab.config.CrontabRunner;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * CrontabApplication
 *
 * @author liufeihua
 * @date 2018/3/13 16:49
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableTransactionManagement
@MapperScan(basePackages = "com.union.aimei.pc.crontab.mapper")
@ComponentScan("com.union")
public class CrontabApplication {



    /**
     * 应用启动入口
     *
     * @param args
     */
    public static void main(String[] args) {
      SpringApplication.run(CrontabApplication.class, args);

    }

    @Bean
    public CrontabRunner crontabRunner(){
        return new CrontabRunner();
    }

}
