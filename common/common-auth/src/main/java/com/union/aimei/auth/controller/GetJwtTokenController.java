package com.union.aimei.auth.controller;

import com.union.aimei.common.vo.auth.RequestTokenVo;
import com.union.aimei.auth.service.JwtTokenService;
import com.union.common.utils.ResponseMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Jwt
 *
 * @author GaoWei
 * @time 2018/8/23 10:17
 */
@SuppressWarnings("AlibabaClassMustHaveAuthor")
@RestController
@RequestMapping(value = "/jwt")
public class GetJwtTokenController {

    @Resource
    private JwtTokenService jwtTokenService;

    /**
     * 创建令牌
     * @param requestTokenVo
     * @return
     */
    @ApiOperation(httpMethod = "POST",value = "获取令牌")
    @PostMapping(value = "/getToken")
    public ResponseMessage getToken(@RequestBody RequestTokenVo requestTokenVo){
         return jwtTokenService.createJwtToken(requestTokenVo);
    }


    /**
     * 校验token有效性
     * @param map
     * @return
     */
    @PostMapping(value = "/verifyToken")
    ResponseMessage verifyToken(@RequestBody Map<String,String> map){
        String identityType=map.get("identityType");
        String accessToken=map.get("accessToken");
        String refreshToken=map.get("refreshToken");
        return jwtTokenService.verifyJwtToken(accessToken,refreshToken,identityType);
    }
}
