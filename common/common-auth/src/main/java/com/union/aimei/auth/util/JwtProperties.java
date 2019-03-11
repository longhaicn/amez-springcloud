package com.union.aimei.auth.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Jwt属性
 *
 * @author GaoWei
 * @time 2018/8/23 10:17
 */
@ConfigurationProperties(prefix = "jwt.params")
@Configuration
@Data
public class JwtProperties {
    /**
     * token的过期时间
     */
    private Integer expirationTime;

    /**
     * 发行人
     */
    private String issuer;

    /**
     * 游客UUID
     */
    private String visitorUUID;

    /**
     * 游客签名key
     */

    private String visitorSigningKey;

    /**
     * 会员签名KEY
     */
    private String memberSigningKey;

    /**
     * 刷新过期时间
     */
    private Integer refreshExpTime;
}
