package com.union.aimei.auth.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

/**
 * JWT工具类
 *
 * @author GaoWei
 * @time 2018/8/23 10:19
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@Component
public class JwtUtil {

    @Resource
    private JwtProperties jwtProperties;

    /**
     * 创建jwt
     *
     * @param map
     * @param
     * @return
     * @throws Exception
     */
    public String createJWT(Map<String, Object> map) throws Exception {
        return getJwtToken(map, jwtProperties.getExpirationTime());
    }

    /**
     * 创建刷新令牌
     *
     * @param map
     * @param
     * @return
     */
    public String createRefreshJWT(Map<String, Object> map) {
        return getJwtToken(map, jwtProperties.getRefreshExpTime());
    }

    /**
     * 创建token
     *
     * @param map
     * @param exptime
     * @return
     */
    private String getJwtToken(Map<String, Object> map, Integer exptime) {
        String secretKey = map.get("secretKey").toString();
        boolean isVisitorKey = secretKey.equals(jwtProperties.getVisitorSigningKey());
        String key = isVisitorKey ? jwtProperties.getVisitorSigningKey() : jwtProperties.getMemberSigningKey();
        LocalDateTime currentTime = LocalDateTime.now();
        return Jwts.builder()
                .setClaims(map)
                .setIssuer(jwtProperties.getIssuer())
                .setIssuedAt(Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant()))
                .setExpiration(Date.from(currentTime
                        .plusMinutes(exptime)
                        .atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    /**
     * 解密jwt
     *
     * @param jwt
     * @return
     * @throws Exception
     */
    public Claims parseJWT(String jwt, String identityType) throws Exception {
        // 签名秘钥，和生成的签名的秘钥一模一样
        SecretKey key = generalKey(identityType);
        // 得到DefaultJwtParser，设置签名的秘钥，设置需要解析的jwt
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public SecretKey generalKey(String identityType) {
        //本地的密码解码[B@152f6e2
        byte[] encodedKey = Base64.decodeBase64(getSigningKey(identityType));
        // 根据给定的字节数组使用AES加密算法构造一个密钥，使用 encodedKey中的始于且包含 0 到前 leng 个字节这是当然是所有。（后面的文章中马上回推出讲解Java加密和解密的一些算法）
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    private String getSigningKey(String identityType) {
        boolean isVisitorKey = "0".equals(identityType);
        return isVisitorKey ? jwtProperties.getVisitorSigningKey() : jwtProperties.getMemberSigningKey();
    }
}
