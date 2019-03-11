package com.union.aimei.auth.service.impl;

import com.union.aimei.auth.feign.MemberFeign;
import com.union.aimei.auth.util.JwtProperties;
import com.union.aimei.common.constant.auth.AuthCode;
import com.union.aimei.common.constant.common.CommonConstant;
import com.union.aimei.common.vo.auth.RequestTokenVo;
import com.union.aimei.auth.service.JwtTokenService;
import com.union.aimei.auth.util.JwtUtil;
import com.union.common.utils.ResponseMessage;
import com.union.common.utils.ResponseMessageFactory;
import com.union.common.utils.ResponseUtil;
import com.union.common.utils.exception.ServerException;
import com.union.redis.RedisService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt
 *
 * @author GaoWei
 * @time 2018/8/23 10:15
 */
@Service
public class JwtTokenServiceImpl implements JwtTokenService {

    @Resource
    private MemberFeign memberFeign;
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private RedisService redisService;
    @Resource
    private JwtProperties jwtProperties;

    @Override
    public ResponseMessage createJwtToken(RequestTokenVo requestTokenVo) {
        Map<String, String> resultMap = new HashMap<>(16);
        try {
            Map<String, Object> claimMap = new HashMap<>(16);
            claimMap.put("uuid", requestTokenVo.getUuid());
            String accessToken = jwtUtil.createJWT(claimMap);
            String refreshToken = jwtUtil.createRefreshJWT(claimMap);
            resultMap.put("accessToken", accessToken);
            resultMap.put("refreshToken", refreshToken);
        } catch (Exception e) {
            throw new ServerException(500, "创建Token异常");
        }
        ResponseMessage res = new ResponseMessage();
        res.setData(resultMap);
        return res;
    }

    @Override
    public ResponseMessage verifyJwtToken(String accessToken, String refreshToken, String identityType) {
        ResponseMessage res = new ResponseMessage();
        try {
            Claims claims = jwtUtil.parseJWT(accessToken, identityType);
            //校验
            String uuid = claims.get("uuid").toString();
            if (CommonConstant.Common.IdentityType.MEMBER.equals(identityType)) {
                ResponseMessage verifyMsg = memberFeign.queryMemberInfoByUuid(uuid);
                if (ResponseUtil.isFail(verifyMsg)) {
                    res.setCode(401);
                    res.setMessage("令牌校验错误,没有权限通行");
                }
            } else if (CommonConstant.Common.IdentityType.VISITOR.equals(identityType)) {
                boolean isTrue = jwtProperties.getVisitorSigningKey().equals(uuid);
                if (!isTrue) {
                    res.setCode(401);
                    res.setMessage("令牌校验错误,没有权限通行");
                }
            }
            return res;
        } catch (ExpiredJwtException expiredJwtException) {
            //accessToken过期,拿refreshToken换新的令牌,若刷新令牌也过期则需要重新请求令牌
            return getAccessTokenByRefreshToken(refreshToken, identityType);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException(500, "解析token异常");
        }
    }

    /**
     * 通过刷新令牌换取accessToken
     *
     * @param refreshToken
     * @return
     */
    private ResponseMessage getAccessTokenByRefreshToken(String refreshToken, String identityType) {
        ResponseMessage res = ResponseMessageFactory.newInstance();
        try {
            Claims claims = jwtUtil.parseJWT(refreshToken, identityType);
            String uuid = claims.get("uuid").toString();
            Map<String, Object> claimMap = new HashMap<>(16);
            claimMap.put("uuid", uuid);
            String accessToken = jwtUtil.createJWT(claimMap);
            res.setCode(AuthCode.ACCESS_TOKEN_EXPIRED.getCode());
            res.setData(accessToken);
            res.setMessage(AuthCode.ACCESS_TOKEN_EXPIRED.getMessage());
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
            throw new ServerException(AuthCode.REFRESH_TOKEN_EXPIRED.getCode(), AuthCode.REFRESH_TOKEN_EXPIRED.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException(500, "解析token异常");
        }
        return res;
    }
}
