package com.union.aimei.pc.system.utils;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author liufeihua
 */
public class BaseAntispam {

    @Value("${safe.accessKeyId}")
    public String accessKeyId;
    @Value("${safe.accessKeySecret}")
    public String accessKeySecret;
    @Value("${safe.regionId}")
    public String regionId;

    protected String getDomain() {
        String s = "cn-shanghai";
        if (s.equals(regionId)) {
            return "green.cn-shanghai.aliyuncs.com";
        }

        String s1 = "cn-hangzhou";
        if (s1.equals(regionId)) {
            return "green.cn-hangzhou.aliyuncs.com";
        }

        String local = "local";
        if (local.equals(regionId)) {
            return "api.green.alibaba.com";
        }

        return "green.cn-shanghai.aliyuncs.com";
    }

    protected String getEndPointName() {
        return regionId;
    }

}
