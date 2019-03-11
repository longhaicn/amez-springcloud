package com.union.aimei.pay.config;


import com.github.binarywang.wxpay.config.WxPayConfig;
import com.github.binarywang.wxpay.service.WxPayService;
import com.github.binarywang.wxpay.service.impl.WxPayServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:47
  * @description
  */
@Configuration
@ConditionalOnClass(WxPayService.class)
@EnableConfigurationProperties(WxPayProperties.class)
public class WxPayConfiguration {

    @Autowired
    private WxPayProperties properties;


    /**
     * 用户端服务Bean
     * @return
     */
    @Bean(name = "wxPayService")
    public WxPayService wxPayService() {
        WxPayService wxPayService = new WxPayServiceImpl();
        WxPayConfig payConfig = new WxPayConfig();
        payConfig.setAppId(this.properties.getUser().getAppId());
        payConfig.setMchId(this.properties.getUser().getMchId());
        payConfig.setMchKey(this.properties.getUser().getMchKey());
        payConfig.setSubAppId(StringUtils.trimToNull(this.properties.getUser().getSubAppId()));
        payConfig.setSubMchId(StringUtils.trimToNull(this.properties.getUser().getSubMchId()));
        payConfig.setNotifyUrl(this.properties.getUser().getNotifyUrl());
        payConfig.setKeyPath(this.properties.getUser().getKeyPath());
        payConfig.setTradeType(this.properties.getUser().getTradeType());
        wxPayService.setConfig(payConfig);
        return wxPayService;
    }

    /**
     * 美容师端端服务Bean
     * @param
     * @return
     */
    @Bean(name = "wxPayBeauticianService")
    public WxPayService wxPayBeauticianService() {
        WxPayService wxPayService = new WxPayServiceImpl();
        WxPayConfig beauticianConfig = new WxPayConfig();
        beauticianConfig.setAppId(this.properties.getBeautician().getAppId());
        beauticianConfig.setMchId(this.properties.getBeautician().getMchId());
        beauticianConfig.setMchKey(this.properties.getBeautician().getMchKey());
        beauticianConfig.setSubAppId(StringUtils.trimToNull(this.properties.getBeautician().getSubAppId()));
        beauticianConfig.setSubMchId(StringUtils.trimToNull(this.properties.getBeautician().getSubMchId()));
        beauticianConfig.setNotifyUrl(this.properties.getBeautician().getNotifyUrl());
        beauticianConfig.setKeyPath(this.properties.getBeautician().getKeyPath());
        beauticianConfig.setTradeType(this.properties.getBeautician().getTradeType());
        wxPayService.setConfig(beauticianConfig);
        return wxPayService;
    }

    /**
     * 用户端服务Bean
     * @param
     * @return
     */
    @Bean(name = "wxPayStoreOwnerService")
    public WxPayService wxPayStoreOwnerService() {
        WxPayService wxPayService = new WxPayServiceImpl();
        WxPayConfig storeOwnerConfig = new WxPayConfig();
        storeOwnerConfig.setAppId(this.properties.getStoreOwner().getAppId());
        storeOwnerConfig.setMchId(this.properties.getStoreOwner().getMchId());
        storeOwnerConfig.setMchKey(this.properties.getStoreOwner().getMchKey());
        storeOwnerConfig.setSubAppId(StringUtils.trimToNull(this.properties.getStoreOwner().getSubAppId()));
        storeOwnerConfig.setSubMchId(StringUtils.trimToNull(this.properties.getStoreOwner().getSubMchId()));
        storeOwnerConfig.setNotifyUrl(this.properties.getStoreOwner().getNotifyUrl());
        storeOwnerConfig.setTradeType(this.properties.getStoreOwner().getTradeType());
        storeOwnerConfig.setKeyPath(this.properties.getStoreOwner().getKeyPath());
        wxPayService.setConfig(storeOwnerConfig);
        return wxPayService;
    }
}
