package com.union.aimei.auth.service;

import com.union.aimei.common.vo.auth.RequestTokenVo;
import com.union.common.utils.ResponseMessage;

/**
 * @author GaoWei
 * @Date 18-7-24 下午3:30
 * @description
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
public interface JwtTokenService {

    /**
     * 创建JwtToken
     *
     * @param requestTokenVo
     * @return
     */
    ResponseMessage createJwtToken(RequestTokenVo requestTokenVo);

    /**
     * 校验jwtToken有效性
     *
     * @param accessToken
     * @param refreshToken
     * @param identityType
     * @return
     */
    ResponseMessage verifyJwtToken(String accessToken, String refreshToken, String identityType);

}
