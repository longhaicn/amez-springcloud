package com.union.aimei.remote.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;


/**
 * @author GaoWei
 * @describe 请求参数properties
 * @time 2018/4/11,11:06
*/
@Data
@Configuration
@ConfigurationProperties(prefix = "amez.request.info")
@ApiModel(value = "参数配置")
public class AmezRequestProperties {

    @ApiModelProperty(value = "开发环境")
    private Dev dev=new Dev();
    @ApiModelProperty(value = "正式环境")
    private Pro pro=new Pro();
    @ApiModelProperty(value = "路径")
    private Map<String,String> path;
    @ApiModelProperty(value = "APP系统，默认200")
    private String appSystem;
    @ApiModelProperty(value = "加密字符串")
    private String security;
    @ApiModelProperty(value = "秘钥")
    private String accessKey;
    /**
     * 开发环境
     */
    @Data
    @NoArgsConstructor
    public static class Dev{
        private String host;
        private String port;
    }

    /**
     * 线上环境
     */
    @Data
    @NoArgsConstructor
    public static class Pro{
        private String host;
        private String port;
    }
}
