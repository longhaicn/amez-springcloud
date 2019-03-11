package com.union.aimei.app.api.conf.permission;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author gaowei
 */
@Configuration
@ConfigurationProperties(prefix = "com.union.aimei.permission")
@Data
public class PermissionSwithchProperties {

    @ApiModelProperty(value = "开关")
    private boolean enabled;
}
