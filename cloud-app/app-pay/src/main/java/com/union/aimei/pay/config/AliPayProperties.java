package com.union.aimei.pay.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

/**
  * @author GaoWei
  * @Date 18-8-13 下午2:47
  * @description
  */
@ConfigurationProperties(prefix = "com.unioninfo.alipay")
public class AliPayProperties {
    private String openApiDomain;
    private String mcloudApiDomain;
    private String pid;
    private String appid;
    private String privateKey;
    private String publicKey;
    private String alipayPublicKey;
    private String signType;
    private int maxQueryRetry;
    private long queryDuration;
    private int maxCancelRetry;
    private long cancelDuration;
    private long heartbeatDelay;
    private long heartbeatDuration;
    private String notifyUrl;

    public String getNotifyUrl() {
        return this.notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getOpenApiDomain() {
        return this.openApiDomain;
    }

    public void setOpenApiDomain(String openApiDomain) {
        this.openApiDomain = openApiDomain;
    }

    public String getMcloudApiDomain() {
        return this.mcloudApiDomain;
    }

    public void setMcloudApiDomain(String mcloudApiDomain) {
        this.mcloudApiDomain = mcloudApiDomain;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getAppid() {
        return this.appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPrivateKey() {
        return this.privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getAlipayPublicKey() {
        return this.alipayPublicKey;
    }

    public void setAlipayPublicKey(String alipayPublicKey) {
        this.alipayPublicKey = alipayPublicKey;
    }

    public String getSignType() {
        return this.signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public int getMaxQueryRetry() {
        return this.maxQueryRetry;
    }

    public void setMaxQueryRetry(int maxQueryRetry) {
        this.maxQueryRetry = maxQueryRetry;
    }

    public long getQueryDuration() {
        return this.queryDuration;
    }

    public void setQueryDuration(long queryDuration) {
        this.queryDuration = queryDuration;
    }

    public int getMaxCancelRetry() {
        return this.maxCancelRetry;
    }

    public void setMaxCancelRetry(int maxCancelRetry) {
        this.maxCancelRetry = maxCancelRetry;
    }

    public long getCancelDuration() {
        return this.cancelDuration;
    }

    public void setCancelDuration(long cancelDuration) {
        this.cancelDuration = cancelDuration;
    }

    public long getHeartbeatDelay() {
        return this.heartbeatDelay;
    }

    public void setHeartbeatDelay(long heartbeatDelay) {
        this.heartbeatDelay = heartbeatDelay;
    }

    public long getHeartbeatDuration() {
        return this.heartbeatDuration;
    }

    public void setHeartbeatDuration(long heartbeatDuration) {
        this.heartbeatDuration = heartbeatDuration;
    }
}
