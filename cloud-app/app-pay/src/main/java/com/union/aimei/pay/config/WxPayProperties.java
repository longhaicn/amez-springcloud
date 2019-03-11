package com.union.aimei.pay.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:47
  * @description
  */
@Data
@ConfigurationProperties(prefix = "com.unioninfo.weixin.pay")
public class WxPayProperties {

    private User user=new User();
    private Beautician beautician=new Beautician();
    private StoreOwner storeOwner=new StoreOwner();

    /**
     * 用户端微信参数配置
     */
    @Data
    @NoArgsConstructor
    public static class User{
        /**
         * 设置微信的appid
         */
        private String appId;

        /**
         * 微信支付商户号
         */
        private String mchId;

        /**
         * 微信支付商户密钥
         */
        private String mchKey;

        /**
         * 服务商模式下的子商户公众账号ID，普通模式请不要配置，请在配置文件中将对应项删除
         */
        private String subAppId;

        /**
         * 服务商模式下的子商户号，普通模式请不要配置，最好是请在配置文件中将对应项删除
         */
        private String subMchId;

        /**
         * apiclient_cert.p12的文件的绝对路径
         */
        private String keyPath;
        /**
         * 回调通知地址
         */
        private String notifyUrl;

        /**
         * 用户端用户端实际ip
         * @return
         */
        private String createIp;
        /**
         * 交易类型
         */
        private String tradeType;

    }
    /**
     * 美容师端微信参数配置
     */
    @Data
    @NoArgsConstructor
    public static class Beautician{
        /**
         * 设置微信的appid
         */
        private String appId;

        /**
         * 微信支付商户号
         */
        private String mchId;

        /**
         * 微信支付商户密钥
         */
        private String mchKey;

        /**
         * 服务商模式下的子商户公众账号ID，普通模式请不要配置，请在配置文件中将对应项删除
         */
        private String subAppId;

        /**
         * 服务商模式下的子商户号，普通模式请不要配置，最好是请在配置文件中将对应项删除
         */
        private String subMchId;

        /**
         * apiclient_cert.p12的文件的绝对路径
         */
        private String keyPath;
        /**
         * 回调通知地址
         */
        private String notifyUrl;

        /**
         * 用户端用户端实际ip
         * @return
         */
        private String createIp;
        /**
         * 交易类型
         */
        private String tradeType;

    }
    /**
     * 店长端微信参数配置
     */
    @Data
    @NoArgsConstructor
    public static class StoreOwner{
        /**
         * 设置微信的appid
         */
        private String appId;

        /**
         * 微信支付商户号
         */
        private String mchId;

        /**
         * 微信支付商户密钥
         */
        private String mchKey;

        /**
         * 服务商模式下的子商户公众账号ID，普通模式请不要配置，请在配置文件中将对应项删除
         */
        private String subAppId;

        /**
         * 服务商模式下的子商户号，普通模式请不要配置，最好是请在配置文件中将对应项删除
         */
        private String subMchId;

        /**
         * apiclient_cert.p12的文件的绝对路径
         */
        private String keyPath;
        /**
         * 回调通知地址
         */
        private String notifyUrl;

        /**
         * 用户端用户端实际ip
         * @return
         */
        private String createIp;
        /**
         * 交易类型
         */
        private String tradeType;

    }

}
