package com.union.aimei.umeng.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author houji
 * @date 2018/3/8  16:43
 */
@Component
@ConfigurationProperties(prefix = "push.umeng.android.consumer")
public class ConsumerAndroidProperties {
    /**
     * 应用唯一标识。
     * 友盟消息推送服务提供的appkey和
     * 友盟统计分析平台使用的同一套appkey。
     */
    private String appKey;
    /**
     * 服务器秘钥，
     * 用于服务器端调用API请求时对发送内容做签名验证。
     */
    private String appMasterSecret;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppMasterSecret() {
        return appMasterSecret;
    }

    public void setAppMasterSecret(String appMasterSecret) {
        this.appMasterSecret = appMasterSecret;
    }
}
