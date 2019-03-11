package com.union.aimei.pay.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:46
  * @description
  */
@Configuration
@EnableConfigurationProperties({AliPayProperties.class})
@ConditionalOnClass({AliPayParams.class})
@ConditionalOnProperty(prefix = "com.unioninfo.alipay", value = {"enabled"}, matchIfMissing = true)
public class AliPayConfiguration {
    @Resource
    private AliPayProperties aliPayProperties;

    @Bean
    @ConditionalOnMissingBean({AliPayParams.class})
    public AliPayParams aliPayParams() {
        AliPayParams aliPayParams = new AliPayParams();
        aliPayParams.setAppid(this.aliPayProperties.getAppid());
        aliPayParams.setAlipayPublicKey(this.aliPayProperties.getAlipayPublicKey());
        aliPayParams.setMcloudApiDomain(this.aliPayProperties.getMcloudApiDomain());
        aliPayParams.setOpenApiDomain(this.aliPayProperties.getOpenApiDomain());
        aliPayParams.setPid(this.aliPayProperties.getPid());
        aliPayParams.setPrivateKey(this.aliPayProperties.getPrivateKey());
        aliPayParams.setPublicKey(this.aliPayProperties.getPublicKey());
        aliPayParams.setSignType(this.aliPayProperties.getSignType());
        aliPayParams.setMaxCancelRetry(this.aliPayProperties.getMaxCancelRetry());
        aliPayParams.setCancelDuration(this.aliPayProperties.getCancelDuration());
        aliPayParams.setMaxQueryRetry(this.aliPayProperties.getMaxQueryRetry());
        aliPayParams.setQueryDuration(this.aliPayProperties.getQueryDuration());
        aliPayParams.setHeartbeatDelay(this.aliPayProperties.getHeartbeatDelay());
        aliPayParams.setHeartbeatDuration(this.aliPayProperties.getHeartbeatDuration());
        aliPayParams.setNotifyUrl(this.aliPayProperties.getNotifyUrl());
        return aliPayParams;
    }
}