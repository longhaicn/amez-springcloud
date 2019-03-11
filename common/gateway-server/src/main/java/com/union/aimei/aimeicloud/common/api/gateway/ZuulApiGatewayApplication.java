package com.union.aimei.aimeicloud.common.api.gateway;

import com.union.aimei.aimeicloud.common.api.gateway.config.manager.RequestTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
/**
 * @author liufeihua
 */
@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
public class ZuulApiGatewayApplication {

    @Bean
    public RequestTokenFilter tokenFilter(){
        return new RequestTokenFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ZuulApiGatewayApplication.class, args);
    }
}
