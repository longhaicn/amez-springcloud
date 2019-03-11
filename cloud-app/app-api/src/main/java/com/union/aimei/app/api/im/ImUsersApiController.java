package com.union.aimei.app.api.im;

import com.union.aimei.common.feign.app.im.ImUsersFeign;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * IM用户
 *
 * @author liurenkai
 * @time 2018/8/13 15:16
 */
@Api(tags = "IM用户")
@RestController
@RequestMapping(value = "imUsers")
public class ImUsersApiController {
    @Resource
    private ImUsersFeign imUsersFeign;
}