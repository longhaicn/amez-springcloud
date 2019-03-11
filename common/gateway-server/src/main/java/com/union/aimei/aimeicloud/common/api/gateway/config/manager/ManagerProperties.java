package com.union.aimei.aimeicloud.common.api.gateway.config.manager;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/**
 * @author liufeihua
 */
@Configuration
@ConfigurationProperties(prefix = "management.union.gateway")
@Data
public class ManagerProperties {

    @ApiModelProperty(value = "网关校验是否开启")
    private boolean enabled;

}
